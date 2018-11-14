package com.info.admin.service.impl;

import com.info.admin.dao.ConcreteInfoDao;
import com.info.admin.entity.ConcreteInfo;
import com.info.admin.service.ConcreteInfoService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42
 * @describe 混泥土信息 ServiceImpl
 */
@Service
public class ConcreteInfoServiceImpl implements ConcreteInfoService {

    @Autowired
    private ConcreteInfoDao dao;

    /**
     *添加ConcreteInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(ConcreteInfo entity){
        entity.setConcreteId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改ConcreteInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int update(ConcreteInfo entity){
        return dao.update(entity);
    }

    /**
     *查询ConcreteInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<ConcreteInfo>
     */
    @Override
    public List<ConcreteInfo> query(ConcreteInfo entity){
        return dao.query(entity);
    }

    /**
     *删除ConcreteInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(ConcreteInfo entity){
        return dao.delete(entity);
    }

    /**
     * 分页查询ConcreteInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(ConcreteInfo entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<ConcreteInfo> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 混泥土信息
	 *@author   ysh
	 *@param concreteId 主键id
	 *@date  2018-11-14 23:45:42
	 *@updater  or other
	 *@return   ConcreteInfo
	 */ 
	 @Override
	 public ConcreteInfo getConcreteInfoById(String concreteId) {
		 return dao.getConcreteInfoById(concreteId);
	 }
}

	
