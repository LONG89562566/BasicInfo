package com.info.admin.controller.equipmentinfo;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.EquipmentInfo;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.EquipmentInfoService;
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
 * @date 2018-11-14 23:45:42 
 * @describe 设备信息 Controller
 */
@Controller
@RequestMapping("/admin/equipmentInfo")
public class EquipmentInfoController extends BaseController{	
	
    private static final Logger logger = LoggerFactory.getLogger(EquipmentInfoController.class);

    @Autowired
    private EquipmentInfoService service;
    
     /**
     *查询设备信息列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("equipmentInfo:query")
    public String getEquipmentInfoList(HttpServletRequest request, @ModelAttribute EquipmentInfo entity, Model model) {
        logger.info("[EquipmentInfoController][getEquipmentInfoList] 查询设备信息列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("equipmentInfo", entity);
        return "equipmentinfo/listEquipmentInfo";
    }

     /**
     *我的桌面查询设备信息列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("equipmentInfo:query")
    public String getEquipmentInfoListDesktop(HttpServletRequest request, @ModelAttribute EquipmentInfo entity, Model model) {
        logger.info("[EquipmentInfoController][getEquipmentInfoListDesktop] 我的桌面查询设备信息列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("equipmentInfo", entity);
        return "equipmentinfo/listEquipmentInfoDesktop";
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,String supplierId,Model model){
        try{
            if(null != supplierId){
                //根据id查询系统用户
                EquipmentInfo equipmentInfo = service.getEquipmentInfoById(supplierId);
                model.addAttribute("equipmentInfo", equipmentInfo);
            }
            model.addAttribute("supplierId", supplierId);
            return "equipmentinfo/addEquipmentInfo";
        }catch(Exception e){
            logger.error("[EquipmentInfoController][addOrEdit]: supplierId="+supplierId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改EquipmentInfo对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertAndUpdate(HttpServletRequest request,EquipmentInfo entity) {
        logger.info("[EquipmentInfoController][insertAndUpdate] 新增或者修改EquipmentInfo对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            // 通过id来判断是新增还是修改
            if (null != entity.getSupplierId()) {
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
            logger.error("[EquipmentInfoController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询EquipmentInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "query", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult query(EquipmentInfo entity) {
        logger.info("[EquipmentInfoController][query] 查询EquipmentInfo对象:");
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[EquipmentInfoController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除EquipmentInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult delete(EquipmentInfo entity) {
        logger.info("[EquipmentInfoController][delete] 删除EquipmentInfo对象:");
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
            logger.error("[EquipmentInfoController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询EquipmentInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQuery(HttpServletRequest request,EquipmentInfo entity) {
        logger.info("[EquipmentInfoController][pageQuery] 查询EquipmentInfo对象:");
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[EquipmentInfoController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }	
}	
