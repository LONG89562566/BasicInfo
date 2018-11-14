package com.info.admin.service;

import com.info.admin.entity.OperatorInfo;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:41 
 * @describe 操作人员 Service
 */
public interface OperatorInfoService {
    /**
     *添加OperatorInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int insert(OperatorInfo entity);

    /**
     *修改OperatorInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int update(OperatorInfo entity);

    /**
     *查询OperatorInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return List<OperatorInfo>
     */
    List<OperatorInfo> query(OperatorInfo entity);

    /**
     *删除OperatorInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int delete(OperatorInfo entity);

    /**
     * 分页查询OperatorInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(OperatorInfo entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 操作人员
	 * @author   ysh
	 * @param supplierId 主键id
	 * @date  2018-11-14 23:45:41
	 * @updater  or other
	 * @return   OperatorInfo
	 */ 
	public OperatorInfo getOperatorInfoById(String supplierId);
	
}

	
