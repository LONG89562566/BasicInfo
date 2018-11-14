package com.info.admin.service;

import com.info.admin.entity.D3Pay;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42 
 * @describe 三维交底 Service
 */
public interface D3PayService {
    /**
     *添加D3Pay对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int insert(D3Pay entity);

    /**
     *修改D3Pay对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int update(D3Pay entity);

    /**
     *查询D3Pay对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<D3Pay>
     */
    List<D3Pay> query(D3Pay entity);

    /**
     *删除D3Pay对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int delete(D3Pay entity);

    /**
     * 分页查询D3Pay对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(D3Pay entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 三维交底
	 * @author   ysh
	 * @param payId 主键id
	 * @date  2018-11-14 23:45:42
	 * @updater  or other
	 * @return   D3Pay
	 */ 
	public D3Pay getD3PayById(String payId);
	
}

	
