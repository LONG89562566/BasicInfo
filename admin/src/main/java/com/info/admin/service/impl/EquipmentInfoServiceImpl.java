package com.info.admin.service.impl;

import com.info.admin.dao.EquipmentInfoDao;
import com.info.admin.entity.EquipmentInfo;
import com.info.admin.service.EquipmentInfoService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-15 22:58:50
 * @describe 设备信息 ServiceImpl
 */
@Service
public class EquipmentInfoServiceImpl implements EquipmentInfoService {

    @Autowired
    private EquipmentInfoDao dao;

    /**
     *添加EquipmentInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(EquipmentInfo entity){
        entity.setSupplierId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改EquipmentInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int update(EquipmentInfo entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询EquipmentInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return List<EquipmentInfo>
     */
    @Override
    public List<EquipmentInfo> query(EquipmentInfo entity){
        return dao.query(entity);
    }

    /**
     *删除EquipmentInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(EquipmentInfo entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询EquipmentInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:50 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(EquipmentInfo entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<EquipmentInfo> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 设备信息
	 *@author   ysh
	 *@param supplierId 主键id
	 *@date  2018-11-15 22:58:50
	 *@updater  or other
	 *@return   EquipmentInfo
	 */ 
	 @Override
	 public EquipmentInfo getEquipmentInfoById(String supplierId) {
		 return dao.getEquipmentInfoById(supplierId);
	 }
}

	
