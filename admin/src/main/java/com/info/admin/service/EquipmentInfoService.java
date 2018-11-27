package com.info.admin.service;

import com.info.admin.entity.EquipmentInfo;
import com.info.admin.utils.PageUtil;
import net.sf.json.JSONArray;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ysh
 * @date 2018-11-20 17:37:49 
 * @describe 设备信息 Service
 */
public interface EquipmentInfoService {
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
    List<EquipmentInfo> query(EquipmentInfo entity);

    /**
     *删除EquipmentInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-20 17:37:49 
     *@updater or other
     *@return int
     */
    int delete(EquipmentInfo entity);

    /**
     * 分页查询EquipmentInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-20 17:37:49 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(EquipmentInfo entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 设备信息
	 * @author   ysh
	 * @param supplierId 主键id
	 * @date  2018-11-20 17:37:49
	 * @updater  or other
	 * @return   EquipmentInfo
	 */ 
	public EquipmentInfo getEquipmentInfoById(String supplierId);


    /**
     *查询EquipmentInfo对象
     *@param  entity 对象
     *@author
     *@date  2018-11-14 23:45:42
     *@updater or other
     *@return List<EquipmentInfo>
     */

    List<EquipmentInfo> queryEquipmentInfoRepertoryTree(EquipmentInfo entity);

    /**
     * 返回人员报表树形结构json数据
     * @param equipmentInfoList 数据，因读大于写
     * @return JSONArray
     */
    JSONArray getEquipmentInfoRepertoryTreeJson(CopyOnWriteArrayList<EquipmentInfo> equipmentInfoList);
	
}

	
