package com.info.admin.dao;

import com.info.admin.entity.EquipmentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-20 17:37:49
 * @describe 设备信息 Dao
 */
public interface EquipmentInfoDao {
	/**
	 *添加EquipmentInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-20 17:37:49 
	 *@updater or other
	 *@return int
	 */
	int insert(EquipmentInfo entity);

	/**
	 *修改EquipmentInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-20 17:37:49 
	 *@updater or other
	 *@return int
	 */
	int update(EquipmentInfo entity);

	/**
	 *查询EquipmentInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-20 17:37:49 
	 *@updater or other
	 *@return List<EquipmentInfo>
	 */
	List<EquipmentInfo> query(@Param("entity") EquipmentInfo entity);

	/**
	 *删除EquipmentInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-20 17:37:49 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") EquipmentInfo entity);

    /**
     * 分页查询EquipmentInfo对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-20 17:37:49 
     * @updater or other
     * @return   List<EquipmentInfo> 
     */
    List<EquipmentInfo> pageQuery(@Param("entity") EquipmentInfo entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询EquipmentInfo总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-20 17:37:49 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") EquipmentInfo entity);

	/**
	 * 根据 id获取 设备信息 
	 *@author   ysh
	 *@param supplierId 主键id
	 *@date  2018-11-20 17:37:49
	 *@updater  or other
	 *@return   EquipmentInfo
	 */
	public EquipmentInfo getEquipmentInfoById(String supplierId);
}
