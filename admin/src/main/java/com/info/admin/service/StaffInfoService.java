package com.info.admin.service;

import com.info.admin.entity.StaffInfo;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-13 09:49:00 
 * @describe 员工信息 Service
 */
public interface StaffInfoService {
    /**
     *添加StaffInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return int
     */
    int insert(StaffInfo entity);

    /**
     *修改StaffInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return int
     */
    int update(StaffInfo entity);

    /**
     *查询StaffInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return List<StaffInfo>
     */
    List<StaffInfo> query(StaffInfo entity);

    /**
     *删除StaffInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return int
     */
    int delete(StaffInfo entity);

    /**
     * 分页查询StaffInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 09:49:00 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(StaffInfo entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 员工信息
	 * @author   ysh
	 * @param staffId 主键id
	 * @date  2018-11-13 09:49:00
	 * @updater  or other
	 * @return   StaffInfo
	 */ 
	public StaffInfo getStaffInfoById(String staffId);
	
}

	
