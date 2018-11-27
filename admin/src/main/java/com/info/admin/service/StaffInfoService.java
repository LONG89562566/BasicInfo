package com.info.admin.service;

import com.info.admin.entity.StaffInfo;
import com.info.admin.utils.PageUtil;
import net.sf.json.JSONArray;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42 
 * @describe 员工信息 Service
 */
public interface StaffInfoService {
    /**
     *添加StaffInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int insert(StaffInfo entity);

    /**
     *修改StaffInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int update(StaffInfo entity);

    /**
     *查询StaffInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<StaffInfo>
     */
    List<StaffInfo> query(StaffInfo entity);

    /**
     *删除StaffInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int delete(StaffInfo entity);

    /**
     * 分页查询StaffInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(StaffInfo entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 员工信息
	 * @author   ysh
	 * @param staffId 主键id
	 * @date  2018-11-14 23:45:42
	 * @updater  or other
	 * @return   StaffInfo
	 */ 
	StaffInfo getStaffInfoById(String staffId);

    /**
     * 返回树形结构json数据
     * @param list 数据，因读大于写
     * @return JSONArray
     */
    JSONArray getTreeJson(CopyOnWriteArrayList<StaffInfo> list);

    /**
     *查询StaffInfo对象
     *@param  entity 对象
     *@author
     *@date  2018-11-14 23:45:42
     *@updater or other
     *@return List<StaffInfo>
     */
    List<StaffInfo> queryStaffInfoRepertoryTree(StaffInfo entity);

    /**
     * 返回人员报表树形结构json数据
     * @param StaffInfoList 数据，因读大于写
     * @return JSONArray
     */
    JSONArray getStaffInfoRepertoryTreeJson(CopyOnWriteArrayList<StaffInfo> StaffInfoList);
	
}

	
