package com.info.admin.dao;

import com.info.admin.entity.FileAttr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 文件 Dao
 */
public interface FileAttrDao {
	/**
	 *添加FileAttr对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(FileAttr entity);

	/**
	 *添加FileAttr对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41
	 *@updater or other
	 *@return int
	 */
	int insertBatchFileAttr(@Param("batchList")List<FileAttr> fileAttrLs);

	/**
	 *修改FileAttr对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(FileAttr entity);

	/**
	 *查询FileAttr对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<FileAttr>
	 */
	List<FileAttr> query(@Param("entity") FileAttr entity);

	/**
	 *删除FileAttr对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") FileAttr entity);

    /**
     * 分页查询FileAttr对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<FileAttr> 
     */
    List<FileAttr> pageQuery(@Param("entity") FileAttr entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询FileAttr总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") FileAttr entity);

	/**
	 * 根据 id获取 文件 
	 *@author   ysh
	 *@param fileId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   FileAttr
	 */
	public FileAttr getFileAttrById(String fileId);
}
