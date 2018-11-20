package com.info.admin.dao;

import com.info.admin.entity.ProblemLibrary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-19 18:06:32
 * @describe 问题库 Dao
 */
public interface ProblemLibraryDao {
	/**
	 *添加ProblemLibrary对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-19 18:06:32 
	 *@updater or other
	 *@return int
	 */
	int insert(ProblemLibrary entity);

	/**
	 *修改ProblemLibrary对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-19 18:06:32 
	 *@updater or other
	 *@return int
	 */
	int update(ProblemLibrary entity);

	/**
	 *查询ProblemLibrary对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-19 18:06:32 
	 *@updater or other
	 *@return List<ProblemLibrary>
	 */
	List<ProblemLibrary> query(@Param("entity") ProblemLibrary entity);

	/**
	 *删除ProblemLibrary对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-19 18:06:32 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") ProblemLibrary entity);

    /**
     * 分页查询ProblemLibrary对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-19 18:06:32 
     * @updater or other
     * @return   List<ProblemLibrary> 
     */
    List<ProblemLibrary> pageQuery(@Param("entity") ProblemLibrary entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询ProblemLibrary总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-19 18:06:32 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") ProblemLibrary entity);

	/**
	 * 根据 id获取 问题库 
	 *@author   ysh
	 *@param supplierId 主键id
	 *@date  2018-11-19 18:06:32
	 *@updater  or other
	 *@return   ProblemLibrary
	 */
	public ProblemLibrary getProblemLibraryById(String supplierId);
}
