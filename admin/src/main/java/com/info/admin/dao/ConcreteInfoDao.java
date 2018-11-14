package com.info.admin.dao;

import com.info.admin.entity.ConcreteInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 混泥土信息 Dao
 */
public interface ConcreteInfoDao {
	/**
	 *添加ConcreteInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(ConcreteInfo entity);

	/**
	 *修改ConcreteInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(ConcreteInfo entity);

	/**
	 *查询ConcreteInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<ConcreteInfo>
	 */
	List<ConcreteInfo> query(@Param("entity") ConcreteInfo entity);

	/**
	 *删除ConcreteInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") ConcreteInfo entity);

    /**
     * 分页查询ConcreteInfo对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<ConcreteInfo> 
     */
    List<ConcreteInfo> pageQuery(@Param("entity") ConcreteInfo entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询ConcreteInfo总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") ConcreteInfo entity);

	/**
	 * 根据 id获取 混泥土信息 
	 *@author   ysh
	 *@param concreteId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   ConcreteInfo
	 */
	public ConcreteInfo getConcreteInfoById(String concreteId);
}
