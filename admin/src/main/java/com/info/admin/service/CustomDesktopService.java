package com.info.admin.service;

import com.info.admin.entity.CustomDesktop;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-13 09:49:00 
 * @describe 自定义桌面 Service
 */
public interface CustomDesktopService {
    /**
     *添加CustomDesktop对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return int
     */
    int insert(CustomDesktop entity);

    /**
     *修改CustomDesktop对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return int
     */
    int update(CustomDesktop entity);

    /**
     *查询CustomDesktop对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return List<CustomDesktop>
     */
    List<CustomDesktop> query(CustomDesktop entity);

    /**
     *删除CustomDesktop对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return int
     */
    int delete(CustomDesktop entity);

    /**
     * 分页查询CustomDesktop对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 09:49:00 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(CustomDesktop entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 自定义桌面
	 * @author   ysh
	 * @param desktopId 主键id
	 * @date  2018-11-13 09:49:00
	 * @updater  or other
	 * @return   CustomDesktop
	 */ 
	public CustomDesktop getCustomDesktopById(String desktopId);
	
}

	
