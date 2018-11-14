package com.info.admin.service.impl;

import com.info.admin.dao.SupplierDao;
import com.info.admin.entity.Supplier;
import com.info.admin.service.SupplierService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42
 * @describe 供应商 ServiceImpl
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao dao;

    /**
     *添加Supplier对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(Supplier entity){
        entity.setSupplierId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改Supplier对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int update(Supplier entity){
        return dao.update(entity);
    }

    /**
     *查询Supplier对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<Supplier>
     */
    @Override
    public List<Supplier> query(Supplier entity){
        return dao.query(entity);
    }

    /**
     *删除Supplier对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(Supplier entity){
        return dao.delete(entity);
    }

    /**
     * 分页查询Supplier对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(Supplier entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<Supplier> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 供应商
	 *@author   ysh
	 *@param supplierId 主键id
	 *@date  2018-11-14 23:45:42
	 *@updater  or other
	 *@return   Supplier
	 */ 
	 @Override
	 public Supplier getSupplierById(String supplierId) {
		 return dao.getSupplierById(supplierId);
	 }
}

	
