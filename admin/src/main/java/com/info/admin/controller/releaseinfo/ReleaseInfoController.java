package com.info.admin.controller.releaseinfo;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.ReleaseInfo;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.ReleaseInfoService;
import com.info.admin.utils.PageUtil;
import org.apache.commons.lang.StringUtils;
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
import java.util.Date;

/**
 * @author administrator  
 * @date 2018-11-14 23:45:42 
 * @describe 信息发布 Controller
 */
@Controller
@RequestMapping("/admin/releaseInfo")
public class ReleaseInfoController extends BaseController{	
	
    private static final Logger logger = LoggerFactory.getLogger(ReleaseInfoController.class);

    @Autowired
    private ReleaseInfoService service;
    
     /**
     *查询信息发布列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("releaseInfo:query")
    public String getReleaseInfoList(HttpServletRequest request, @ModelAttribute ReleaseInfo entity, Model model) {
        entity.setDeleteFlag(0L);
        logger.info("[ReleaseInfoController][getReleaseInfoList] 查询信息发布列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("releaseInfo", entity);
        return "releaseinfo/listReleaseInfo";
    }

    /**
     *查询信息发布列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/listUser", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("releaseInfoUser:query")
    public String getReleaseInfoListUser(HttpServletRequest request, @ModelAttribute ReleaseInfo entity, Model model) {
        entity.setDeleteFlag(0L);
        entity.setReceiveUser(getStaffId(request));
        logger.info("[ReleaseInfoController][getReleaseInfoListUser] 查询信息发布列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQueryUserId(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("releaseInfo", entity);
        return "releaseinfo/listReleaseInfoUser";
    }

    /**
     *查询信息发布列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/listUserAll", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("releaseInfoUserAll:query")
    public String getReleaseInfoListUserAll(HttpServletRequest request, @ModelAttribute ReleaseInfo entity, Model model) {
        entity.setDeleteFlag(0L);
        entity.setReceiveUser(String.valueOf(getLoginUserId(request)));
        logger.info("[ReleaseInfoController][getReleaseInfoListUserAll] 查询信息发布列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQueryUserAll(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("releaseInfo", entity);
        return "releaseinfo/listReleaseInfoUserAll";
    }

     /**
     *我的桌面查询信息发布列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("releaseInfo:query")
    public String getReleaseInfoListDesktop(HttpServletRequest request, @ModelAttribute ReleaseInfo entity, Model model) {
        entity.setDeleteFlag(0L);
        logger.info("[ReleaseInfoController][getReleaseInfoListDesktop] 我的桌面查询信息发布列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("releaseInfo", entity);
        return "releaseinfo/listReleaseInfoDesktop";
    }

    /**
     *我的桌面查询信息发布列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/listUser/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("releaseInfoUser:query")
    public String getReleaseInfoListUserDesktop(HttpServletRequest request, @ModelAttribute ReleaseInfo entity, Model model) {
        entity.setDeleteFlag(0L);
        entity.setReceiveUser(getStaffId(request));
        logger.info("[ReleaseInfoController][getReleaseInfoListUserDesktop] 我的桌面查询信息发布列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("releaseInfo", entity);
        return "releaseinfo/listReleaseInfoUserDesktop";
    }

    /**
     *我的桌面查询信息发布列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/listUserAll/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("releaseInfoUserAll:query")
    public String getReleaseInfoListUserAllDesktop(HttpServletRequest request, @ModelAttribute ReleaseInfo entity, Model model) {
        entity.setDeleteFlag(0L);
        logger.info("[ReleaseInfoController][getReleaseInfoListUserAllDesktop] 我的桌面查询信息发布列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQueryUserAll(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("releaseInfo", entity);
        return "releaseinfo/listReleaseInfoUserAllDesktop";
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,String releaseId,Model model){
        try{
            if(null != releaseId && StringUtils.isNotBlank(releaseId)){
                //根据id查询系统用户
                ReleaseInfo releaseInfo = service.getReleaseInfoById(releaseId);
                model.addAttribute("releaseInfo", releaseInfo);
            }else {
                model.addAttribute("userName",getLoginUser(request).getName());
                model.addAttribute("userId",getLoginUser(request).getId());
            }
            model.addAttribute("releaseId", releaseId);
            return "releaseinfo/addReleaseInfo";
        }catch(Exception e){
            logger.error("[ReleaseInfoController][addOrEdit]: releaseId="+releaseId, e);
            return "500";
        }
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEditUser",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEditUser(HttpServletRequest request,String releaseId,Model model){
        try{
            if(StringUtils.isNotBlank(releaseId)){
                //根据id查询系统用户
                ReleaseInfo releaseInfo = service.getReleaseInfoById(releaseId);
                model.addAttribute("releaseInfo", releaseInfo);
            }
            model.addAttribute("releaseId", releaseId);
            return "releaseinfo/addReleaseInfoUser";
        }catch(Exception e){
            logger.error("[ReleaseInfoController][addOrEditUser]: releaseId="+releaseId, e);
            return "500";
        }
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEditUserAll",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEditUserAll(HttpServletRequest request,String releaseId,Model model){
        try{
            if(null != releaseId && StringUtils.isNotBlank(releaseId)){
                //根据id查询系统用户
                ReleaseInfo releaseInfo = service.getReleaseInfoById(releaseId);
                model.addAttribute("releaseInfo", releaseInfo);
            }
            model.addAttribute("releaseId", releaseId);
            return "releaseinfo/addReleaseInfoUserAll";
        }catch(Exception e){
            logger.error("[ReleaseInfoController][addOrEditUserAll]: releaseId="+releaseId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改ReleaseInfo对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertAndUpdate(HttpServletRequest request,ReleaseInfo entity) {
        logger.info("[ReleaseInfoController][insertAndUpdate] 新增或者修改ReleaseInfo对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }
            String[] releaseUsers = request.getParameterValues("releaseUsers[]");
            if(releaseUsers != null && releaseUsers.length > 0){
                entity.setReleaseUser(StringUtils.join(releaseUsers,","));
            }
            String[] receiveUsers = request.getParameterValues("receiveUsers[]");
            String[] receiveUserCns = request.getParameterValues("receiveUserCns[]");
            if(receiveUsers != null && receiveUsers.length> 0){
                entity.setReceiveUser(StringUtils.join(receiveUsers,","));
                entity.setReceiveUserCn(StringUtils.join(receiveUserCns,","));
            }
            // 通过id来判断是新增还是修改
            if ( StringUtils.isNotBlank(entity.getReleaseId())) {
                result = service.update(entity);
            } else {
                entity.setDeleteFlag(0L);
                entity.setCreateUser(getLoginUserId(request));
                result = service.insert(entity);
            }
            if (result > 0) {
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[ReleaseInfoController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询ReleaseInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "query", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult query(ReleaseInfo entity) {
        logger.info("[ReleaseInfoController][query] 查询ReleaseInfo对象:");
        entity.setDeleteFlag(0L);
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[ReleaseInfoController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除ReleaseInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult delete(ReleaseInfo entity) {
        logger.info("[ReleaseInfoController][delete] 删除ReleaseInfo对象:");
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
            logger.error("[ReleaseInfoController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询ReleaseInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQuery(HttpServletRequest request,ReleaseInfo entity) {
        logger.info("[ReleaseInfoController][pageQuery] 查询ReleaseInfo对象:");
        entity.setDeleteFlag(0L);
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[ReleaseInfoController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询ReleaseInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQueryUser", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQueryUser(HttpServletRequest request,ReleaseInfo entity) {
        logger.info("[ReleaseInfoController][pageQuery] 查询ReleaseInfo对象:");
        entity.setDeleteFlag(0L);
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);
            entity.setReceiveUser(getStaffId(request));
            PageUtil paginator = service.pageQueryUserId(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[ReleaseInfoController][pageQueryUser] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询ReleaseInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQueryUserAll", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQueryUserAll(HttpServletRequest request,ReleaseInfo entity) {
        logger.info("[ReleaseInfoController][pageQueryAll] 查询ReleaseInfo对象:");
        entity.setDeleteFlag(0L);
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.pageQueryUserAll(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[ReleaseInfoController][pageQueryUserAll] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }
}	
