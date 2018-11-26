package com.info.admin.service.impl;

import com.info.admin.dao.StaffInfoDao;
import com.info.admin.entity.StaffInfo;
import com.info.admin.service.StaffInfoService;
import com.info.admin.utils.PageUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ysh
 * @date 2018-11-15 22:58:50
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
     *@date  2018-11-15 22:58:50 
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
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int update(StaffInfo entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询StaffInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
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
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(StaffInfo entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询StaffInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:50 
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
	 *@date  2018-11-15 22:58:50
	 *@updater  or other
	 *@return   StaffInfo
	 */ 
	 @Override
	 public StaffInfo getStaffInfoById(String staffId) {
		 return dao.getStaffInfoById(staffId);
	 }

    /**
     * 根据 流程id获取 员工信息
     *@author   ysh
     *@param flowId 主键id
     *@date  2018-11-14 23:45:41
     *@updater  or other
     *@return   StaffInfo
     */
    @Override
    public StaffInfo getStaffInfoByFlowId(String flowId){
        return dao.getStaffInfoByFlowId(flowId);
    }

    /**
     * 返回树形结构json数据
     * @param list 数据，因读大于写
     * @return JSONArray
     */
    @Override
    public JSONArray getTreeJson(CopyOnWriteArrayList<StaffInfo> list) {
        JSONArray all = new JSONArray();
        for (StaffInfo staffInfo : list){
            JSONObject main = new JSONObject();
            main.put("id",staffInfo.getStaffId());
            main.put("text",staffInfo.getName());
            main.put("pId",staffInfo.getOrgId());
            all.add(main);
        }
        return all;
    }
}

	
