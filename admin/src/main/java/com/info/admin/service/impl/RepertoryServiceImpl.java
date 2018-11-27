package com.info.admin.service.impl;

import com.info.admin.dao.RepertoryDao;
import com.info.admin.entity.Repertory;
import com.info.admin.service.RepertoryService;
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
 * @describe 仓库 ServiceImpl
 */
@Service
public class RepertoryServiceImpl implements RepertoryService {

    @Autowired
    private RepertoryDao dao;

    /**
     *添加Repertory对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(Repertory entity){
        entity.setRepertoryId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改Repertory对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int update(Repertory entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询Repertory对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return List<Repertory>
     */
    @Override
    public List<Repertory> query(Repertory entity){
        return dao.query(entity);
    }

    /**
     *删除Repertory对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(Repertory entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询Repertory对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:50 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(Repertory entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<Repertory> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 仓库
	 *@author   ysh
	 *@param supplierId 主键id
	 *@date  2018-11-15 22:58:50
	 *@updater  or other
	 *@return   Repertory
	 */ 
	 @Override
	 public Repertory getRepertoryById(String supplierId) {
		 return dao.getRepertoryById(supplierId);
	 }

    /**
     *查询Repertory对象
     *@param  entity 对象
     *@author
     *@date  2018-11-14 23:45:42
     *@updater or other
     *@return List<Repertory>
     */
    @Override
    public  List<Repertory> queryRepertoryRepertoryTree(Repertory entity){
        return dao.queryRepertoryRepertoryTree(entity);
    }
    /**
     * 返回树形结构json数据
     * @param repertoryList 数据，因读大于写
     * @return JSONArray
     */
    @Override
    public JSONArray getRepertoryRepertoryTreeJson(CopyOnWriteArrayList<Repertory> repertoryList) {
        JSONArray all = new JSONArray();
        for (Repertory repertory : repertoryList){
            JSONObject main = new JSONObject();
            if(repertory.getColumnName() .equals("delete_flag") || repertory.getColumnName() .equals("repertory_id") ||repertory.getColumnName() .equals("update_time")){
            }
            else {
                main.put("id", repertory.getColumnName());
                main.put("text", repertory.getColumnComment());
                all.add(main);
            }

        }
        return all;
    }
}

	
