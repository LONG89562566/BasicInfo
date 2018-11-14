package com.info.admin.service.impl;

import com.info.admin.dao.ProjectSurveyDao;
import com.info.admin.entity.ProjectSurvey;
import com.info.admin.service.ProjectSurveyService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42
 * @describe 工程概况 ServiceImpl
 */
@Service
public class ProjectSurveyServiceImpl implements ProjectSurveyService {

    @Autowired
    private ProjectSurveyDao dao;

    /**
     *添加ProjectSurvey对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(ProjectSurvey entity){
        entity.setProjectId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改ProjectSurvey对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int update(ProjectSurvey entity){
        return dao.update(entity);
    }

    /**
     *查询ProjectSurvey对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<ProjectSurvey>
     */
    @Override
    public List<ProjectSurvey> query(ProjectSurvey entity){
        return dao.query(entity);
    }

    /**
     *删除ProjectSurvey对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(ProjectSurvey entity){
        return dao.delete(entity);
    }

    /**
     * 分页查询ProjectSurvey对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(ProjectSurvey entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<ProjectSurvey> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 工程概况
	 *@author   ysh
	 *@param projectId 主键id
	 *@date  2018-11-14 23:45:42
	 *@updater  or other
	 *@return   ProjectSurvey
	 */ 
	 @Override
	 public ProjectSurvey getProjectSurveyById(String projectId) {
		 return dao.getProjectSurveyById(projectId);
	 }
}

	
