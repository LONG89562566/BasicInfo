package com.info.admin.dao;

import com.info.admin.entity.ReleaseInfoLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-18 19:39:48
 * @describe 信息发布日志 Dao
 */
public interface ReleaseInfoLogDao {
	/**
	 *添加ReleaseInfoLog对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-18 19:39:48 
	 *@updater or other
	 *@return int
	 */
	int insert(ReleaseInfoLog entity);

	/**
	 *修改ReleaseInfoLog对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-18 19:39:48 
	 *@updater or other
	 *@return int
	 */
	int update(ReleaseInfoLog entity);

	/**
	 *查询ReleaseInfoLog对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-18 19:39:48 
	 *@updater or other
	 *@return List<ReleaseInfoLog>
	 */
	List<ReleaseInfoLog> query(@Param("entity") ReleaseInfoLog entity);

	/**
	 *删除ReleaseInfoLog对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-18 19:39:48 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") ReleaseInfoLog entity);

    /**
     * 分页查询ReleaseInfoLog对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-18 19:39:48 
     * @updater or other
     * @return   List<ReleaseInfoLog> 
     */
    List<ReleaseInfoLog> pageQuery(@Param("entity") ReleaseInfoLog entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询ReleaseInfoLog总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-18 19:39:48 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") ReleaseInfoLog entity);

	/**
	 * 根据 id获取 信息发布日志 
	 *@author   ysh
	 *@param releaseInfoLogId 主键id
	 *@date  2018-11-18 19:39:48
	 *@updater  or other
	 *@return   ReleaseInfoLog
	 */
	public ReleaseInfoLog getReleaseInfoLogById(Long releaseInfoLogId);
}
