package com.info.admin.service;

import com.info.admin.entity.FileAttr;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42 
 * @describe 文件 Service
 */
public interface FileAttrService {
    /**
     *添加FileAttr对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int insert(FileAttr entity);

    /**
     *批量添加FileAttr对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42
     *@updater or other
     *@return int
     */
    int insertBatchFileAttr(FileAttr entity,List<String> pathList);

    /**
     *批量添加FileAttr对象
     *@param  fileAttrs 文件数组
     *@author  ysh
     *@date  2018-11-14 23:45:42
     *@updater or other
     *@return int
     */
    int insertBatchFileAttr(List<FileAttr> fileAttrs);

    /**
     *修改FileAttr对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int update(FileAttr entity);

    /**
     *查询FileAttr对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<FileAttr>
     */
    List<FileAttr> query(FileAttr entity);

    /**
     *删除FileAttr对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int delete(FileAttr entity);

    /**
     * 分页查询FileAttr对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(FileAttr entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 文件
	 * @author   ysh
	 * @param fileId 主键id
	 * @date  2018-11-14 23:45:42
	 * @updater  or other
	 * @return   FileAttr
	 */ 
	public FileAttr getFileAttrById(String fileId);
	
}

	
