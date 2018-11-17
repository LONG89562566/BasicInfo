package com.info.admin.controller.sys.menu;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.SysMenu;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.SysMenuService;
import com.info.admin.shiro.UserRealm;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.SysMenu;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.SysMenuService;
import com.info.admin.shiro.UserRealm;

/**
 * 菜单Controller
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class MenuController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	@Autowired
	private SysMenuService menuService;
	@Autowired
	private UserRealm userRealm;
	
	/**
	 * 菜单列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/menu/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("menu:query")
	public String menuList(HttpServletRequest request, HttpServletResponse response,Model model) {
		return "sys/menu/menuList";
	}

	/**
	 * 菜单列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/menu/list/desktop", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("menu:query")
	public String menuListDesktop(HttpServletRequest request, HttpServletResponse response,Model model) {
		return "sys/menu/menuListDesktop";
	}
	
	/**
	 * 菜单树
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/menu/tree", method = { RequestMethod.GET, RequestMethod.POST })
	public Object menuTree(HttpServletRequest request, HttpServletResponse response,Model model,Integer roleId) {
		List<SysMenu> menuList = null;
		if(roleId==null){
			menuList = menuService.getAllMenu();
		}else{
			menuList = menuService.getAllMenuByRoleId(roleId);
		}
		return menuService.menuTree(menuList, 0);
	}
	
	/*
	 *添加、修改菜单
	 */
	@RequestMapping(value = "/menu/saveOrUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody SysMenu saveOrUpUnit(HttpServletRequest request, HttpServletResponse response,@ModelAttribute SysMenu menu) {
		try {
			if(null == menu.getMenuId()){
				//新增
				menuService.insertMenu(menu);
			} else {
				//修改
				menuService.updateMenu(menu);
			}
			return menu;
		} catch (Exception e) {
			return null;
		}
	}
	
	/*
	 * 根据id查找菜单
	 */
	@RequestMapping(value = "/menu/getMenuById", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody SysMenu getMenu(HttpServletRequest request, HttpServletResponse response,int menuId) {
		SysMenu menu = menuService.getMenuById(menuId);
		return menu;
	}

	/**
	 * 设置角色菜单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/menu/setRoleMenu", method = { RequestMethod.GET, RequestMethod.POST })
	public String setRoleMenu(HttpServletRequest request, HttpServletResponse response,Model model,Integer roleId) {
		List<SysMenu> menuList = menuService.getAllMenuByRoleId(roleId);
		model.addAttribute("menuList", menuList);
		model.addAttribute("roleId", roleId);
		return "sys/menu/roleMenuList";
	}
	
	/**
	 * 保存角色菜单
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/menu/saveRoleMenu", method = { RequestMethod.POST })
	public JsonResult saveRoleMenu(HttpServletRequest request, HttpServletResponse response, Integer roleId, String menuIds) {
		try{
			if(null == menuIds || "".equals(menuIds)){
				return new JsonResult(JsonResultCode.FAILURE, "请选择菜单","");
			}
			List<String> menuIdList = Arrays.asList(menuIds.split(","));
			int result = menuService.insertRoleMenu(roleId, menuIdList);
			//清除资源权限缓存
			userRealm.clearCache();
			if(result > 0){
				return new JsonResult(JsonResultCode.SUCCESS, "添加菜单成功","");
			}else{
				return new JsonResult(JsonResultCode.FAILURE, "添加菜单失败了","");
			}
		}catch(Exception ex){
			logger.error("[MenuController][saveRoleMenu] exception :",ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}
	
	/**
	 * 删除菜单
	 */
	@ResponseBody
	@RequestMapping("/menu/deleteMenu")
	public JsonResult deleteMenu(HttpServletRequest request,HttpServletResponse response,Integer menuId) {
		try{
			if(null == menuId){
				return new JsonResult(JsonResultCode.FAILURE, "请选择菜单","");
			}
			//查询菜单是否还有其他的子菜单
			List<SysMenu> menus = menuService.getChildrenMenu(menuId);
			if(CollectionUtils.isNotEmpty(menus)){
				return new JsonResult(JsonResultCode.FAILURE, "该菜单下有子菜单,请先删除子菜单","");
			}
			int result = menuService.deleteMenu(menuId);
			//清除资源权限缓存
			userRealm.clearCache();
			if(result > 0){
				return new JsonResult(JsonResultCode.SUCCESS, "删除成功","");
			}else{
				return new JsonResult(JsonResultCode.FAILURE, "删除失败","");
			}
		}catch(Exception ex){
			logger.error("[MenuController][saveRoleMenu] exception :",ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}
}