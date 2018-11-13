package com.info.admin.dao;

import com.info.admin.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-13 16:23:57
 * @describe 供应商 Dao
 */
public interface SupplierDao {
	/**
	 *添加Supplier对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return int
	 */
	int insert(Supplier entity);

	/**
	 *修改Supplier对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return int
	 */
	int update(Supplier entity);

	/**
	 *查询Supplier对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return List<Supplier>
	 */
	List<Supplier> query(@Param("entity") Supplier entity);

	/**
	 *删除Supplier对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") Supplier entity);

    /**
     * 分页查询Supplier对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 16:23:57 
     * @updater or other
     * @return   List<Supplier> 
     */
    List<Supplier> pageQuery(@Param("entity") Supplier entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询Supplier总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-13 16:23:57 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") Supplier entity);

	/**
	 * 根据 id获取 供应商 
	 *@author   ysh
	 *@param supplierId 主键id
	 *@date  2018-11-13 16:23:57
	 *@updater  or other
	 *@return   Supplier
	 */
	public Supplier getSupplierById(String supplierId);
}
