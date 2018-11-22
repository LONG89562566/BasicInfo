package com.info.admin.service;

import com.info.admin.entity.Proportions;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42 
 * @describe 配合比 Service
 */
public interface ProportionsService {
    /**
     *添加Proportions对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int insert(Proportions entity);

    /**
     *修改Proportions对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int update(Proportions entity);

    /**
     *查询Proportions对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<Proportions>
     */
    List<Proportions> query(Proportions entity);

    /**
     *删除Proportions对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int delete(Proportions entity);

    /**
     * 分页查询Proportions对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(Proportions entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 配合比
	 * @author   ysh
	 * @param proportionsId 主键id
	 * @date  2018-11-14 23:45:42
	 * @updater  or other
	 * @return   Proportions
	 */ 
	public Proportions getProportionsById(String proportionsId);

    /**
     * 根据 梁场编号查询 配合比
     *@author
     *@param
     *@date  2018-11-14 23:45:41
     *@updater  or other
     *@return   Proportions
     */
    public List<Proportions> getProportionsByProjectId(String projectId);

	
}

	
