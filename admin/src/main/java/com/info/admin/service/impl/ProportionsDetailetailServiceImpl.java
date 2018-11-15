package com.info.admin.service.impl;

import com.info.admin.dao.ProportionsDetailetailDao;
import com.info.admin.entity.ProportionsDetailetail;
import com.info.admin.service.ProportionsDetailetailService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-15 22:58:50
 * @describe 配合比详情 ServiceImpl
 */
@Service
public class ProportionsDetailetailServiceImpl implements ProportionsDetailetailService {

    @Autowired
    private ProportionsDetailetailDao dao;

    /**
     *添加ProportionsDetailetail对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(ProportionsDetailetail entity){
        entity.setDetailId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改ProportionsDetailetail对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int update(ProportionsDetailetail entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询ProportionsDetailetail对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return List<ProportionsDetailetail>
     */
    @Override
    public List<ProportionsDetailetail> query(ProportionsDetailetail entity){
        return dao.query(entity);
    }

    /**
     *删除ProportionsDetailetail对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(ProportionsDetailetail entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询ProportionsDetailetail对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:50 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(ProportionsDetailetail entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<ProportionsDetailetail> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 配合比详情
	 *@author   ysh
	 *@param detailId 主键id
	 *@date  2018-11-15 22:58:50
	 *@updater  or other
	 *@return   ProportionsDetailetail
	 */ 
	 @Override
	 public ProportionsDetailetail getProportionsDetailetailById(String detailId) {
		 return dao.getProportionsDetailetailById(detailId);
	 }
}

	
