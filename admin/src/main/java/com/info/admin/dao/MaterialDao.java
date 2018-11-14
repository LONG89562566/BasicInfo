package com.info.admin.dao;

import com.info.admin.entity.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 材料 Dao
 */
public interface MaterialDao {
	/**
	 *添加Material对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(Material entity);

	/**
	 *修改Material对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(Material entity);

	/**
	 *查询Material对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<Material>
	 */
	List<Material> query(@Param("entity") Material entity);

	/**
	 *删除Material对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") Material entity);

    /**
     * 分页查询Material对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<Material> 
     */
    List<Material> pageQuery(@Param("entity") Material entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询Material总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") Material entity);

	/**
	 * 根据 id获取 材料 
	 *@author   ysh
	 *@param materialId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   Material
	 */
	public Material getMaterialById(String materialId);
}
