package com.info.admin.service;

import com.info.admin.entity.ReleaseInfo;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:41 
 * @describe 信息发布 Service
 */
public interface ReleaseInfoService {
    /**
     *添加ReleaseInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int insert(ReleaseInfo entity);

    /**
     *修改ReleaseInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int update(ReleaseInfo entity);

    /**
     *查询ReleaseInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return List<ReleaseInfo>
     */
    List<ReleaseInfo> query(ReleaseInfo entity);

    /**
     *删除ReleaseInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int delete(ReleaseInfo entity);

    /**
     * 分页查询ReleaseInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(ReleaseInfo entity, int pageNum, int pageSize);

    /**
     * 分页查询ReleaseInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQueryUserId(ReleaseInfo entity, int pageNum, int pageSize);

    /**
     * 分页查询ReleaseInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQueryUserAll(ReleaseInfo entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 信息发布
	 * @author   ysh
	 * @param releaseId 主键id
	 * @date  2018-11-14 23:45:41
	 * @updater  or other
	 * @return   ReleaseInfo
	 */ 
	public ReleaseInfo getReleaseInfoById(String releaseId);
	
}

	
