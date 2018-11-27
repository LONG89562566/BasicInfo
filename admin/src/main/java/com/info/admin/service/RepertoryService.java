package com.info.admin.service;

import com.info.admin.entity.Repertory;
import com.info.admin.utils.PageUtil;
import net.sf.json.JSONArray;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42 
 * @describe 仓库 Service
 */
public interface RepertoryService {
    /**
     *添加Repertory对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int insert(Repertory entity);

    /**
     *修改Repertory对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int update(Repertory entity);

    /**
     *查询Repertory对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<Repertory>
     */
    List<Repertory> query(Repertory entity);

    /**
     *删除Repertory对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int delete(Repertory entity);

    /**
     * 分页查询Repertory对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(Repertory entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 仓库
	 * @author   ysh
	 * @param supplierId 主键id
	 * @date  2018-11-14 23:45:42
	 * @updater  or other
	 * @return   Repertory
	 */ 
	public Repertory getRepertoryById(String supplierId);

    /**
     *查询Repertory对象
     *@param  entity 对象
     *@author
     *@date  2018-11-14 23:45:42
     *@updater or other
     *@return List<StaffInfo>
     */

    List<Repertory> queryRepertoryRepertoryTree(Repertory entity);

    /**
     * 返回人员报表树形结构json数据
     * @param repertoryList 数据，因读大于写
     * @return JSONArray
     */
    JSONArray getRepertoryRepertoryTreeJson(CopyOnWriteArrayList<Repertory> repertoryList);
	
}

	
