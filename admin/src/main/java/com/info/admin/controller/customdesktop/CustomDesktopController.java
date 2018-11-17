package com.info.admin.controller.customdesktop;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.ActiveSysUser;
import com.info.admin.entity.CustomDesktop;
import com.info.admin.entity.SysMenu;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.CustomDesktopService;
import com.info.admin.service.SysMenuService;
import com.info.admin.utils.PageUtil;
import com.info.admin.vo.CustomDesktopVo;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author administrator  
 * @date 2018-11-13 16:23:57 
 * @describe 自定义桌面 Controller
 */
@Controller
@RequestMapping("/admin/customDesktop")
public class CustomDesktopController extends BaseController{	
	
    private static final Logger logger = LoggerFactory.getLogger(CustomDesktopController.class);

    @Autowired
    private CustomDesktopService service;
    @Autowired
    private SysMenuService sysMenuService;
     /**
     *查询自定义桌面列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("customDesktop:query")
    public String getCustomDesktopList(HttpServletRequest request, @ModelAttribute CustomDesktop entity, Model model) {
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("customDesktop", entity);
        return "customdesktop/listCustomDesktop";
    }

    /**
     *查询自定义桌面列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/myDesktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("customDesktop:myDesktop")
    public String myDesktop(HttpServletRequest request, Model model) {
        List<CustomDesktopVo> cdvLs = service.myDesktop(getLoginUserId(request));
        model.addAttribute("customDesktopLs", cdvLs);
        if(cdvLs == null || cdvLs.size() == 0){
            return "customdesktop/setCustomDesktop";
        }
        return "customdesktop/myDesktop";
    }

    /**
     *查询自定义桌面列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/setDesktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("customDesktop:setDesktop")
    public String setCustomDesktop(HttpServletRequest request, Model model) {
        model.addAttribute("customDesktopLs", service.myDesktop(getLoginUserId(request)));
        return "customdesktop/setCustomDesktop";
    }

    /**
     * 菜单树
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/menuTree", method = { RequestMethod.GET, RequestMethod.POST })
    public Object menuTree(HttpServletRequest request, HttpServletResponse response, Model model, Integer roleId) {
        List<SysMenu> menuList = sysMenuService.getAllMenuDesktopByUserId(getLoginUserId(request));
        return sysMenuService.menuTree(menuList);
    }
    /**
     *查询自定义桌面列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @ResponseBody
    @RequestMapping(value = "/myDesktopLs", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult myDesktopLs(HttpServletRequest request, Model model) {
        logger.info("[CustomDesktopController][myDesktopLs] 查询CustomDesktopVo数组对象:");
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.myDesktop(getLoginUserId(request)));
        } catch (Exception e) {
            logger.error("[CustomDesktopController][myDesktopLs] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 保存角色菜单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveDesktopMenu", method = { RequestMethod.POST })
    public JsonResult saveDesktopMenu(HttpServletRequest request, HttpServletResponse response) {
        try{
            String[] menuIds = request.getParameterValues("menuIds[]");
            String[] menuNames = request.getParameterValues("menuNames[]");
            String[] widths = request.getParameterValues("widths[]");
            String[] heights = request.getParameterValues("heights[]");
            String[] seqs = request.getParameterValues("seqs[]");

            if(null == menuIds || menuIds.length == 0){
                return new JsonResult(JsonResultCode.FAILURE, "请选择菜单","");
            }
            ActiveSysUser user = getLoginUser(request);
            int result = service.insertBatchDesktop(user.getId(), menuIds, menuNames, widths, heights, seqs);
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
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,String desktopId,Model model){
        try{
            if(null != desktopId){
                //根据id查询系统用户
                CustomDesktop customDesktop = service.getCustomDesktopById(desktopId);
                model.addAttribute("customDesktop", customDesktop);
            }
            model.addAttribute("desktopId", desktopId);
            return "customdesktop/addCustomDesktop";
        }catch(Exception e){
            logger.error("[CustomDesktopController][addOrEdit]: desktopId="+desktopId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改CustomDesktop对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-13 16:23:57 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertAndUpdate(HttpServletRequest request,CustomDesktop entity) {
        logger.info("[CustomDesktopController][insertAndUpdate] 新增或者修改CustomDesktop对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            // 通过id来判断是新增还是修改
            if (null != entity.getDesktopId()) {
                result = service.update(entity);
            } else {
                result = service.insert(entity);
            }
            if (result > 0) {
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[CustomDesktopController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }


    /**
     * 查询CustomDesktop对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-13 16:23:57 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "query", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult query(HttpServletRequest request,CustomDesktop entity) {
        logger.info("[CustomDesktopController][query] 查询CustomDesktop对象:");
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[CustomDesktopController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除CustomDesktop对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-13 16:23:57 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult delete(CustomDesktop entity) {
        logger.info("[CustomDesktopController][delete] 删除CustomDesktop对象:");
        try {
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }
            int result = service.delete(entity);
            if (result > 0) {
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[CustomDesktopController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询CustomDesktop对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-13 16:23:57 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQuery(HttpServletRequest request,CustomDesktop entity) {
        logger.info("[CustomDesktopController][pageQuery] 查询CustomDesktop对象:");
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[CustomDesktopController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }	
}	
