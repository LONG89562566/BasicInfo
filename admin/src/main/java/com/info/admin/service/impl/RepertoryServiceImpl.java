package com.info.admin.service.impl;

import com.info.admin.dao.RepertoryDao;
import com.info.admin.dao.WarningInfoDao;
import com.info.admin.entity.MaterialDetail;
import com.info.admin.entity.Repertory;
import com.info.admin.entity.WarningInfo;
import com.info.admin.service.RepertoryService;
import com.info.admin.service.WarningInfoService;
import com.info.admin.utils.ArrayListUtil;
import com.info.admin.utils.PageUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    @Autowired
    private WarningInfoDao warningInfoDao;

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
     *查询Repertory对象预警
     *@param  staffId 登录人id
     *@author
     *@date  2018-11-14 23:45:42
     *@updater or other
     *@return List<Repertory>
     */
    @Override
    public  List<Repertory> queryRepertoryYj(String staffId){
        WarningInfo warningInfo = new WarningInfo();
        warningInfo.setReceiveUser(staffId);
        warningInfo.setOptions(2L);
        List<WarningInfo> warningInfos =  warningInfoDao.query(warningInfo);
        if(warningInfos == null || warningInfos.size() == 0){
            return new ArrayList<>();
        }
        List<Repertory> repertories = dao.query(new Repertory());
        if(repertories == null || repertories.size() == 0){
            return new ArrayList<>();
        }
        List<Repertory> repertoryList = new ArrayList<>();
        for (Repertory repertory : repertories){
            for (WarningInfo warningInfo1 : warningInfos){
                if(repertory.getRepertoryId().equals(warningInfo1.getTrue_val())){
                    if(warningInfo1.getCheckCondition()==1){
                        if(repertory.getNum().doubleValue() > Double.parseDouble(warningInfo1.getWarn_val())){
                            repertory.setCheckCondition("大于");
                            repertory.setWarnVal(warningInfo1.getWarn_val());
                            repertoryList.add(repertory);
                            break;
                        }
//                        return"大";
                    }else if(warningInfo1.getCheckCondition()==2){
                        if(repertory.getNum().doubleValue() < Double.parseDouble(warningInfo1.getWarn_val())){
                            repertory.setCheckCondition("小于");
                            repertory.setWarnVal(warningInfo1.getWarn_val());
                            repertoryList.add(repertory);
                            break;
                        }
//                        return"小";
                    }else if(warningInfo1.getCheckCondition()==3){
                        if(repertory.getNum().doubleValue() == Double.parseDouble(warningInfo1.getWarn_val())){
                            repertory.setCheckCondition("等于");
                            repertory.setWarnVal(warningInfo1.getWarn_val());
                            repertoryList.add(repertory);
                            break;
                        }
//                        return"等";
                    }else  if(warningInfo1.getCheckCondition()==4){
                        if(repertory.getNum().doubleValue() <= Double.parseDouble(warningInfo1.getWarn_val())){
                            repertory.setCheckCondition("不大于");
                            repertory.setWarnVal(warningInfo1.getWarn_val());
                            repertoryList.add(repertory);
                            break;
                        }
//                        return"不大";
                    }else if(warningInfo1.getCheckCondition()==5){
                        if(repertory.getNum().doubleValue() >= Double.parseDouble(warningInfo1.getWarn_val())){
                            repertory.setCheckCondition("不小于");
                            repertory.setWarnVal(warningInfo1.getWarn_val());
                            repertoryList.add(repertory);
                            break;
                        }
//                        return"不小";
                    }else if(warningInfo1.getCheckCondition()==6) {
                        if(repertory.getNum().doubleValue() != Double.parseDouble(warningInfo1.getWarn_val())){
                            repertory.setCheckCondition("不等于");
                            repertory.setWarnVal(warningInfo1.getWarn_val());
                            repertoryList.add(repertory);
                            break;
                        }
//                        return "不等于";
                    }
                }
            }
        }
        return repertoryList;
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

    /**
     * 查询Repertory记录数
     * @author
     * @date  2018-11-14 23:45:41
     * @updater or other
     * @return   int
     */
    @Override
    public Repertory getRepertoryPage( String materialName, String projectId){
        return dao.getRepertoryPage(materialName,projectId);
    }
    /**
     * 入库
     * @author
     * @date  2018-11-14 23:45:41
     * @updater or other
     * @return   int
     */
    @Override
    public int updateNum(BigDecimal num , String repertoryId){
        return dao.updateNum(num,repertoryId);
    }


    /**
     * 返回树形结构json数据
     * @param list 数据，因读大于写
     * @return JSONArray
     */
    @Override
    public JSONArray getRepertoryTreeJson(CopyOnWriteArrayList<Repertory> list) {
        JSONArray all = new JSONArray();
        for (Repertory repertory : list){
            JSONObject main = new JSONObject();
            main.put("id",repertory.getRepertoryId());
            main.put("text",repertory.getMaterialName());
            main.put("num",repertory.getNum());
            all.add(main);
        }
        return all;
    }

    /**
     * 批量出库
     * @author
     * @date  2018-11-14 23:45:41
     * @updater or other
     * @return   int
     */
    @Override
    public int outTestMaterial(List<MaterialDetail> materialDetailList){
        return dao.outTestMaterial(materialDetailList);
    }

}

	
