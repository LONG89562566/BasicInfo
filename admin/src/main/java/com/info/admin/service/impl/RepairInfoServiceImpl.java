package com.info.admin.service.impl;

import com.info.admin.dao.RepairInfoDao;
import com.info.admin.entity.RepairInfo;
import com.info.admin.service.RepairInfoService;
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
public class RepairInfoServiceImpl implements RepairInfoService {

    @Autowired
    private RepairInfoDao dao;

    /**
     *添加RepairInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(RepairInfo entity){
        entity.setRepairId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改RepairInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int update(RepairInfo entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询RepairInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return List<RepairInfo>
     */
    @Override
    public List<RepairInfo> query(RepairInfo entity){
        return dao.query(entity);
    }

    /**
     *删除RepairInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(RepairInfo entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询RepairInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:50 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(RepairInfo entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<RepairInfo> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 操作人员
	 *@author   ysh
	 *@param repairId 主键id
	 *@date  2018-11-15 22:58:50
	 *@updater  or other
	 *@return   RepairInfo
	 */ 
	 @Override
	 public RepairInfo getRepairInfoById(String repairId) {
		 return dao.getRepairInfoById(repairId);
	 }
}

	
