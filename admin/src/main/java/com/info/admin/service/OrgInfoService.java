package com.info.admin.service;

import com.info.admin.entity.OrgInfo;
import com.info.admin.entity.OrgInfoTree;
import com.info.admin.utils.PageUtil;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42 
 * @describe 组织机构信息 Service
 */
public interface OrgInfoService {
    /**
     *添加OrgInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int insert(OrgInfo entity);

    /**
     *修改OrgInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int update(OrgInfo entity);

    /**
     *查询OrgInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<OrgInfo>
     */
    List<OrgInfo> query(OrgInfo entity);

    /**
     *删除OrgInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int delete(OrgInfo entity);

    /**
     * 分页查询OrgInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(OrgInfo entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 组织机构信息
	 * @author   ysh
	 * @param orgId 主键id
	 * @date  2018-11-14 23:45:42
	 * @updater  or other
	 * @return   OrgInfo
	 */ 
	OrgInfo getOrgInfoById(String orgId);
    /**
     * 查询组织机构信息List
     * @author
     * @param orgInfoTree
     * @date  2018-11-14 23:45:42
     * @updater  or other
     * @return   OrgInfo
     */
    List<OrgInfoTree>  getOrgInfo(OrgInfoTree orgInfoTree);
	
}

	
