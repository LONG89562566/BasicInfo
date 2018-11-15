package com.info.admin.service.impl;

import com.info.admin.dao.FileAttrDao;
import com.info.admin.entity.FileAttr;
import com.info.admin.service.FileAttrService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-15 22:58:50
 * @describe 文件 ServiceImpl
 */
@Service
public class FileAttrServiceImpl implements FileAttrService {

    @Autowired
    private FileAttrDao dao;

    /**
     *添加FileAttr对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(FileAttr entity){
        entity.setFileId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改FileAttr对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int update(FileAttr entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询FileAttr对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return List<FileAttr>
     */
    @Override
    public List<FileAttr> query(FileAttr entity){
        return dao.query(entity);
    }

    /**
     *删除FileAttr对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(FileAttr entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询FileAttr对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:50 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(FileAttr entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<FileAttr> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 文件
	 *@author   ysh
	 *@param fileId 主键id
	 *@date  2018-11-15 22:58:50
	 *@updater  or other
	 *@return   FileAttr
	 */ 
	 @Override
	 public FileAttr getFileAttrById(String fileId) {
		 return dao.getFileAttrById(fileId);
	 }
}

	
