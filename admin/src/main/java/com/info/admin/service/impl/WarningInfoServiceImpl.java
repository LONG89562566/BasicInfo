package com.info.admin.service.impl;

import com.info.admin.dao.WarningInfoDao;
import com.info.admin.entity.WarningInfo;
import com.info.admin.service.WarningInfoService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-15 22:58:49
 * @describe 预警设置 ServiceImpl
 */
@Service
public class WarningInfoServiceImpl implements WarningInfoService {

    @Autowired
    private WarningInfoDao dao;

    /**
     *添加WarningInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:49 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(WarningInfo entity){
        entity.setWarningId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改WarningInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:49 
     *@updater or other
     *@return int
     */
    @Override
    public int update(WarningInfo entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询WarningInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:49 
     *@updater or other
     *@return List<WarningInfo>
     */
    @Override
    public List<WarningInfo> query(WarningInfo entity){
        return dao.query(entity);
    }

    /**
     *删除WarningInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:49 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(WarningInfo entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询WarningInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:49 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(WarningInfo entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<WarningInfo> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 预警设置
	 *@author   ysh
	 *@param warningId 主键id
	 *@date  2018-11-15 22:58:49
	 *@updater  or other
	 *@return   WarningInfo
	 */ 
	 @Override
	 public WarningInfo getWarningInfoById(String warningId) {
		 return dao.getWarningInfoById(warningId);
	 }
}

	
