package com.info.admin.controller.frockinfo;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.FrockInfo;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.FrockInfoService;
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
 * @describe 设备信息 Controller
 */
@Controller
@RequestMapping("/admin/frockInfo")
public class FrockInfoController extends BaseController{	
	
    private static final Logger logger = LoggerFactory.getLogger(FrockInfoController.class);

    @Autowired
    private FrockInfoService service;
    
     /**
     *查询设备信息列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("frockInfo:query")
    public String getFrockInfoList(HttpServletRequest request, @ModelAttribute FrockInfo entity, Model model) {
        logger.info("[FrockInfoController][getFrockInfoList] 查询设备信息列表:");
        entity.setDeleteFlag(0L);
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("frockInfo", entity);
        return "frockinfo/listFrockInfo";
    }

     /**
     *我的桌面查询设备信息列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("frockInfo:query")
    public String getFrockInfoListDesktop(HttpServletRequest request, @ModelAttribute FrockInfo entity, Model model) {
        logger.info("[FrockInfoController][getFrockInfoListDesktop] 我的桌面查询设备信息列表:");
        entity.setDeleteFlag(0L);
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("frockInfo", entity);
        return "frockinfo/listFrockInfoDesktop";
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,String frockId,Model model){
        try{
            if(null != frockId && StringUtils.isNotBlank(frockId)){
                //根据id查询系统用户
                FrockInfo frockInfo = service.getFrockInfoById(frockId);
                model.addAttribute("frockInfo", frockInfo);
            }
            model.addAttribute("frockId", frockId);
            return "frockinfo/addFrockInfo";
        }catch(Exception e){
            logger.error("[FrockInfoController][addOrEdit]: frockId="+frockId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改FrockInfo对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertAndUpdate(HttpServletRequest request,FrockInfo entity) {
        logger.info("[FrockInfoController][insertAndUpdate] 新增或者修改FrockInfo对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            // 通过id来判断是新增还是修改
            if (null != entity.getFrockId() && StringUtils.isNotBlank(entity.getFrockId())) {
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
            logger.error("[FrockInfoController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询FrockInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "query", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult query(FrockInfo entity) {
        logger.info("[FrockInfoController][query] 查询FrockInfo对象:");
        try {
            entity.setDeleteFlag(0L);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[FrockInfoController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除FrockInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult delete(FrockInfo entity) {
        logger.info("[FrockInfoController][delete] 删除FrockInfo对象:");
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
            logger.error("[FrockInfoController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询FrockInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQuery(HttpServletRequest request,FrockInfo entity) {
        logger.info("[FrockInfoController][pageQuery] 查询FrockInfo对象:");
        try {
            entity.setDeleteFlag(0L);
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[FrockInfoController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }	
}	
