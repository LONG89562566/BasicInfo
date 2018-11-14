package com.info.admin.service.impl;

import com.info.admin.dao.D3PayDao;
import com.info.admin.entity.D3Pay;
import com.info.admin.service.D3PayService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42
 * @describe 三维交底 ServiceImpl
 */
@Service
public class D3PayServiceImpl implements D3PayService {

    @Autowired
    private D3PayDao dao;

    /**
     *添加D3Pay对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(D3Pay entity){
        entity.setPayId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改D3Pay对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int update(D3Pay entity){
        return dao.update(entity);
    }

    /**
     *查询D3Pay对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<D3Pay>
     */
    @Override
    public List<D3Pay> query(D3Pay entity){
        return dao.query(entity);
    }

    /**
     *删除D3Pay对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(D3Pay entity){
        return dao.delete(entity);
    }

    /**
     * 分页查询D3Pay对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(D3Pay entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<D3Pay> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 三维交底
	 *@author   ysh
	 *@param payId 主键id
	 *@date  2018-11-14 23:45:42
	 *@updater  or other
	 *@return   D3Pay
	 */ 
	 @Override
	 public D3Pay getD3PayById(String payId) {
		 return dao.getD3PayById(payId);
	 }
}

	
