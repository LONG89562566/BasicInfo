package com.info.admin.service.impl;

import com.info.admin.dao.OrgInfoDao;
import com.info.admin.entity.OrgInfo;
import com.info.admin.service.OrgInfoService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-13 16:23:57
 * @describe 组织机构信息 ServiceImpl
 */
@Service
public class OrgInfoServiceImpl implements OrgInfoService {

    @Autowired
    private OrgInfoDao dao;

    /**
     *添加OrgInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(OrgInfo entity){
        entity.setOrgId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改OrgInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    @Override
    public int update(OrgInfo entity){
        return dao.update(entity);
    }

    /**
     *查询OrgInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return List<OrgInfo>
     */
    @Override
    public List<OrgInfo> query(OrgInfo entity){
        return dao.query(entity);
    }

    /**
     *删除OrgInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(OrgInfo entity){
        return dao.delete(entity);
    }

    /**
     * 分页查询OrgInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 16:23:57 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(OrgInfo entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<OrgInfo> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 组织机构信息
	 *@author   ysh
	 *@param orgId 主键id
	 *@date  2018-11-13 16:23:57
	 *@updater  or other
	 *@return   OrgInfo
	 */ 
	 @Override
	 public OrgInfo getOrgInfoById(String orgId) {
		 return dao.getOrgInfoById(orgId);
	 }
}

	
