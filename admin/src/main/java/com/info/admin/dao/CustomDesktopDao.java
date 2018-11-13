package com.info.admin.dao;

import com.info.admin.entity.CustomDesktop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-13 16:23:57
 * @describe 自定义桌面 Dao
 */
public interface CustomDesktopDao {
	/**
	 *添加CustomDesktop对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return int
	 */
	int insert(CustomDesktop entity);

	/**
	 *修改CustomDesktop对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return int
	 */
	int update(CustomDesktop entity);

	/**
	 *查询CustomDesktop对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return List<CustomDesktop>
	 */
	List<CustomDesktop> query(@Param("entity") CustomDesktop entity);

	/**
	 *删除CustomDesktop对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-13 16:23:57 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") CustomDesktop entity);

    /**
     * 分页查询CustomDesktop对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 16:23:57 
     * @updater or other
     * @return   List<CustomDesktop> 
     */
    List<CustomDesktop> pageQuery(@Param("entity") CustomDesktop entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询CustomDesktop总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-13 16:23:57 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") CustomDesktop entity);

	/**
	 * 根据 id获取 自定义桌面 
	 *@author   ysh
	 *@param desktopId 主键id
	 *@date  2018-11-13 16:23:57
	 *@updater  or other
	 *@return   CustomDesktop
	 */
	public CustomDesktop getCustomDesktopById(String desktopId);
}
