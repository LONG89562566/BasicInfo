package com.info.admin.service;

import com.info.admin.entity.ReleaseInfoLog;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-18 19:39:48 
 * @describe 信息发布日志 Service
 */
public interface ReleaseInfoLogService {
    /**
     *添加ReleaseInfoLog对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-18 19:39:48 
     *@updater or other
     *@return int
     */
    int insert(ReleaseInfoLog entity);

    /**
     *修改ReleaseInfoLog对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-18 19:39:48 
     *@updater or other
     *@return int
     */
    int update(ReleaseInfoLog entity);

    /**
     *查询ReleaseInfoLog对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-18 19:39:48 
     *@updater or other
     *@return List<ReleaseInfoLog>
     */
    List<ReleaseInfoLog> query(ReleaseInfoLog entity);

    /**
     *删除ReleaseInfoLog对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-18 19:39:48 
     *@updater or other
     *@return int
     */
    int delete(ReleaseInfoLog entity);

    /**
     * 分页查询ReleaseInfoLog对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-18 19:39:48 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(ReleaseInfoLog entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 信息发布日志
	 * @author   ysh
	 * @param releaseInfoLogId 主键id
	 * @date  2018-11-18 19:39:48
	 * @updater  or other
	 * @return   ReleaseInfoLog
	 */ 
	public ReleaseInfoLog getReleaseInfoLogById(Long releaseInfoLogId);
	
}

	
