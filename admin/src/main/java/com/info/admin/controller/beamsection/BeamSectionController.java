package com.info.admin.controller.beamsection;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.BeamSection;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.BeamSectionService;
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
 * @describe 梁段信息 Controller
 */
@Controller
@RequestMapping("/admin/beamSection")
public class BeamSectionController extends BaseController{	
	
    private static final Logger logger = LoggerFactory.getLogger(BeamSectionController.class);

    @Autowired
    private BeamSectionService service;
    
     /**
     *查询梁段信息列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("beamSection:query")
    public String getBeamSectionList(HttpServletRequest request, @ModelAttribute BeamSection entity, Model model) {
        logger.info("[BeamSectionController][getBeamSectionList] 查询梁段信息列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        entity.setDeleteFlag(0L);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("beamSection", entity);
        return "beamsection/listBeamSection";
    }

     /**
     *我的桌面查询梁段信息列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("beamSection:query")
    public String getBeamSectionListDesktop(HttpServletRequest request, @ModelAttribute BeamSection entity, Model model) {
        logger.info("[BeamSectionController][getBeamSectionListDesktop] 我的桌面查询梁段信息列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        entity.setDeleteFlag(0L);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("beamSection", entity);
        return "beamsection/listBeamSectionDesktop";
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,String sectionId,Model model,String fn){
        try{
            BeamSection beamSection = null;
            if(StringUtils.isNotEmpty(sectionId) && "edit".equals(fn)){
                //根据id查询系统用户
                 beamSection = service.getBeamSectionById(sectionId);
            }else {
                model.addAttribute("uuid", com.info.admin.utils.UUIDUtils.getUUid());
            }
            model.addAttribute("beamSection", beamSection);
            model.addAttribute("sectionId", sectionId);
            model.addAttribute("fn", fn);
            return "beamsection/addBeamSection";
        }catch(Exception e){
            logger.error("[BeamSectionController][addOrEdit]: sectionId="+sectionId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改BeamSection对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertAndUpdate(HttpServletRequest request,BeamSection entity,String fn) {
        logger.info("[BeamSectionController][insertAndUpdate] 新增或者修改BeamSection对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            // 通过id来判断是新增还是修改
            if (StringUtils.isNotEmpty(entity.getSectionId()) && "edit".equals(fn)) {
                result = service.update(entity);
            } else {
                entity.setCreateUser(this.getLoginUserId(request));
                result = service.insert(entity);
            }
            if (result > 0) {
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[BeamSectionController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询BeamSection对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "query", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult query(BeamSection entity) {
        logger.info("[BeamSectionController][query] 查询BeamSection对象:");
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[BeamSectionController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除BeamSection对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult delete(BeamSection entity) {
        logger.info("[BeamSectionController][delete] 删除BeamSection对象:");
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
            logger.error("[BeamSectionController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询BeamSection对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQuery(HttpServletRequest request,BeamSection entity) {
        logger.info("[BeamSectionController][pageQuery] 查询BeamSection对象:");
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);
            entity.setDeleteFlag(0L);
            PageUtil paginator = service.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[BeamSectionController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }	
}	
