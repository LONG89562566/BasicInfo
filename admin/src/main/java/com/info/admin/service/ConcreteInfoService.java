package com.info.admin.service;

import com.info.admin.entity.ConcreteInfo;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42 
 * @describe 混泥土信息 Service
 */
public interface ConcreteInfoService {
    /**
     *添加ConcreteInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int insert(ConcreteInfo entity);

    /**
     *修改ConcreteInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int update(ConcreteInfo entity);

    /**
     *查询ConcreteInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<ConcreteInfo>
     */
    List<ConcreteInfo> query(ConcreteInfo entity);

    /**
     *删除ConcreteInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int delete(ConcreteInfo entity);

    /**
     * 分页查询ConcreteInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(ConcreteInfo entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 混泥土信息
	 * @author   ysh
	 * @param concreteId 主键id
	 * @date  2018-11-14 23:45:42
	 * @updater  or other
	 * @return   ConcreteInfo
	 */ 
	public ConcreteInfo getConcreteInfoById(String concreteId);
	
}

	
