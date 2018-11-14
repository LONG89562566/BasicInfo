package com.info.admin.dao;

import com.info.admin.entity.RepairInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 操作人员 Dao
 */
public interface RepairInfoDao {
	/**
	 *添加RepairInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(RepairInfo entity);

	/**
	 *修改RepairInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(RepairInfo entity);

	/**
	 *查询RepairInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<RepairInfo>
	 */
	List<RepairInfo> query(@Param("entity") RepairInfo entity);

	/**
	 *删除RepairInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") RepairInfo entity);

    /**
     * 分页查询RepairInfo对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<RepairInfo> 
     */
    List<RepairInfo> pageQuery(@Param("entity") RepairInfo entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询RepairInfo总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") RepairInfo entity);

	/**
	 * 根据 id获取 操作人员 
	 *@author   ysh
	 *@param repairId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   RepairInfo
	 */
	public RepairInfo getRepairInfoById(String repairId);
}
