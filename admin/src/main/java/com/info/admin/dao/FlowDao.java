package com.info.admin.dao;

import com.info.admin.entity.Flow;
import com.info.admin.vo.FlowVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 流程 Dao
 */
public interface FlowDao {
	/**
	 *添加Flow对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(Flow entity);

	/**
	 *修改Flow对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(Flow entity);

	/**
	 *查询Flow对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<Flow>
	 */
	List<Flow> query(@Param("entity") Flow entity);

	/**
	 *删除Flow对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
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
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<Flow> 
     */
    List<Flow> pageQuery(@Param("entity") Flow entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询Flow对象
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41
     * @updater or other
     * @return   List<Flow>
     */
    List<FlowVo> queryFlow(@Param("entity") Flow entity);

    /**
     * 分页查询Flow对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41
     * @updater or other
     * @return   List<Flow>
     */
    List<FlowVo> queryPageFlow(@Param("entity") Flow entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

     /**
      * 分页查询待办Flow对象
      * @param entity  对象
      * @param offset	页数
      * @param pageSize	大小
      * @author  ysh
      * @date  2018-11-14 23:45:41
      * @updater or other
      * @return   List<Flow>
      */
     List<Flow> pageDbQuery(@Param("entity") Flow entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

     /**
      * 分页查询在办Flow对象
      * @param entity  对象
      * @param offset	页数
      * @param pageSize	大小
      * @author  ysh
      * @date  2018-11-14 23:45:41
      * @updater or other
      * @return   List<Flow>
      */
     List<Flow> pageZbQuery(@Param("entity") Flow entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

     /**
      * 分页查询办结Flow对象
      * @param entity  对象
      * @param offset	页数
      * @param pageSize	大小
      * @author  ysh
      * @date  2018-11-14 23:45:41
      * @updater or other
      * @return   List<Flow>
      */
     List<Flow> pageBjQuery(@Param("entity") Flow entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询Flow总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") Flow entity);

    /**
     * 查询Flow总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41
     * @updater or other
     * @return   int
     */
    int queryFlowCount(@Param("entity") Flow entity);

     /**
      * 查询待办Flow总记录数
      * @param entity  对象
      * @author  ysh
      * @date  2018-11-14 23:45:41
      * @updater or other
      * @return   int
      */
     int getDbPageCount(@Param("entity") Flow entity);

     /**
      * 查询待办Flow总记录数
      * @param entity  对象
      * @author  ysh
      * @date  2018-11-14 23:45:41
      * @updater or other
      * @return   int
      */
     int getZbPageCount(@Param("entity") Flow entity);

     /**
      * 查询待办Flow总记录数
      * @param entity  对象
      * @author  ysh
      * @date  2018-11-14 23:45:41
      * @updater or other
      * @return   int
      */
     int getBjPageCount(@Param("entity") Flow entity);

	/**
	 * 根据 id获取 流程 
	 *@author   ysh
	 *@param flowId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   Flow
	 */
	 Flow getFlowById(String flowId);
	/**
	 * 根据 id获取 流程
	 *@author   ysh
	 *@param flowId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   Flow
	 */
	 FlowVo getFlowByIdVo(String flowId);

	 /**
	  * 批量流程
	  * @author   ljuenan
	  * @param list 流程列表
	  * @date  2018-11-14 23:45:42
	  * @updater  or other
	  * @return   Flow
	  */
	 int batchFlow(@Param("list") List<Flow> list);

	 /**
	  * 根据docunid获取flow对象
	  * @param entity
	  * @return
	  */
	 List<Flow> getFlowByDocUnid(@Param("entity") Flow entity);
}
