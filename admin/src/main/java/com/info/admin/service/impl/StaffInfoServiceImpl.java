package com.info.admin.service.impl;

import com.info.admin.dao.StaffInfoDao;
import com.info.admin.entity.StaffInfo;
import com.info.admin.service.StaffInfoService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-13 09:49:00
 * @describe 员工信息 ServiceImpl
 */
@Service
public class StaffInfoServiceImpl implements StaffInfoService {

    @Autowired
    private StaffInfoDao dao;

    /**
     *添加StaffInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(StaffInfo entity){
        entity.setStaffId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改StaffInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return int
     */
    @Override
    public int update(StaffInfo entity){
        return dao.update(entity);
    }

    /**
     *查询StaffInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return List<StaffInfo>
     */
    @Override
    public List<StaffInfo> query(StaffInfo entity){
        return dao.query(entity);
    }

    /**
     *删除StaffInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 09:49:00 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(StaffInfo entity){
        return dao.delete(entity);
    }

    /**
     * 分页查询StaffInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 09:49:00 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(StaffInfo entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<StaffInfo> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 员工信息
	 *@author   ysh
	 *@param staffId 主键id
	 *@date  2018-11-13 09:49:00
	 *@updater  or other
	 *@return   StaffInfo
	 */ 
	 @Override
	 public StaffInfo getStaffInfoById(String staffId) {
		 return dao.getStaffInfoById(staffId);
	 }
}

	
