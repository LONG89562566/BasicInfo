package com.info.admin.service.impl;

import com.info.admin.dao.RepertoryDao;
import com.info.admin.entity.Repertory;
import com.info.admin.service.RepertoryService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42
 * @describe 仓库 ServiceImpl
 */
@Service
public class RepertoryServiceImpl implements RepertoryService {

    @Autowired
    private RepertoryDao dao;

    /**
     *添加Repertory对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(Repertory entity){
        entity.setSupplierId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改Repertory对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int update(Repertory entity){
        return dao.update(entity);
    }

    /**
     *查询Repertory对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<Repertory>
     */
    @Override
    public List<Repertory> query(Repertory entity){
        return dao.query(entity);
    }

    /**
     *删除Repertory对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(Repertory entity){
        return dao.delete(entity);
    }

    /**
     * 分页查询Repertory对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(Repertory entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<Repertory> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 仓库
	 *@author   ysh
	 *@param supplierId 主键id
	 *@date  2018-11-14 23:45:42
	 *@updater  or other
	 *@return   Repertory
	 */ 
	 @Override
	 public Repertory getRepertoryById(String supplierId) {
		 return dao.getRepertoryById(supplierId);
	 }
}

	
