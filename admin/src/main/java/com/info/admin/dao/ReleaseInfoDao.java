package com.info.admin.dao;

import com.info.admin.entity.ReleaseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 信息发布 Dao
 */
public interface ReleaseInfoDao {
	/**
	 *添加ReleaseInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(ReleaseInfo entity);

	/**
	 *修改ReleaseInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(ReleaseInfo entity);

	/**
	 *查询ReleaseInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<ReleaseInfo>
	 */
	List<ReleaseInfo> query(@Param("entity") ReleaseInfo entity);

	/**
	 *删除ReleaseInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") ReleaseInfo entity);

    /**
     * 分页查询ReleaseInfo对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<ReleaseInfo> 
     */
    List<ReleaseInfo> pageQuery(@Param("entity") ReleaseInfo entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 分页查询ReleaseInfo对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41
     * @updater or other
     * @return   List<ReleaseInfo>
     */
    List<ReleaseInfo> pageQueryUserId(@Param("entity") ReleaseInfo entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询ReleaseInfo总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") ReleaseInfo entity);

	/**
	 * 根据 id获取 信息发布 
	 *@author   ysh
	 *@param releaseId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   ReleaseInfo
	 */
	public ReleaseInfo getReleaseInfoById(String releaseId);
}
