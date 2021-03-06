package com.info.admin.controller.releaseinfolog;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.ReleaseInfoLog;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.ReleaseInfoLogService;
import com.info.admin.utils.PageUtil;
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

/**
 * @author administrator  
 * @date 2018-11-18 19:39:48 
 * @describe 信息发布日志 Controller
 */
@Controller
@RequestMapping("/admin/releaseInfoLog")
public class ReleaseInfoLogController extends BaseController{	
	
    private static final Logger logger = LoggerFactory.getLogger(ReleaseInfoLogController.class);

    @Autowired
    private ReleaseInfoLogService service;
    
     /**
     *查询信息发布日志列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("releaseInfoLog:query")
    public String getReleaseInfoLogList(HttpServletRequest request, @ModelAttribute ReleaseInfoLog entity, Model model) {
        logger.info("[ReleaseInfoLogController][getReleaseInfoLogList] 查询信息发布日志列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("releaseInfoLog", entity);
        return "releaseinfolog/listReleaseInfoLog";
    }

     /**
     *我的桌面查询信息发布日志列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("releaseInfoLog:query")
    public String getReleaseInfoLogListDesktop(HttpServletRequest request, @ModelAttribute ReleaseInfoLog entity, Model model) {
        logger.info("[ReleaseInfoLogController][getReleaseInfoLogListDesktop] 我的桌面查询信息发布日志列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("releaseInfoLog", entity);
        return "releaseinfolog/listReleaseInfoLogDesktop";
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,Long releaseInfoLogId,Model model){
        try{
            if(null != releaseInfoLogId){
                //根据id查询系统用户
                ReleaseInfoLog releaseInfoLog = service.getReleaseInfoLogById(releaseInfoLogId);
                model.addAttribute("releaseInfoLog", releaseInfoLog);
            }
            model.addAttribute("releaseInfoLogId", releaseInfoLogId);
            return "releaseinfolog/addReleaseInfoLog";
        }catch(Exception e){
            logger.error("[ReleaseInfoLogController][addOrEdit]: releaseInfoLogId="+releaseInfoLogId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改ReleaseInfoLog对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-18 19:39:48 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertAndUpdate(HttpServletRequest request,ReleaseInfoLog entity) {
        logger.info("[ReleaseInfoLogController][insertAndUpdate] 新增或者修改ReleaseInfoLog对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            // 通过id来判断是新增还是修改
            if (null != entity.getReleaseInfoLogId()) {
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
            logger.error("[ReleaseInfoLogController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询ReleaseInfoLog对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-18 19:39:48 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "query", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult query(ReleaseInfoLog entity) {
        logger.info("[ReleaseInfoLogController][query] 查询ReleaseInfoLog对象:");
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[ReleaseInfoLogController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除ReleaseInfoLog对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-18 19:39:48 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult delete(ReleaseInfoLog entity) {
        logger.info("[ReleaseInfoLogController][delete] 删除ReleaseInfoLog对象:");
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
            logger.error("[ReleaseInfoLogController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询ReleaseInfoLog对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-18 19:39:48 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQuery(HttpServletRequest request,ReleaseInfoLog entity) {
        logger.info("[ReleaseInfoLogController][pageQuery] 查询ReleaseInfoLog对象:");
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[ReleaseInfoLogController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }	
}	
