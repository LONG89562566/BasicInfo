package com.info.admin.controller.projectsurvey;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.ProjectSurvey;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.ProjectSurveyService;
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
 * @date 2018-11-13 16:23:57 
 * @describe 工程概况 Controller
 */
@Controller
@RequestMapping("/admin/projectSurveyGoal")
public class ProjectSurveyGoalController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(ProjectSurveyGoalController.class);

    @Autowired
    private ProjectSurveyService service;

     /**
     *查询工程概况列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/goalList", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("projectSurveyGoal:query")
    public String getProjectSurveyGoalList(HttpServletRequest request, @ModelAttribute ProjectSurvey entity, Model model) {
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("projectSurvey", entity);
        return "projectsurvey/listProjectSurveyGoal";
    }

    /**
     *跳转到设定/修改目标页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,String projectId,Model model){
        try{
            if(null != projectId){
                //根据id查询系统用户
                ProjectSurvey projectSurvey = service.getProjectSurveyById(projectId);
                model.addAttribute("projectSurvey", projectSurvey);
            }
            model.addAttribute("projectId", projectId);
            return "projectsurvey/addProjectSurveyGoal";
        }catch(Exception e){
            logger.error("[ProjectSurveyGoalController][addOrEdit]: projectId="+projectId, e);
            return "500";
        }
    }

}	
