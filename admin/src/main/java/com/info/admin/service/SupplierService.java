package com.info.admin.service;

import com.info.admin.entity.Supplier;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42 
 * @describe 供应商 Service
 */
public interface SupplierService {
    /**
     *添加Supplier对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int insert(Supplier entity);

    /**
     *修改Supplier对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int update(Supplier entity);

    /**
     *查询Supplier对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<Supplier>
     */
    List<Supplier> query(Supplier entity);

    /**
     *删除Supplier对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int delete(Supplier entity);

    /**
     * 分页查询Supplier对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(Supplier entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 供应商
	 * @author   ysh
	 * @param supplierId 主键id
	 * @date  2018-11-14 23:45:42
	 * @updater  or other
	 * @return   Supplier
	 */ 
	public Supplier getSupplierById(String supplierId);
	
}

	
