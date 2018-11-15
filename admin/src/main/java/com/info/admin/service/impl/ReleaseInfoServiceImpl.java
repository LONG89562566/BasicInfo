package com.info.admin.service.impl;

import com.info.admin.dao.ReleaseInfoDao;
import com.info.admin.entity.ReleaseInfo;
import com.info.admin.service.ReleaseInfoService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-15 22:58:49
 * @describe 信息发布 ServiceImpl
 */
@Service
public class ReleaseInfoServiceImpl implements ReleaseInfoService {

    @Autowired
    private ReleaseInfoDao dao;

    /**
     *添加ReleaseInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:49 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(ReleaseInfo entity){
        entity.setReleaseId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改ReleaseInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:49 
     *@updater or other
     *@return int
     */
    @Override
    public int update(ReleaseInfo entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询ReleaseInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:49 
     *@updater or other
     *@return List<ReleaseInfo>
     */
    @Override
    public List<ReleaseInfo> query(ReleaseInfo entity){
        return dao.query(entity);
    }

    /**
     *删除ReleaseInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:49 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(ReleaseInfo entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询ReleaseInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:49 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(ReleaseInfo entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<ReleaseInfo> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 信息发布
	 *@author   ysh
	 *@param releaseId 主键id
	 *@date  2018-11-15 22:58:49
	 *@updater  or other
	 *@return   ReleaseInfo
	 */ 
	 @Override
	 public ReleaseInfo getReleaseInfoById(String releaseId) {
		 return dao.getReleaseInfoById(releaseId);
	 }
}

	
