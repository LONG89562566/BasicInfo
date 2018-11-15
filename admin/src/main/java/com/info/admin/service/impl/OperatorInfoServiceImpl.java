package com.info.admin.service.impl;

import com.info.admin.dao.OperatorInfoDao;
import com.info.admin.entity.OperatorInfo;
import com.info.admin.service.OperatorInfoService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-15 22:58:50
 * @describe 操作人员 ServiceImpl
 */
@Service
public class OperatorInfoServiceImpl implements OperatorInfoService {

    @Autowired
    private OperatorInfoDao dao;

    /**
     *添加OperatorInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(OperatorInfo entity){
        entity.setSupplierId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改OperatorInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int update(OperatorInfo entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询OperatorInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return List<OperatorInfo>
     */
    @Override
    public List<OperatorInfo> query(OperatorInfo entity){
        return dao.query(entity);
    }

    /**
     *删除OperatorInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(OperatorInfo entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询OperatorInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:50 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(OperatorInfo entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<OperatorInfo> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 操作人员
	 *@author   ysh
	 *@param supplierId 主键id
	 *@date  2018-11-15 22:58:50
	 *@updater  or other
	 *@return   OperatorInfo
	 */ 
	 @Override
	 public OperatorInfo getOperatorInfoById(String supplierId) {
		 return dao.getOperatorInfoById(supplierId);
	 }
}

	
