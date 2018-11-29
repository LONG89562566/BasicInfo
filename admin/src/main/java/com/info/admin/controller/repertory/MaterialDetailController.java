package com.info.admin.controller.repertory;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.Material;
import com.info.admin.entity.MaterialDetail;
import com.info.admin.entity.Repertory;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.MaterialDetailService;
import com.info.admin.service.MaterialService;
import com.info.admin.service.RepertoryService;
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
import java.util.List;

/**
 * @author administrator  
 * @date 2018-11-28 15:06:08 
 * @describe 材料出入库 Controller
 */
@Controller
@RequestMapping("/admin/materialDetail")
public class MaterialDetailController extends BaseController{	
	
    private static final Logger logger = LoggerFactory.getLogger(MaterialDetailController.class);

    @Autowired
    private MaterialDetailService service;
    @Autowired
    private RepertoryService repertoryService;
    @Autowired
    private MaterialService materialService;
    
     /**
     *查询材料入库列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("materialDetail:query")
    public String getMaterialDetailList(HttpServletRequest request, @ModelAttribute MaterialDetail entity, Model model) {
        logger.info("[MaterialDetailController][getMaterialDetailList] 查询材料出入库列表:");
        // 获取分页当前的页码
        entity.setMaterialType(1L);
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("materialDetail", entity);
        return "repertory/listMaterialDetail";
    }
     /**
     *我的桌面查询材料出入库列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("materialDetail:query")
    public String getMaterialDetailListDesktop(HttpServletRequest request, @ModelAttribute MaterialDetail entity, Model model) {
        logger.info("[MaterialDetailController][getMaterialDetailListDesktop] 我的桌面查询材料出入库列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("materialDetail", entity);
        return "repertory/listMaterialDetailDesktop";
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,String materialDetailId,String projectId,Model model){
        try{
            if(null != materialDetailId && StringUtils.isNotBlank(materialDetailId)){
                //根据id查询系统用户
                MaterialDetail materialDetail = service.getMaterialDetailById(materialDetailId);
                model.addAttribute("materialDetail", materialDetail);
            }
            List<Material> materialList = materialService.getMaterial(projectId);
            model.addAttribute("materialDetailId", materialDetailId);
            model.addAttribute("projectId", projectId);
            model.addAttribute("materialList", materialList);
            return "repertory/addMaterialDetail";
        }catch(Exception e){
            logger.error("[MaterialDetailController][addOrEdit]: materialDetailId="+materialDetailId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改MaterialDetail对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-28 15:06:08 
     * @updater  or other
     * @return   com.info.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertAndUpdate(HttpServletRequest request,MaterialDetail entity) {
        logger.info("[MaterialDetailController][insertAndUpdate] 新增或者修改MaterialDetail对象:");
        try {
            int result;
            int results;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }
                String materialName = entity.getMaterialName();
                String projectId = entity.getProjectId();
                Repertory repertory = new Repertory();
                repertory.setProjectId(entity.getProjectId());
                repertory.setMaterialName(entity.getMaterialName());
                repertory.setNum(entity.getNum());
                Repertory repertorys = repertoryService.getRepertoryPage(materialName, projectId);
                if (repertorys != null) {
                    results = repertoryService.updateNum(entity.getNum(),repertorys.getRepertoryId());
                } else {
                    repertory.setRepertoryId(com.info.admin.utils.UUIDUtils.getUUid());
                    results = repertoryService.insert(repertory);
                }
                    if (results > 0) {
                        if (repertorys != null) {
                        entity.setRepertoryId(repertorys.getRepertoryId());}
                        else {
                            entity.setRepertoryId(repertory.getRepertoryId());
                        }
                        result = service.insert(entity);
                    } else {
                        return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
                    }
                    if (result > 0) {
                        return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
                    } else {
                        return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
                    }
        } catch (Exception e) {
            logger.error("[MaterialDetailController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询MaterialDetail对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-28 15:06:08 
     * @updater  or other
     * @return   com.info.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "query", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult query(MaterialDetail entity) {
        logger.info("[MaterialDetailController][query] 查询MaterialDetail对象:");
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[MaterialDetailController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除MaterialDetail对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-28 15:06:08 
     * @updater  or other
     * @return   com.info.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult delete(MaterialDetail entity) {
        logger.info("[MaterialDetailController][delete] 删除MaterialDetail对象:");
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
            logger.error("[MaterialDetailController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询MaterialDetail对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-28 15:06:08 
     * @updater  or other
     * @return   com.info.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQuery(HttpServletRequest request,MaterialDetail entity) {
        logger.info("[MaterialDetailController][pageQuery] 查询MaterialDetail对象:");
        try {
            entity.setMaterialType(1L);
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[MaterialDetailController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }


    /**
     *查询材料出库列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/outList", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("outListMaterialDetail:query")
    public String outListMaterialDetail(HttpServletRequest request, @ModelAttribute MaterialDetail entity, Model model) {
        logger.info("[MaterialDetailController][outListMaterialDetail] 查询材料出入库列表:");
        entity.setMaterialType(0L);
        // 获取分页当前的页码
        int pageNum = this.getPageNum(request);
        // 获取分页的大小
        int pageSize = this.getPageSize(request);
        PageUtil paginator = service.outPageQuery(entity , pageNum, pageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("materialDetail", entity);
        return "repertory/listOutMaterialDetail";
    }

    /**
     *查询材料出库列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/outTest", method = { RequestMethod.GET, RequestMethod.POST })
    public String outTest(HttpServletRequest request, @ModelAttribute MaterialDetail entity,  String outId,Model model) {
        logger.info("[MaterialDetailController][outTest] 查询Test列表:");
        if(StringUtils.isNotEmpty(outId)){
            List<MaterialDetail> materialDetailList = service.getMaterialByOutId(outId);
              model.addAttribute("materialDetailList", materialDetailList);
              MaterialDetail materialDetail = service.getMaterialDetailByOutId(outId);
              model.addAttribute("materialDetail", materialDetail);
              model.addAttribute("outId", outId);
        }
        return "repertory/outTestMaterialDetail";
    }
    /**
     * 修改检验状态
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-28 15:06:08
     * @updater  or other
     * @return   com.info.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "updateTestMaterialDetail", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult updateTestMaterialDetail(MaterialDetail entity) {
        logger.info("[MaterialDetailController][updateTestMaterialDetail] 查询MaterialDetail对象:");
        try {
            int result;
            if(entity == null){
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }
            result = service.updateTestMaterialDetail(entity);
            if(result>0){
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            }else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[MaterialDetailController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }
    /**
     * 批量出库
     * @param
     * @date   2018-11-28 15:06:08
     * @updater  or other
     * @return   com.info.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "outTestMaterial", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult outTestMaterial( String outId) {
        logger.info("[MaterialDetailController][outTestMaterial] 查询MaterialDetail对象:");
        try {
            int result;
            int results;
            List<MaterialDetail> materialDetailList = service.getMaterialByOutId(outId);
            MaterialDetail materialDetail = new MaterialDetail();
            materialDetail.setOutState(1L);
            materialDetail.setOutId(outId);
            result = repertoryService.outTestMaterial(materialDetailList);
            results = service.updateTestMaterialDetail(materialDetail);
            if(result>0 && results >0){
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            }else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[MaterialDetailController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/outOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String outOrEdit(HttpServletRequest request,String materialDetailId,String projectId,Model model){
        try{
            if(null != materialDetailId && StringUtils.isNotBlank(materialDetailId)){
                //根据id查询系统用户
                MaterialDetail materialDetail = service.getMaterialDetailById(materialDetailId);
                model.addAttribute("materialDetail", materialDetail);
            }
            List<Material> materialList = materialService.getMaterial(projectId);
            model.addAttribute("materialDetailId", materialDetailId);
            model.addAttribute("projectId", projectId);
            model.addAttribute("materialList", materialList);
            return "repertory/outMaterialDetail";
        }catch(Exception e){
            logger.error("[MaterialDetailController][outOrEdit]: materialDetailId="+materialDetailId, e);
            return "500";
        }
    }

    /**
     * 分页查询出库MaterialDetail对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-28 15:06:08
     * @updater  or other
     * @return   com.info.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "outPageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult outPageQuery(HttpServletRequest request,MaterialDetail entity) {
        logger.info("[MaterialDetailController][outPageQuery] 查询MaterialDetail对象:");
        try {
            entity.setMaterialType(0L);
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.outPageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[MaterialDetailController][outPageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 新增批量新增加MaterialDetail
     * @param    request  请求
     * @param
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertMaterialDetail", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertMaterialDetail(HttpServletRequest request,String projectId ,String outName) {
        logger.info("[ProportionsController][insertMaterialDetail] 新增或者修改Proportions对象:");
        try {
            String[] num =  request.getParameterValues("num[]");
            String[] materialName =  request.getParameterValues("materialName[]");
            if (StringUtils.isNotEmpty(projectId) || num != null || materialName != null || StringUtils.isNotEmpty(projectId)) {

                service.batchMaterialDetail(projectId,num,materialName,outName);
                    } else {
                        return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
                    }
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
        } catch (Exception e) {
            logger.error("[ProportionsController][insertMaterialDetail] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }


}	
