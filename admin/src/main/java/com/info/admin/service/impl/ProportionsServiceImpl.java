package com.info.admin.service.impl;

import com.info.admin.dao.ProportionsDao;
import com.info.admin.entity.Proportions;
import com.info.admin.service.ProportionsService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-15 22:58:50
 * @describe 配合比 ServiceImpl
 */
@Service
public class ProportionsServiceImpl implements ProportionsService {

    @Autowired
    private ProportionsDao dao;

    /**
     *添加Proportions对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(Proportions entity){

        return dao.insert(entity);
    }

    /**
     *修改Proportions对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int update(Proportions entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询Proportions对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return List<Proportions>
     */
    @Override
    public List<Proportions> query(Proportions entity){
        return dao.query(entity);
    }

    /**
     *删除Proportions对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(Proportions entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询Proportions对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:50 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(Proportions entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<Proportions> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 配合比
	 *@author   ysh
	 *@param proportionsId 主键id
	 *@date  2018-11-15 22:58:50
	 *@updater  or other
	 *@return   Proportions
	 */ 
	 @Override
	 public Proportions getProportionsById(String proportionsId) {
		 return dao.getProportionsById(proportionsId);
	 }

    /**
     * 根据 梁场编号查询 配合比
     *@author
     *@param
     *@date  2018-11-14 23:45:41
     *@updater  or other
     *@return   Proportions
     */
    @Override
    public List<Proportions> getProportionsByProjectId(String projectId){
        return dao.getProportionsByProjectId(projectId);
    }
}

	
