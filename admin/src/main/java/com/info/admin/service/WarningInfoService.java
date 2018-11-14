package com.info.admin.service;

import com.info.admin.entity.WarningInfo;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:41 
 * @describe 预警设置 Service
 */
public interface WarningInfoService {
    /**
     *添加WarningInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int insert(WarningInfo entity);

    /**
     *修改WarningInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int update(WarningInfo entity);

    /**
     *查询WarningInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return List<WarningInfo>
     */
    List<WarningInfo> query(WarningInfo entity);

    /**
     *删除WarningInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int delete(WarningInfo entity);

    /**
     * 分页查询WarningInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(WarningInfo entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 预警设置
	 * @author   ysh
	 * @param warningId 主键id
	 * @date  2018-11-14 23:45:41
	 * @updater  or other
	 * @return   WarningInfo
	 */ 
	public WarningInfo getWarningInfoById(String warningId);
	
}

	
