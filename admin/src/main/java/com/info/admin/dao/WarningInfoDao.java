package com.info.admin.dao;

import com.info.admin.entity.WarningInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 预警设置 Dao
 */
public interface WarningInfoDao {
	/**
	 *添加WarningInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(WarningInfo entity);

	/**
	 *修改WarningInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(WarningInfo entity);

	/**
	 *查询WarningInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<WarningInfo>
	 */
	List<WarningInfo> query(@Param("entity") WarningInfo entity);

	/**
	 *删除WarningInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") WarningInfo entity);

    /**
     * 分页查询WarningInfo对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<WarningInfo> 
     */
    List<WarningInfo> pageQuery(@Param("entity") WarningInfo entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询WarningInfo总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") WarningInfo entity);

	/**
	 * 根据 id获取 预警设置 
	 *@author   ysh
	 *@param warningId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   WarningInfo
	 */
	public WarningInfo getWarningInfoById(String warningId);
}
