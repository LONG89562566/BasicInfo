package com.info.admin.dao;

import com.info.admin.entity.OrgInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 组织机构信息 Dao
 */
public interface OrgInfoDao {
	/**
	 *添加OrgInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(OrgInfo entity);

	/**
	 *修改OrgInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(OrgInfo entity);

	/**
	 *查询OrgInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<OrgInfo>
	 */
	List<OrgInfo> query(@Param("entity") OrgInfo entity);

	/**
	 *删除OrgInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") OrgInfo entity);

    /**
     * 分页查询OrgInfo对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<OrgInfo> 
     */
    List<OrgInfo> pageQuery(@Param("entity") OrgInfo entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询OrgInfo总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") OrgInfo entity);

	/**
	 * 根据 id获取 组织机构信息 
	 *@author   ysh
	 *@param orgId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   OrgInfo
	 */
	public OrgInfo getOrgInfoById(String orgId);
}
