package com.info.admin.dao;

import com.info.admin.entity.ProportionsDetailetail;
import com.info.admin.entity.ProportionsMaterial;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 配合比详情 Dao
 */
public interface ProportionsDetailetailDao {
	/**
	 *添加ProportionsDetailetail对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(ProportionsDetailetail entity);

	/**
	 *修改ProportionsDetailetail对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(ProportionsDetailetail entity);

	/**
	 *查询ProportionsDetailetail对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<ProportionsDetailetail>
	 */
	List<ProportionsDetailetail> query(@Param("entity") ProportionsDetailetail entity);

	/**
	 *删除ProportionsDetailetail对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") ProportionsDetailetail entity);

    /**
     * 分页查询ProportionsDetailetail对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<ProportionsDetailetail> 
     */
    List<ProportionsDetailetail> pageQuery(@Param("entity") ProportionsDetailetail entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询ProportionsDetailetail总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") ProportionsDetailetail entity);

	/**
	 * 根据 id获取 配合比详情 
	 *@author   ysh
	 *@param detailId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   ProportionsDetailetail
	 */
	public ProportionsDetailetail getProportionsDetailetailById(String detailId);

	 /**
	  *  ProportionsDetailetail批量入库
	  *@author
	  * @param  proportionsMaterialList 入库对象
	  *@createTime   2
	  *@updater  or other
	  *@return   Integer
	  */
	 public Integer batchProportionsMaterial(@Param("proportionsMaterialList")List<ProportionsMaterial> proportionsMaterialList);

	 /**
	  * 根据 id获取 配合比材料详情
	  *@author
	  *@param
	  *@date  2018-11-14 23:45:41
	  *@updater  or other
	  *@return   ProportionsDetailetail
	  */
	 public List<ProportionsMaterial> getProportionsMaterialById(String detailId);

	 /**
	  *修改ProportionsDetailetail对象
	  *@param  proportionsMaterial 对象
	  *@author  ysh
	  *@date  2018-11-14 23:45:41
	  *@updater or other
	  *@return int
	  */
	 int updateProportionsMaterial(ProportionsMaterial proportionsMaterial);

}
