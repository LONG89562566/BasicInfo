package com.info.admin.dao;

import com.info.admin.entity.FrockInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 设备信息 Dao
 */
public interface FrockInfoDao {
	/**
	 *添加FrockInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(FrockInfo entity);

	/**
	 *修改FrockInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(FrockInfo entity);

	/**
	 *查询FrockInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<FrockInfo>
	 */
	List<FrockInfo> query(@Param("entity") FrockInfo entity);

	/**
	 *删除FrockInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") FrockInfo entity);

    /**
     * 分页查询FrockInfo对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<FrockInfo> 
     */
    List<FrockInfo> pageQuery(@Param("entity") FrockInfo entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询FrockInfo总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") FrockInfo entity);

	/**
	 * 根据 id获取 设备信息 
	 *@author   ysh
	 *@param supplierId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   FrockInfo
	 */
	public FrockInfo getFrockInfoById(String supplierId);
}
