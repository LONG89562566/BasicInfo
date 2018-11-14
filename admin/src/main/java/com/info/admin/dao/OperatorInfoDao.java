package com.info.admin.dao;

import com.info.admin.entity.OperatorInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 操作人员 Dao
 */
public interface OperatorInfoDao {
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
	List<OperatorInfo> query(@Param("entity") OperatorInfo entity);

	/**
	 *删除OperatorInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") OperatorInfo entity);

    /**
     * 分页查询OperatorInfo对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<OperatorInfo> 
     */
    List<OperatorInfo> pageQuery(@Param("entity") OperatorInfo entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询OperatorInfo总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") OperatorInfo entity);

	/**
	 * 根据 id获取 操作人员 
	 *@author   ysh
	 *@param supplierId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   OperatorInfo
	 */
	public OperatorInfo getOperatorInfoById(String supplierId);
}
