package com.info.admin.service;

import com.info.admin.entity.ProjectSurvey;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-13 09:49:00 
 * @describe 工程概况 Service
 */
public interface ProjectSurveyService {
    /**
     *添加ProjectSurvey对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return int
     */
    int insert(ProjectSurvey entity);

    /**
     *修改ProjectSurvey对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return int
     */
    int update(ProjectSurvey entity);

    /**
     *查询ProjectSurvey对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return List<ProjectSurvey>
     */
    List<ProjectSurvey> query(ProjectSurvey entity);

    /**
     *删除ProjectSurvey对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return int
     */
    int delete(ProjectSurvey entity);

    /**
     * 分页查询ProjectSurvey对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 09:49:00 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(ProjectSurvey entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 工程概况
	 * @author   ysh
	 * @param projectId 主键id
	 * @date  2018-11-13 09:49:00
	 * @updater  or other
	 * @return   ProjectSurvey
	 */ 
	public ProjectSurvey getProjectSurveyById(String projectId);
	
}

	
