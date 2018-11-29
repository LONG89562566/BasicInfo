package com.info.admin.controller.repairinfo;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.RepairInfo;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.RepairInfoService;
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
 * @describe 维修信息 Controller
 */
@Controller
@RequestMapping("/admin/repairInfo")
public class RepairInfoController extends BaseController{	
	
    private static final Logger logger = LoggerFactory.getLogger(RepairInfoController.class);

    @Autowired
    private RepairInfoService service;
    
     /**
     *查询维修信息列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    public String getRepairInfoList(HttpServletRequest request, @ModelAttribute RepairInfo entity, Model model) {
        logger.info("[RepairInfoController][getRepairInfoList] 查询维修信息列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        entity.setDeleteFlag(0L);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("repairInfo", entity);
        return "repairinfo/listRepairInfo";
    }

     /**
     *我的桌面查询维修信息列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    public String getRepairInfoListDesktop(HttpServletRequest request, @ModelAttribute RepairInfo entity, Model model) {
        logger.info("[RepairInfoController][getRepairInfoListDesktop] 我的桌面查询维修信息列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        entity.setDeleteFlag(0L);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("repairInfo", entity);
        return "repairinfo/listRepairInfoDesktop";
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,String repairId,Model model){
        try{
            if(StringUtils.isNotBlank(repairId)){
                //根据id查询系统用户
                RepairInfo repairInfo = service.getRepairInfoById(repairId);
                model.addAttribute("repairInfo", repairInfo);
            }
            model.addAttribute("repairId", repairId);
            return "repairinfo/addRepairInfo";
        }catch(Exception e){
            logger.error("[RepairInfoController][addOrEdit]: repairId="+repairId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改RepairInfo对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertAndUpdate(HttpServletRequest request,RepairInfo entity) {
        logger.info("[RepairInfoController][insertAndUpdate] 新增或者修改RepairInfo对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            String[] repairUsers = request.getParameterValues("repairUsers[]");
            String[] repairUserCns = request.getParameterValues("repairUserCns[]");
            if(repairUsers != null && repairUsers.length> 0){
                entity.setRepairUser(StringUtils.join(repairUsers,","));
                entity.setRepairUserCn(StringUtils.join(repairUserCns,","));
            }
            // 通过id来判断是新增还是修改
            if (StringUtils.isNotBlank(entity.getRepairId())) {
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
            logger.error("[RepairInfoController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询RepairInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "query", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult query(RepairInfo entity) {
        logger.info("[RepairInfoController][query] 查询RepairInfo对象:");
        try {
            entity.setDeleteFlag(0L);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[RepairInfoController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除RepairInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult delete(RepairInfo entity) {
        logger.info("[RepairInfoController][delete] 删除RepairInfo对象:");
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
            logger.error("[RepairInfoController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询RepairInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQuery(HttpServletRequest request,RepairInfo entity) {
        logger.info("[RepairInfoController][pageQuery] 查询RepairInfo对象:");
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);
            entity.setDeleteFlag(0L);
            PageUtil paginator = service.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[RepairInfoController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }	
}	
