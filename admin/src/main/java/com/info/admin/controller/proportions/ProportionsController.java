package com.info.admin.controller.proportions;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.Proportions;
import com.info.admin.entity.ProportionsDetailetail;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.ProportionsDetailetailService;
import com.info.admin.service.ProportionsService;
import com.info.admin.utils.PageUtil;
import com.info.admin.utils.UUIDUtils;
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
 * @describe 配合比 Controller
 */
@Controller
@RequestMapping("/admin/proportions")
public class ProportionsController extends BaseController{	
	
    private static final Logger logger = LoggerFactory.getLogger(ProportionsController.class);

    @Autowired
    private ProportionsService service;
    @Autowired
    private ProportionsDetailetailService proportionsDetailetailService;
    
     /**
     *查询配合比列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("proportions:query")
    public String getProportionsList(HttpServletRequest request, @ModelAttribute Proportions entity, Model model) {
        logger.info("[ProportionsController][getProportionsList] 查询配合比列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("proportions", entity);
        return "proportions/listProportions";
    }

     /**
     *我的桌面查询配合比列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("proportions:query")
    public String getProportionsListDesktop(HttpServletRequest request, @ModelAttribute Proportions entity, Model model) {
        logger.info("[ProportionsController][getProportionsListDesktop] 我的桌面查询配合比列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("proportions", entity);
        return "proportions/listProportionsDesktop";
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,String proportionsId,String projectId,Model model){
        try{
            if(null != proportionsId && StringUtils.isNotBlank(proportionsId)){
                //根据id查询系统用户
                Proportions proportions = service.getProportionsById(proportionsId);
                if(proportions == null ){
                    proportions = new Proportions();
                    proportions.setProportionsId(UUIDUtils.getUUid());
                }
                model.addAttribute("proportions", proportions);
            }
            model.addAttribute("proportionsId", proportionsId);
            model.addAttribute("projectId", projectId);
            return "proportions/addProportions";
        }catch(Exception e){
            logger.error("[ProportionsController][addOrEdit]: proportionsId="+proportionsId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改Proportions对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertAndUpdate(HttpServletRequest request,Proportions entity) {
        logger.info("[ProportionsController][insertAndUpdate] 新增或者修改Proportions对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            // 通过id来判断是新增还是修改
            if (null != entity.getProportionsId() && StringUtils.isNotBlank(entity.getProportionsId())) {
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
            logger.error("[ProportionsController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 新增Proportions对象和批量新增加ProportionsDetail
     * @param    request  请求
     * @param
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertProportionsDetail", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertProportionsDetail(HttpServletRequest request,String proportionsName ,Long seq) {
        logger.info("[ProportionsController][insertProportionsDetail] 新增或者修改Proportions对象:");
        try {
            int result;
            int resultTwo;
            String[] materialNum =  request.getParameterValues("materialNum[]");
            String[] materialId =  request.getParameterValues("materialId[]");
            if (StringUtils.isNotEmpty(proportionsName) || materialNum != null || materialId != null) {
                Proportions entity = new Proportions();
                entity.setProportionsId(com.info.admin.utils.UUIDUtils.getUUid());
                entity.setName(proportionsName);
                entity.setSeq(seq);
                result = service.insert(entity);
                if (result > 0) {
                    ProportionsDetailetail proportionsDetail = new ProportionsDetailetail();
                    proportionsDetail.setDetailId(com.info.admin.utils.UUIDUtils.getUUid());
                    proportionsDetail.setProportionsId(entity.getProportionsId());
                    resultTwo = proportionsDetailetailService.insert(proportionsDetail);
                    if(resultTwo > 0){
                        String detailId = proportionsDetail.getDetailId();
                         proportionsDetailetailService.batchProportionsMaterial(detailId,materialNum,materialId);
                    } else {
                        return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
                    }
                } else {
                    return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
                }
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            }else {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

        } catch (Exception e) {
            logger.error("[ProportionsController][insertProportionsDetail] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }


    /**
     * 查询Proportions对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "query", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult query(Proportions entity) {
        logger.info("[ProportionsController][query] 查询Proportions对象:");
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[ProportionsController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除Proportions对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult delete(Proportions entity) {
        logger.info("[ProportionsController][delete] 删除Proportions对象:");
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
            logger.error("[ProportionsController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询Proportions对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQuery(HttpServletRequest request,Proportions entity) {
        logger.info("[ProportionsController][pageQuery] 查询Proportions对象:");
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[ProportionsController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }	
}	
