package com.info.admin.service;

import com.info.admin.entity.RepairInfo;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:41 
 * @describe 操作人员 Service
 */
public interface RepairInfoService {
    /**
     *添加RepairInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int insert(RepairInfo entity);

    /**
     *修改RepairInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int update(RepairInfo entity);

    /**
     *查询RepairInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return List<RepairInfo>
     */
    List<RepairInfo> query(RepairInfo entity);

    /**
     *删除RepairInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int delete(RepairInfo entity);

    /**
     * 分页查询RepairInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(RepairInfo entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 操作人员
	 * @author   ysh
	 * @param repairId 主键id
	 * @date  2018-11-14 23:45:41
	 * @updater  or other
	 * @return   RepairInfo
	 */ 
	public RepairInfo getRepairInfoById(String repairId);
	
}

	
