package com.info.admin.dao;

import com.info.admin.entity.StaffInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-13 16:23:57
 * @describe 员工信息 Dao
 */
public interface StaffInfoDao {
	/**
	 *添加StaffInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return int
	 */
	int insert(StaffInfo entity);

	/**
	 *修改StaffInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return int
	 */
	int update(StaffInfo entity);

	/**
	 *查询StaffInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return List<StaffInfo>
	 */
	List<StaffInfo> query(@Param("entity") StaffInfo entity);

	/**
	 *删除StaffInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") StaffInfo entity);

    /**
     * 分页查询StaffInfo对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 16:23:57 
     * @updater or other
     * @return   List<StaffInfo> 
     */
    List<StaffInfo> pageQuery(@Param("entity") StaffInfo entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询StaffInfo总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-13 16:23:57 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") StaffInfo entity);

	/**
	 * 根据 id获取 员工信息 
	 *@author   ysh
	 *@param staffId 主键id
	 *@date  2018-11-13 16:23:57
	 *@updater  or other
	 *@return   StaffInfo
	 */
	public StaffInfo getStaffInfoById(String staffId);
}
