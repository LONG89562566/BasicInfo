package com.info.admin.dao;

import com.info.admin.entity.BeamSection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 梁段信息 Dao
 */
public interface BeamSectionDao {
	/**
	 *添加BeamSection对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(BeamSection entity);

	/**
	 *修改BeamSection对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(BeamSection entity);

	/**
	 *查询BeamSection对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<BeamSection>
	 */
	List<BeamSection> query(@Param("entity") BeamSection entity);

	/**
	 *删除BeamSection对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") BeamSection entity);

    /**
     * 分页查询BeamSection对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<BeamSection> 
     */
    List<BeamSection> pageQuery(@Param("entity") BeamSection entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询BeamSection总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") BeamSection entity);

	/**
	 * 根据 id获取 梁段信息 
	 *@author   ysh
	 *@param sectionId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   BeamSection
	 */
	public BeamSection getBeamSectionById(String sectionId);
}
