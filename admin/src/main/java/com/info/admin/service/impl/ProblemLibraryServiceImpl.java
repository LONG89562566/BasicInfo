package com.info.admin.service.impl;

import com.info.admin.dao.ProblemLibraryDao;
import com.info.admin.entity.ProblemLibrary;
import com.info.admin.service.ProblemLibraryService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-19 18:06:32
 * @describe 问题库 ServiceImpl
 */
@Service
public class ProblemLibraryServiceImpl implements ProblemLibraryService {

    @Autowired
    private ProblemLibraryDao dao;

    /**
     *添加ProblemLibrary对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-19 18:06:32 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(ProblemLibrary entity){
        entity.setSupplierId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改ProblemLibrary对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-19 18:06:32 
     *@updater or other
     *@return int
     */
    @Override
    public int update(ProblemLibrary entity){
        entity.setUpdateTime(new java.util.Date());
        return dao.update(entity);
    }

    /**
     *查询ProblemLibrary对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-19 18:06:32 
     *@updater or other
     *@return List<ProblemLibrary>
     */
    @Override
    public List<ProblemLibrary> query(ProblemLibrary entity){
        return dao.query(entity);
    }

    /**
     *删除ProblemLibrary对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-19 18:06:32 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(ProblemLibrary entity){
        entity.setDeleteFlag(1L);
        return dao.update(entity);

    }

    /**
     * 分页查询ProblemLibrary对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-19 18:06:32 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(ProblemLibrary entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<ProblemLibrary> result = dao.pageQuery(entity, offset, pageSize);

        return new PageUtil(pageSize, size, pageNum, result);
    }
    
    /**
	 * 根据 id获取 问题库
	 *@author   ysh
	 *@param supplierId 主键id
	 *@date  2018-11-19 18:06:32
	 *@updater  or other
	 *@return   ProblemLibrary
	 */ 
	 @Override
	 public ProblemLibrary getProblemLibraryById(String supplierId) {
		 return dao.getProblemLibraryById(supplierId);
	 }
}

	
