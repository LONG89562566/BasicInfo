package com.info.admin.controller.sys.role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.SysRole;
import com.info.admin.service.SysRoleService;
import com.info.admin.utils.PageUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.SysRole;
import com.info.admin.service.SysRoleService;
import com.info.admin.utils.PageUtil;

import net.sf.json.JSONObject;

/**
 * 系统用户信息操作
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class RoleController extends BaseController {

	@Autowired
	private SysRoleService roleService;
	/**
	 * 角色列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/role/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("role:query")
	public String roleList(HttpServletRequest request, HttpServletResponse response,Model model) {
		// 获取分页当前的页码
		int currentPageNum = this.getPageNum(request);
		// 获取分页的大小
		int currentPageSize = this.getPageSize(request);
		PageUtil paginator = roleService.getPageResult( currentPageNum, currentPageSize);
		model.addAttribute("paginator", paginator);
		return "sys/role/roleList";
	}
	
	/*
	 *添加、修改角色
	 */
	@RequestMapping(value = "/role/saveOrUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveOrUpSysRole(HttpServletRequest request, HttpServletResponse response,SysRole role) {
		if(null == role.getId()){
			//新增
			roleService.insertSysRole(role);
		} else {
			//修改
			roleService.updateSysRole(role);
		}
		return "redirect:/admin/role/list";
	}
	
	/*
	 * 根据id查找角色
	 */
	@RequestMapping(value = "/role/getSysRoleById", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody SysRole getSysRole(HttpServletRequest request, HttpServletResponse response,int id) {
		SysRole role = roleService.getSysRoleById(id);
		return role;
	}
	
	/*
	 * 取得所有在用的角色
	 */
	@ResponseBody
	@RequestMapping(value = "/role/getAllSysRoleByStatus", method = { RequestMethod.GET, RequestMethod.POST })
	public Object getAllSysRoleByStatus(HttpServletRequest request, HttpServletResponse response) {
		List<SysRole> roleList = roleService.getAllSysRoleByStatus();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleList", roleList);
		return JSONObject.fromObject(map);
	}
	
}
