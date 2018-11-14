package com.info.admin.dao;

import com.info.admin.entity.CodeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 二维码信息 Dao
 */
public interface CodeInfoDao {
	/**
	 *添加CodeInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(CodeInfo entity);

	/**
	 *修改CodeInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(CodeInfo entity);

	/**
	 *查询CodeInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<CodeInfo>
	 */
	List<CodeInfo> query(@Param("entity") CodeInfo entity);

	/**
	 *删除CodeInfo对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") CodeInfo entity);

    /**
     * 分页查询CodeInfo对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<CodeInfo> 
     */
    List<CodeInfo> pageQuery(@Param("entity") CodeInfo entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询CodeInfo总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") CodeInfo entity);

	/**
	 * 根据 id获取 二维码信息 
	 *@author   ysh
	 *@param codeId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   CodeInfo
	 */
	public CodeInfo getCodeInfoById(String codeId);
}
