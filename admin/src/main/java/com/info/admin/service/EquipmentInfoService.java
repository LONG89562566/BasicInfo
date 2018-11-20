package com.info.admin.service;

import com.info.admin.entity.EquipmentInfo;
import com.info.admin.utils.PageUtil;

import java.util.List;

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
	
}

	
