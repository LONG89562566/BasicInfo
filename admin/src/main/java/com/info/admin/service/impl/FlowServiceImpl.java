package com.info.admin.service.impl;

import com.info.admin.dao.FlowDao;
import com.info.admin.entity.Flow;
import com.info.admin.service.FlowService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42
 * @describe 流程 ServiceImpl
 */
@Service
public class FlowServiceImpl implements FlowService {

    @Autowired
    private FlowDao dao;

    /**
     *添加Flow对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(Flow entity){
        entity.setFlowId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改Flow对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int update(Flow entity){
        return dao.update(entity);
    }

    /**
     *查询Flow对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<Flow>
     */
    @Override
    public List<Flow> query(Flow entity){
        return dao.query(entity);
    }

    /**
     *删除Flow对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(Flow entity){
        return dao.delete(entity);
    }

    /**
     * 分页查询Flow对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(Flow entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<Flow> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 流程
	 *@author   ysh
	 *@param flowId 主键id
	 *@date  2018-11-14 23:45:42
	 *@updater  or other
	 *@return   Flow
	 */ 
	 @Override
	 public Flow getFlowById(String flowId) {
		 return dao.getFlowById(flowId);
	 }
}

	
