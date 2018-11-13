package com.info.admin.dao;

import com.info.admin.entity.D3Pay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-13 09:49:00
 * @describe 三维交底 Dao
 */
public interface D3PayDao {
	/**
	 *添加D3Pay对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 09:49:00 
	 *@updater or other
	 *@return int
	 */
	int insert(D3Pay entity);

	/**
	 *修改D3Pay对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 09:49:00 
	 *@updater or other
	 *@return int
	 */
	int update(D3Pay entity);

	/**
	 *查询D3Pay对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 09:49:00 
	 *@updater or other
	 *@return List<D3Pay>
	 */
	List<D3Pay> query(@Param("entity") D3Pay entity);

	/**
	 *删除D3Pay对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 09:49:00 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") D3Pay entity);

    /**
     * 分页查询D3Pay对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 09:49:00 
     * @updater or other
     * @return   List<D3Pay> 
     */
    List<D3Pay> pageQuery(@Param("entity") D3Pay entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询D3Pay总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-13 09:49:00 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") D3Pay entity);

	/**
	 * 根据 id获取 三维交底 
	 *@author   ysh
	 *@param payId 主键id
	 *@date  2018-11-13 09:49:00
	 *@updater  or other
	 *@return   D3Pay
	 */
	public D3Pay getD3PayById(String payId);
}
