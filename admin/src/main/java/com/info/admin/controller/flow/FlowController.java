package com.info.admin.controller.flow;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.Flow;
import com.info.admin.entity.WarningInfo;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.FlowService;
import com.info.admin.service.WarningInfoService;
import com.info.admin.utils.CloneUtils;
import com.info.admin.utils.PageUtil;
import com.info.admin.utils.UUIDUtils;
import com.info.admin.vo.FlowVo;
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
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private WarningInfoService warningInfoService;
    
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
        entity.setUserId(this.getStaffId(request));
        PageUtil paginator = service.pageDbQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("flow", entity);
        return "flow/dbListFlow";
    }

    /**
     *预警待办流程列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/yjDbFlow", method = { RequestMethod.GET, RequestMethod.POST })
    public String getYjDbFlowList(HttpServletRequest request, @ModelAttribute Flow entity, Model model) {
        logger.info("[FlowController][getYjDbFlowList] 查询待办流程列表:");
        model.addAttribute("paginator", yjDbQuery(request,entity));
        model.addAttribute("flow", entity);
        return "flow/yjdbListFlow";
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
        entity.setUserId(this.getStaffId(request));
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
        entity.setUserId(this.getStaffId(request));
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
     *查询流程意见
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/queryFlow", method = { RequestMethod.GET, RequestMethod.POST })
    public String queryFlow(HttpServletRequest request, @ModelAttribute Flow entity, Model model) {
        logger.info("[FlowController][queryFlow] 查询流程意见:");
        model.addAttribute("paginator", null);
        model.addAttribute("flow", entity);
        return "flow/queryFlow";
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
            if(StringUtils.isNotEmpty(flowId) && !"null".equals(flowId)
                    && !"undefined".equals(flowId)){
                //根据id查询系统用户
                FlowVo flow = service.getFlowByIdVo(flowId);
                model.addAttribute("flow", flow);
                model.addAttribute("fn", "edit");
            }else {
                model.addAttribute("fn", "add");
            }
            model.addAttribute("flowId", flowId);
            return "flow/addFlow";
        }catch(Exception e){
            logger.error("[FlowController][addOrEdit]: flowId="+flowId, e);
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
    @RequestMapping(value="/submitPage",method={RequestMethod.GET,RequestMethod.POST})
    public String submitPage(HttpServletRequest request,String flowId,Model model){
        try{
            if(StringUtils.isNotEmpty(flowId) && !"null".equals(flowId)
                    && !"undefined".equals(flowId)){
                //根据id查询系统用户
                FlowVo flow = service.getFlowByIdVo(flowId);
                model.addAttribute("flow", flow);
                model.addAttribute("fn", "edit");
            }else {
                model.addAttribute("fn", "add");
            }
            model.addAttribute("flowId", flowId);
            return "flow/submitFlow";
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
            if (StringUtils.isNotBlank(entity.getFlowId())) {
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
     * 发送Flow对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "sendFlow", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult sendFlow(HttpServletRequest request,Flow entity) {
        logger.info("[FlowController][sendFlow] 发送Flow对象:");
        try {
            int result=0;
            String[] user = request.getParameterValues("user[]");
            if (StringUtils.isBlank(entity.getDocUnid())) {
                return new JsonResult(JsonResultCode.FAILURE, "参数异常，页面编号不能为空", "");
            }

            if (StringUtils.isNotBlank(entity.getFlowId())) {
                Flow flow = new Flow();
                flow.setFlowId(entity.getFlowId());
                flow.setShowTitle(entity.getShowTitle());
                flow.setMsg(entity.getMsg());
                flow.setOperator(this.getStaffId(request));
                flow.setOperatorCn(this.getLoginUser(request).getName());
                flow.setIsDone(1L);
                result = service.update(flow);
            }else{
                entity.setFlowId(UUIDUtils.getUUid());
            }

            //设置entity特殊参数
            entity.setDeleteFlag(0L);
            entity.setUserId(this.getStaffId(request));
            entity.setCreateTime(new java.util.Date());
            entity.setCreateUser(this.getLoginUserId(request));
            entity.setCreateUserCn(this.getLoginUser(request).getName());
            entity.setIsDone(1L);

            /**
             * 根据docid获取流程节点，如果无节点则为初次发起
             */
            if(StringUtils.isNotBlank(entity.getDocUrl()) && entity.getDocUrl().indexOf("&flowId=") > -1){
                entity.setDocUrl(entity.getDocUrl().split("&flowId=")[0]);
            }
            Flow flow = new Flow();
            flow.setDocUnid(entity.getDocUnid());
            flow.setIsDone(0L);
            //查询是否有当前页面的未完成节点
            List<Flow> list = service.getFlowByDocUnid(flow);
            if (list!=null&&list.size()>0){
                String  docUrl = entity.getDocUrl();
                //非初次发起
                /**
                 * 1、未完成节点超过1条则为，则上节点为多人节点，此时应将多节点都改为完成状态
                 * 2、未完成节点只有1条，则上节点为单人节点，此时应将该节点改为完成状态
                 */
                for (Flow f:list){
                    Flow f1 = new Flow();
                    f1.setIsDone(1L);
                    f1.setFlowId(f.getFlowId());
                    if (f.getUserId().equals(this.getStaffId(request))){
                        f1.setOperator(this.getStaffId(request));
                        f1.setOperatorCn(this.getLoginUser(request).getName());
                    }
                    service.update(f1);
                }
                if (user==null||user.length==0){
                    return new JsonResult(JsonResultCode.FAILURE, "参数异常，发送的用户不能为空", "");
                }else if (user.length==1) {

                    Flow f = CloneUtils.clone(entity);
                    f.setIsDone(0L);
                    f.setUserId(user[0]);
                    f.setLastNode(list.get(0).getFlowId());
                    f.setFlowId(UUIDUtils.getUUid());
                    f.setDocUrl(StringUtils.isNotBlank(docUrl) ? docUrl : "");
                    f.setLastNode(entity.getFlowId());
                    f.setMsg("");
                    f.setShowTitle("");

                    result = service.insert(f);
                }else if (user.length>1){
                    /**
                     * 2、发送多人
                     */
                    List<Flow> batchList = new ArrayList<>();

                    for (String userId:user){
                        Flow f = CloneUtils.clone(entity);
                        f.setIsDone(0L);
                        f.setUserId(userId);
                        f.setLastNode(list.get(0).getFlowId());
                        f.setFlowId(UUIDUtils.getUUid());
                        f.setDocUrl(StringUtils.isNotBlank(docUrl) ? docUrl : "");
                        f.setLastNode(entity.getFlowId());
                        f.setMsg("");
                        f.setShowTitle("");
                        batchList.add(f);
                    }
                    result = service.startFlow(batchList);
                }

            }else{
                //初次发起
                entity.setOperator(this.getStaffId(request));
                entity.setOperatorCn(this.getLoginUser(request).getName());
                if (user==null||user.length==0){
                    return new JsonResult(JsonResultCode.FAILURE, "参数异常，发送的用户不能为空", "");
                }else if (user.length==1){
                    /**
                     * 1、发送单人
                     */
                    List<Flow> startList = new ArrayList<>();
                    startList.add(entity);
                    Flow f = CloneUtils.clone(entity);
                    String  docUrl = entity.getDocUrl();
                    f.setFlowId(UUIDUtils.getUUid());
                    f.setDocUrl(StringUtils.isNotBlank(docUrl) ? docUrl : "");
                    f.setOperator(null);
                    f.setOperatorCn(null);
                    f.setMsg("");
                    f.setShowTitle("");
                    f.setLastNode(entity.getFlowId());
                    f.setIsDone(0L);
                    startList.add(f);

                    result = service.startFlow(startList);
                }else if (user.length>1){
                    /**
                     * 2、发送多人
                     */
                    List<Flow> startList = new ArrayList<>();
                    entity.setFlowId(UUIDUtils.getUUid());
                    String  docUrl = entity.getDocUrl();
                    entity.setDocUrl(StringUtils.isNotBlank(docUrl) ? docUrl : "");
                    startList.add(entity);
                    for (String userId:user){
                        Flow f = CloneUtils.clone(entity);
                        f.setOperator(null);
                        f.setIsDone(0L);
                        f.setOperatorCn(null);
                        f.setUserId(userId);
                        f.setLastNode(entity.getFlowId());
                        f.setFlowId(UUIDUtils.getUUid());
                        f.setMsg("");
                        f.setShowTitle("");
                        f.setDocUrl(StringUtils.isNotBlank(docUrl) ? docUrl : "");
                        startList.add(f);
                    }
                    result = service.startFlow(startList);
                }
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
     * 发送Flow对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "submitFlow", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult submitFlow(HttpServletRequest request,Flow entity) {
        logger.info("[FlowController][submitFlow] 发送Flow对象:");
        try {
            int result=0;
            String[] user = request.getParameterValues("user[]");
            if (StringUtils.isBlank(entity.getDocUnid())) {
                return new JsonResult(JsonResultCode.FAILURE, "参数异常，页面编号不能为空", "");
            }

            Flow flow = new Flow();
            flow.setDocUnid(entity.getDocUnid());
            flow.setIsDone(0L);
            //查询是否有当前页面的未完成节点
            List<Flow> list = service.getFlowByDocUnid(flow);
            if(list == null || list.size() == 0){
                return new JsonResult(JsonResultCode.FAILURE, "提交异常，无上一节点。", "");
            }

            if (StringUtils.isBlank(entity.getFlowId())) {
                return new JsonResult(JsonResultCode.FAILURE, "提交异常，无上一节点。", "");
            }

            Flow flow1 = new Flow();
            flow1.setFlowId(entity.getFlowId());
            flow1.setShowTitle(entity.getShowTitle());
            flow1.setMsg(entity.getMsg());
            flow1.setOperator(this.getStaffId(request));
            flow1.setOperatorCn(this.getLoginUser(request).getName());
            flow1.setIsDone(1L);
            flow1.setIsSubmit(1L);
            result = service.update(flow1);


            if (result > 0) {
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[FlowController][submitFlow] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 发送Flow对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "isSubmit", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult isSubmit(HttpServletRequest request,Flow entity) {
        logger.info("[FlowController][submitFlow] 发送Flow对象:");
        try {
            if (StringUtils.isBlank(entity.getFlowId())) {
                return new JsonResult(JsonResultCode.FAILURE, "参数异常，页面编号不能为空", "");
            }
            entity.setIsDone(0L);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.getSubmitByDocUnid(entity));
        } catch (Exception e) {
            logger.error("[FlowController][submitFlow] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }
    /**
     * 结束Flow
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "endFlow", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult endFlow(HttpServletRequest request,Flow entity) {
        logger.info("[FlowController][endFlow] 结束Flow:");
        try {
            /**
             * 根据docid获取流程节点，如果无节点则为初次发起
             */
            Flow flow = new Flow();
            flow.setDocUnid(entity.getDocUnid());
            //查询是否有当前页面的未完成节点
            List<Flow> list = service.getFlowByDocUnid(flow);
            for (Flow f:list){
                Flow f1 = new Flow();
                f1.setIsDone(1L);
                f1.setIsEnd(1L);
                f1.setFlowId(f.getFlowId());
                if (f.getUserId().equals(this.getStaffId(request))){
                    f1.setOperator(this.getStaffId(request));
                    f1.setOperatorCn(this.getLoginUser(request).getName());
                }
                service.update(f1);
            }
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
        } catch (Exception e) {
            logger.error("[FlowController][query] exception", e);
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
     * 分页查询Flow对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQueryFlow", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQueryFlow(HttpServletRequest request,Flow entity) {
        logger.info("[FlowController][pageQueryFlow] 查询Flow对象:");
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.queryPageFlow(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[FlowController][pageQueryFlow] exception", e);
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
            entity.setUserId(this.getStaffId(request));
            PageUtil paginator = service.pageDbQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[FlowController][pageDbQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询预警待办Flow对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageYjDbQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageYjDbQuery(HttpServletRequest request,Flow entity) {
        logger.info("[FlowController][pageYjDbQuery] 查询Flow对象:");
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", yjDbQuery(request,entity));
        } catch (Exception e) {
            logger.error("[FlowController][pageYjDbQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询预警待办Flow对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   PageUtil
     */
    private PageUtil yjDbQuery(HttpServletRequest request,Flow entity){
        // 获取分页当前的页码
        int pageNum = this.getPageNum(request);
        // 获取分页的大小
        int pageSize = this.getPageSize(request);
        //TODO
        //用户所属部门、角色还未处理
        entity.setUserId(this.getStaffId(request));
        WarningInfo warningInfo = new WarningInfo();
        warningInfo.setReceiveUser(getStaffId(request));
        warningInfo.setOptions(1L);
        List<WarningInfo> warningInfos =  warningInfoService.query(warningInfo);
        if(warningInfos != null && warningInfos.size() > 0){
            entity.setDayNum(Integer.parseInt(warningInfos.get(0).getWarn_val()));
            long checkCondition = warningInfos.get(0).getCheckCondition();
            entity.setCheckCondition(checkCondition+"");
        }else {
            entity.setDayNum(1);
            entity.setCheckCondition("1");
        }
        return service.pageYjDbQuery(entity , pageNum, pageSize);
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
            entity.setUserId(this.getStaffId(request));
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
            entity.setUserId(this.getStaffId(request));
            PageUtil paginator = service.pageBjQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[FlowController][pageBjQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询StaffInfo对象
     *
     * @param flowId 对象
     * @return com.netcai.admin.result.JsonResult
     * @author ysh
     * @date 2018-11-14 23:45:42
     * @updater or other
     */
    @ResponseBody
    @RequestMapping(value = "getFlowVoById", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult getFlowVoById(String flowId ) {
        logger.info("[FlowController][getFlowVoById] 查询StaffInfo对象:");
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.getFlowByIdVo(flowId));
        } catch (Exception e) {
            logger.error("[FlowController][getFlowVoById] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }
}	
