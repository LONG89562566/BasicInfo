package com.info.admin.service.impl;

import com.info.admin.dao.OrgInfoDao;
import com.info.admin.entity.OrgInfo;
import com.info.admin.entity.OrgInfoTree;
import com.info.admin.service.OrgInfoService;
import com.info.admin.utils.PageUtil;
import com.info.admin.vo.OrgInfoVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-15 22:58:50
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
     *@date  2018-11-15 22:58:50 
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
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int update(OrgInfo entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询OrgInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
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
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(OrgInfo entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询OrgInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:50 
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
	 *@date  2018-11-15 22:58:50
	 *@updater  or other
	 *@return   OrgInfo
	 */ 
	 @Override
	 public OrgInfo getOrgInfoById(String orgId) {
		 return dao.getOrgInfoById(orgId);
	 }

    /**
     * 查询组织机构信息List
     * @author
     * @param
     * @date  2018-11-14 23:45:42
     * @updater  or other
     * @return   OrgInfo
     */
    @Override
    public List<OrgInfoTree>  getOrgInfo(OrgInfoTree orgInfoTree){
        return dao.getOrgInfo(orgInfoTree);
    };

    /**
     * 组织结构名称树
     */
    @Override
    public JSONArray orgInfoTree(List<OrgInfoTree> orgInfoList, int parentId) {
        JSONArray all = new JSONArray();
        for (OrgInfoTree orgInfoTree : orgInfoList) {
            JSONObject main = JSONObject.fromObject(orgInfoTree);
                all.add(main);
            }
        return all;
    }

}

	
