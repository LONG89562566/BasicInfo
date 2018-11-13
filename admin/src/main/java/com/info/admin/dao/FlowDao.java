package com.info.admin.dao;

import com.info.admin.entity.Flow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-13 16:23:57
 * @describe 流程 Dao
 */
public interface FlowDao {
	/**
	 *添加Flow对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return int
	 */
	int insert(Flow entity);

	/**
	 *修改Flow对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return int
	 */
	int update(Flow entity);

	/**
	 *查询Flow对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return List<Flow>
	 */
	List<Flow> query(@Param("entity") Flow entity);

	/**
	 *删除Flow对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") Flow entity);

    /**
     * 分页查询Flow对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 16:23:57 
     * @updater or other
     * @return   List<Flow> 
     */
    List<Flow> pageQuery(@Param("entity") Flow entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询Flow总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-13 16:23:57 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") Flow entity);

	/**
	 * 根据 id获取 流程 
	 *@author   ysh
	 *@param flowId 主键id
	 *@date  2018-11-13 16:23:57
	 *@updater  or other
	 *@return   Flow
	 */
	public Flow getFlowById(String flowId);
}
