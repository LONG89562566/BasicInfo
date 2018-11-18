package com.info.admin.controller.flow;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.Flow;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.FlowService;
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

/**
 * @author administrator  
 * @date 2018-11-14 23:45:42 
 * @describe 流程 Controller
 */
@Controller
@RequestMapping("/admin/flow")
public class FlowController extends BaseController{	
	
    private static final Logger logger = LoggerFactory.getLogger(FlowController.class);

    @Autowired
    private FlowService service;
    
     /**
     *待办流程列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/dbList", method = { RequestMethod.GET, RequestMethod.POST })
    public String getDbFlowList(HttpServletRequest request, @ModelAttribute Flow entity, Model model) {
        logger.info("[FlowController][getDBFlowList] 查询待办流程列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        //TODO
        //用户所属部门、角色还未处理
        entity.setUserId(String.valueOf(this.getLoginUserId(request)));
        PageUtil paginator = service.pageDbQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("flow", entity);
        return "flow/dbListFlow";
    }

    /**
     *在办流程列表
     *@author   ljuenan
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/zbList", method = { RequestMethod.GET, RequestMethod.POST })
    public String getZbFlowList(HttpServletRequest request, @ModelAttribute Flow entity, Model model) {
        logger.info("[FlowController][getZBFlowList] 查询在办流程列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        //TODO
        //用户所属部门、角色还未处理
        entity.setUserId(String.valueOf(this.getLoginUserId(request)));
        PageUtil paginator = service.pageZbQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("flow", entity);
        return "flow/zbListFlow";
    }

    /**
     *办结流程列表
     *@author   ljuenan
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/bjList", method = { RequestMethod.GET, RequestMethod.POST })
    public String getBjFlowList(HttpServletRequest request, @ModelAttribute Flow entity, Model model) {
        logger.info("[FlowController][getBJFlowList] 查询办结流程列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        //TODO
        //用户所属部门、角色还未处理
        entity.setUserId(String.valueOf(this.getLoginUserId(request)));
        PageUtil paginator = service.pageBjQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("flow", entity);
        return "flow/bjListFlow";
    }

     /**
     *我的桌面查询流程列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("flow:query")
    public String getFlowListDesktop(HttpServletRequest request, @ModelAttribute Flow entity, Model model) {
        logger.info("[FlowController][getFlowListDesktop] 我的桌面查询流程列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("flow", entity);
        return "flow/listFlowDesktop";
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,String flowId,Model model){
        try{
            if(StringUtils.isNotEmpty(flowId)){
                //根据id查询系统用户
                Flow flow = service.getFlowById(flowId);
                model.addAttribute("flow", flow);
            }
            model.addAttribute("flowId", flowId);
            return "flow/addFlow";
        }catch(Exception e){
            logger.error("[FlowController][addOrEdit]: flowId="+flowId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改Flow对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertAndUpdate(HttpServletRequest request,Flow entity) {
        logger.info("[FlowController][insertAndUpdate] 新增或者修改Flow对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            // 通过id来判断是新增还是修改
            if (null != entity.getFlowId()) {
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
            logger.error("[FlowController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询Flow对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "query", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult query(Flow entity) {
        logger.info("[FlowController][query] 查询Flow对象:");
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[FlowController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除Flow对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult delete(Flow entity) {
        logger.info("[FlowController][delete] 删除Flow对象:");
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
            logger.error("[FlowController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询Flow对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQuery(HttpServletRequest request,Flow entity) {
        logger.info("[FlowController][pageQuery] 查询Flow对象:");
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[FlowController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询待办Flow对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageDbQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageDbQuery(HttpServletRequest request,Flow entity) {
        logger.info("[FlowController][pageDbQuery] 查询Flow对象:");
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);
            //TODO
            //用户所属部门、角色还未处理
            entity.setUserId(String.valueOf(this.getLoginUserId(request)));
            PageUtil paginator = service.pageDbQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[FlowController][pageDbQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询在办Flow对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageZbQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageZbQuery(HttpServletRequest request,Flow entity) {
        logger.info("[FlowController][pageZbQuery] 查询Flow对象:");
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);
            //TODO
            //用户所属部门、角色还未处理
            entity.setUserId(String.valueOf(this.getLoginUserId(request)));
            PageUtil paginator = service.pageZbQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[FlowController][pageZbQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询办结Flow对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageBjQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageBjQuery(HttpServletRequest request,Flow entity) {
        logger.info("[FlowController][pageBjQuery] 查询Flow对象:");
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);
            //TODO
            //用户所属部门、角色还未处理
            entity.setUserId(String.valueOf(this.getLoginUserId(request)));
            PageUtil paginator = service.pageBjQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[FlowController][pageBjQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }
}	
