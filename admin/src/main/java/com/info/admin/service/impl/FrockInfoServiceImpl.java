package com.info.admin.service.impl;

import com.info.admin.dao.FrockInfoDao;
import com.info.admin.entity.FrockInfo;
import com.info.admin.service.FrockInfoService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42
 * @describe 设备信息 ServiceImpl
 */
@Service
public class FrockInfoServiceImpl implements FrockInfoService {

    @Autowired
    private FrockInfoDao dao;

    /**
     *添加FrockInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(FrockInfo entity){
        entity.setSupplierId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改FrockInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int update(FrockInfo entity){
        return dao.update(entity);
    }

    /**
     *查询FrockInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<FrockInfo>
     */
    @Override
    public List<FrockInfo> query(FrockInfo entity){
        return dao.query(entity);
    }

    /**
     *删除FrockInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(FrockInfo entity){
        return dao.delete(entity);
    }

    /**
     * 分页查询FrockInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(FrockInfo entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<FrockInfo> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 设备信息
	 *@author   ysh
	 *@param supplierId 主键id
	 *@date  2018-11-14 23:45:42
	 *@updater  or other
	 *@return   FrockInfo
	 */ 
	 @Override
	 public FrockInfo getFrockInfoById(String supplierId) {
		 return dao.getFrockInfoById(supplierId);
	 }
}

	
