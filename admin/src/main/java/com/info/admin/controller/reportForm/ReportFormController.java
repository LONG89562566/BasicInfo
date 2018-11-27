package com.info.admin.controller.reportForm;


import com.info.admin.controller.base.BaseController;
import com.info.admin.controller.repertory.RepertoryController;
import com.info.admin.entity.*;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.*;
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
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;




/**
 * @author administrator
 * @date 2018-11-14 23:45:42
 * @describe 仓库 Controller
 */
@Controller
@RequestMapping("/admin/reportForm")
public class ReportFormController  extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(RepertoryController.class);

    @Autowired
    private StaffInfoService staffInfoService;
    @Autowired
    private ProblemLibraryService problemLibraryService;
    @Autowired
    private RepertoryService repertoryService;
    @Autowired
    private ProjectSurveyService projectSurveyService;
    @Autowired
    private EquipmentInfoService equipmentInfoService;
    @Autowired
    private FrockInfoService frockInfoService;




    /**
     * 查询员工信息列表
     *
     * @return String
     * @author
     * @date 2018-07-12 10:50:32
     * @updater or other
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresPermissions("reportForm:query")
    public String getStaffInfoList(HttpServletRequest request, @ModelAttribute StaffInfo entity, Model model) {
        logger.info("[ReportFormController][getStaffInfoList] 查询员工信息列表:");
        entity.setDeleteFlag(0L);
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = staffInfoService.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("staffInfo", entity);
        return "reportForm/listReportForm";
    }

    /**
     * 分页查询StaffInfo对象
     *
     * @param entity 对象
     * @return com.netcai.admin.result.JsonResult
     * @author
     * @date 2018-11-14 23:45:42
     * @updater or other
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult pageQuery(HttpServletRequest request, StaffInfo entity) {
        logger.info("[ReportFormController][pageQuery] 查询StaffInfo对象:");
        try {
            entity.setDeleteFlag(0L);
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = staffInfoService.pageQuery(entity, pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[ReportFormController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     *人员结构报表 树
     *@return   java.lang.String
     *@author
     *@createTime   2018/11/17
     *@updater  or other
     */
    @ResponseBody
    @RequestMapping(value = "/staffInfoRepertoryTree", method = { RequestMethod.GET, RequestMethod.POST })
    public Object staffInfoRepertoryTree( StaffInfo entity ) {
        List<StaffInfo> staffInfoList = staffInfoService.queryStaffInfoRepertoryTree(entity);
        CopyOnWriteArrayList<StaffInfo> cowList = new CopyOnWriteArrayList<>(staffInfoList);
        return staffInfoService.getStaffInfoRepertoryTreeJson(cowList);
    }


    /**
     *查询问题库列表
     *@author
     *@date
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/reportFormList", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("problemLibraryReportForm:query")
    public String getProblemLibraryList(HttpServletRequest request, @ModelAttribute ProblemLibrary entity, Model model) {
        logger.info("[ReportFormController][getProblemLibraryList] 查询问题库列表:");
        entity.setDeleteFlag(0L);
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = problemLibraryService.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("problemLibrary", entity);
        return "reportForm/listProblemLibraryReportForm";
    }
    /**
     * 分页查询ProblemLibrary对象
     * @param    entity  对象
     * @author
     * @date   2018-11-19 18:06:32
     * @updater  or other
     * @return   com.info.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "problemLibraryPageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult problemLibraryPageQuery(HttpServletRequest request,ProblemLibrary entity) {
        logger.info("[ReportFormController][problemLibraryPageQuery] 查询ProblemLibrary对象:");
        try {
            entity.setDeleteFlag(0L);
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);
            PageUtil paginator = problemLibraryService.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[ReportFormController][problemLibraryPageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     *问题报表 树
     *@return   java.lang.String
     *@author
     *@createTime   2018/11/17
     *@updater  or other
     */
    @ResponseBody
    @RequestMapping(value = "/problemLibraryRepertoryTree", method = { RequestMethod.GET, RequestMethod.POST })
    public Object problemLibraryRepertoryTree( ProblemLibrary entity ) {
        List<ProblemLibrary> problemLibraryList = problemLibraryService.queryProblemLibraryRepertoryTree(entity);
        CopyOnWriteArrayList<ProblemLibrary> cowList = new CopyOnWriteArrayList<>(problemLibraryList);
        return problemLibraryService.getProblemLibraryTreeJson(cowList);
    }



    /**
     *查询仓库列表
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/repertoryList", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("repertoryRepertory:query")
    public String getRepertoryList(HttpServletRequest request, @ModelAttribute Repertory entity, Model model) {
        logger.info("[ReportFormController][getRepertoryList] 查询Repertory列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        entity.setDeleteFlag(0L);
        PageUtil paginator = repertoryService.pageQuery(entity, currentPageNum, currentPageSize);
        List<ProjectSurvey> projectSurveyList =projectSurveyService.getAll();
        model.addAttribute("paginator", paginator);
        model.addAttribute("repertory", entity);
        model.addAttribute("projectSurveyList", projectSurveyList);
        return "reportForm/listRepertoryReportForm";
    }

    /**
     * 分页查询Repertory对象
     * @param    entity  对象
     * @author
     * @date   2018-11-19 18:06:32
     * @updater  or other
     * @return   com.info.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "repertoryPageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult repertoryPageQuery(HttpServletRequest request,Repertory entity) {
        logger.info("[ReportFormController][problemLibraryPageQuery] 查询ProblemLibrary对象:");
        try {
            entity.setDeleteFlag(0L);
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);
            PageUtil paginator = repertoryService.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[ReportFormController][repertoryPageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }


    /**
     *问题报表 树
     *@return   java.lang.String
     *@author
     *@createTime   2018/11/17
     *@updater  or other
     */
    @ResponseBody
    @RequestMapping(value = "/repertoryRepertoryTree", method = { RequestMethod.GET, RequestMethod.POST })
    public Object repertoryRepertoryTree( Repertory entity ) {
        List<Repertory> repertoryList = repertoryService.queryRepertoryRepertoryTree(entity);
        CopyOnWriteArrayList<Repertory> cowList = new CopyOnWriteArrayList<>(repertoryList);
        return repertoryService.getRepertoryRepertoryTreeJson(cowList);
    }



    /**
     *查询设备信息报表列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/equipmentInfoList", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("equipmentInfoRepertory:query")
    public String getEquipmentInfoList(HttpServletRequest request, @ModelAttribute EquipmentInfo entity, Model model) {
        logger.info("[ReportFormController][getEquipmentInfoList] 查询设备信息列表:");
        entity.setDeleteFlag(0L);
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = equipmentInfoService.pageQuery(entity, currentPageNum, currentPageSize);
        List<ProjectSurvey> projectSurveyList =projectSurveyService.getAll();
        model.addAttribute("paginator", paginator);
        model.addAttribute("equipmentInfo", entity);
        model.addAttribute("projectSurveyList", projectSurveyList);
        return "reportForm/listEquipmentInfoRepertory";
    }


    /**
     * 分页查询EquipmentInfo对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-20 17:37:49
     * @updater  or other
     * @return   com.info.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "equipmentInfoPageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult equipmentInfoPageQuery(HttpServletRequest request,EquipmentInfo entity) {
        logger.info("[ReportFormController][equipmentInfoPageQuery] 查询EquipmentInfo对象:");
        try {
            entity.setDeleteFlag(0L);
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = equipmentInfoService.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[ReportFormController][equipmentInfoPageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     *设备报表 树
     *@return   java.lang.String
     *@author
     *@createTime   2018/11/17
     *@updater  or other
     */
    @ResponseBody
    @RequestMapping(value = "/equipmentInfoRepertoryTree", method = { RequestMethod.GET, RequestMethod.POST })
    public Object equipmentInfoRepertoryTree( EquipmentInfo entity ) {
        List<EquipmentInfo> equipmentInfoList = equipmentInfoService.queryEquipmentInfoRepertoryTree(entity);
        CopyOnWriteArrayList<EquipmentInfo> cowList = new CopyOnWriteArrayList<>(equipmentInfoList);
        return equipmentInfoService.getEquipmentInfoRepertoryTreeJson(cowList);
    }


    /**
     *查询工装信息列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/frockInfoList", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("frockInfoRepertory:query")
    public String getFrockInfoList(HttpServletRequest request, @ModelAttribute FrockInfo entity, Model model) {
        logger.info("[ReportFormController][getFrockInfoList] 查询设备信息列表:");
        entity.setDeleteFlag(0L);
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = frockInfoService.pageQuery(entity, currentPageNum, currentPageSize);
        List<ProjectSurvey> projectSurveyList =projectSurveyService.getAll();
        model.addAttribute("paginator", paginator);
        model.addAttribute("frockInfo", entity);
        model.addAttribute("projectSurveyList", projectSurveyList);
        return "reportForm/listFrockInfoRepertory";
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
    @RequestMapping(value = "frockInfoPageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult frockInfoPageQuery(HttpServletRequest request,FrockInfo entity) {
        logger.info("[ReportFormController][frockInfoPageQuery] 查询FrockInfo对象:");
        try {
            entity.setDeleteFlag(0L);
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = frockInfoService.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[ReportFormController][frockInfoPageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     *工装报表 树
     *@return   java.lang.String
     *@author
     *@createTime   2018/11/17
     *@updater  or other
     */
    @ResponseBody
    @RequestMapping(value = "/frockInfoRepertoryTree", method = { RequestMethod.GET, RequestMethod.POST })
    public Object frockInfoRepertoryTree( FrockInfo entity ) {
        List<FrockInfo> frockInfoList = frockInfoService.queryFrockInfoRepertoryTree(entity);
        CopyOnWriteArrayList<FrockInfo> cowList = new CopyOnWriteArrayList<>(frockInfoList);
        return frockInfoService.getFrockInfoRepertoryTreeJson(cowList);
    }
}
