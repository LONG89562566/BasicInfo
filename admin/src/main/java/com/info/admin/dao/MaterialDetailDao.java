package com.info.admin.dao;

import com.info.admin.entity.MaterialDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-28 15:06:08
 * @describe 材料出入库 Dao
 */
public interface MaterialDetailDao {
	/**
	 *添加MaterialDetail对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-28 15:06:08 
	 *@updater or other
	 *@return int
	 */
	int insert(MaterialDetail entity);

	/**
	 *修改MaterialDetail对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-28 15:06:08 
	 *@updater or other
	 *@return int
	 */
	int update(MaterialDetail entity);

	/**
	 *查询MaterialDetail对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-28 15:06:08 
	 *@updater or other
	 *@return List<MaterialDetail>
	 */
	List<MaterialDetail> query(@Param("entity") MaterialDetail entity);

	/**
	 *删除MaterialDetail对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-28 15:06:08 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") MaterialDetail entity);

    /**
     * 分页查询MaterialDetail对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-28 15:06:08 
     * @updater or other
     * @return   List<MaterialDetail> 
     */
    List<MaterialDetail> pageQuery(@Param("entity") MaterialDetail entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询MaterialDetail总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-28 15:06:08 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") MaterialDetail entity);

	/**
	 * 根据 id获取 材料出入库 
	 *@author   ysh
	 *@param materialDetailId 主键id
	 *@date  2018-11-28 15:06:08
	 *@updater  or other
	 *@return   MaterialDetail
	 */
	public MaterialDetail getMaterialDetailById(String materialDetailId);

	 /**
	  *  MaterialDetail批量入库
	  *@author
	  * @param  materialDetailList 入库对象
	  *@createTime   2
	  *@updater  or other
	  *@return   Integer
	  */
	 public Integer batchMaterialDetail(@Param("materialDetailList")List<MaterialDetail> materialDetailList);


	 /**
	  * 分页查询MaterialDetail对象
	  * @param entity  对象
	  * @param offset	页数
	  * @param pageSize	大小
	  * @author  ysh
	  * @date  2018-11-28 15:06:08
	  * @updater or other
	  * @return   List<MaterialDetail>
	  */
	 List<MaterialDetail> outPageQuery(@Param("entity") MaterialDetail entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

	 /**
	  * 查询MaterialDetail总记录数
	  * @param entity  对象
	  * @author  ysh
	  * @date  2018-11-28 15:06:08
	  * @updater or other
	  * @return   int
	  */
	 int getOutPageCount(@Param("entity") MaterialDetail entity);

	 /**
	  * 修改 检验状态
	  * @param entity  对象
	  * @author  ysh
	  * @date  2018-11-28 15:06:08
	  * @updater or other
	  * @return   int
	  */
	 int updateTestMaterialDetail( MaterialDetail entity);

	 /**
	  * 查询MaterialDetail对象By outId
	  * @author  ysh
	  * @date  2018-11-28 15:06:08
	  * @updater or other
	  * @return   List<MaterialDetail>
	  */
	 List<MaterialDetail> getMaterialByOutId( String outId);

	 /**
	  * 查询MaterialDetail对象By outId
	  * @author  ysh
	  * @date  2018-11-28 15:06:08
	  * @updater or other
	  * @return   List<MaterialDetail>
	  */
	 MaterialDetail  getMaterialDetailByOutId( String outId);
}
