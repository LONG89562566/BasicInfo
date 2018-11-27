package com.info.admin.service;

import com.info.admin.entity.FrockInfo;
import com.info.admin.utils.PageUtil;
import net.sf.json.JSONArray;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42 
 * @describe 设备信息 Service
 */
public interface FrockInfoService {
    /**
     *添加FrockInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int insert(FrockInfo entity);

    /**
     *修改FrockInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int update(FrockInfo entity);

    /**
     *查询FrockInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<FrockInfo>
     */
    List<FrockInfo> query(FrockInfo entity);

    /**
     *删除FrockInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int delete(FrockInfo entity);

    /**
     * 分页查询FrockInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(FrockInfo entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 设备信息
	 * @author   ysh
	 * @param supplierId 主键id
	 * @date  2018-11-14 23:45:42
	 * @updater  or other
	 * @return   FrockInfo
	 */ 
	public FrockInfo getFrockInfoById(String supplierId);
    /**
     *查询FrockInfo对象
     *@param  entity 对象
     *@author
     *@date  2018-11-14 23:45:42
     *@updater or other
     *@return List<EquipmentInfo>
     */

    List<FrockInfo> queryFrockInfoRepertoryTree(FrockInfo entity);

    /**
     * 返回人员报表树形结构json数据
     * @param frockInfoList 数据，因读大于写
     * @return JSONArray
     */
    JSONArray getFrockInfoRepertoryTreeJson(CopyOnWriteArrayList<FrockInfo> frockInfoList);


}

	
