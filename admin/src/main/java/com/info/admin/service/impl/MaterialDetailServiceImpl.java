package com.info.admin.service.impl;

import com.info.admin.dao.MaterialDetailDao;
import com.info.admin.entity.MaterialDetail;
import com.info.admin.service.MaterialDetailService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ysh
 * @date 2018-11-28 15:06:08
 * @describe 材料出入库 ServiceImpl
 */
@Service
public class MaterialDetailServiceImpl implements MaterialDetailService {

    @Autowired
    private MaterialDetailDao dao;

    /**
     *添加MaterialDetail对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-28 15:06:08 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(MaterialDetail entity){
        entity.setMaterialDetailId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改MaterialDetail对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-28 15:06:08 
     *@updater or other
     *@return int
     */
    @Override
    public int update(MaterialDetail entity){

        return dao.update(entity);
    }

    /**
     *查询MaterialDetail对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-28 15:06:08 
     *@updater or other
     *@return List<MaterialDetail>
     */
    @Override
    public List<MaterialDetail> query(MaterialDetail entity){
        return dao.query(entity);
    }

    /**
     *删除MaterialDetail对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-28 15:06:08 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(MaterialDetail entity){
       return dao.delete(entity);

    }

    /**
     * 分页查询MaterialDetail对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-28 15:06:08 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(MaterialDetail entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<MaterialDetail> result = dao.pageQuery(entity, offset, pageSize);

        return new PageUtil(pageSize, size, pageNum, result);
    }
    
    /**
	 * 根据 id获取 材料出入库
	 *@author   ysh
	 *@param materialDetailId 主键id
	 *@date  2018-11-28 15:06:08
	 *@updater  or other
	 *@return   MaterialDetail
	 */ 
	 @Override
	 public MaterialDetail getMaterialDetailById(String materialDetailId) {
		 return dao.getMaterialDetailById(materialDetailId);
	 }

    /**
     *  批量 MaterialDetail 入库管理
     *@author
     * @param
     * @param
     *@createTime
     *@updater  or other
     *@return   Integer
     */
    @Override
    public Integer batchMaterialDetail( String projectId, String[] num, String[] materialName,String outName){
        if(num == null || materialName == null ){
            return  0;
        }
        String outId =  com.info.admin.utils.UUIDUtils.getUUid();
        List<MaterialDetail> materialDetailList = new ArrayList<>();
        for (int i=0;i<num.length;i++) {
            BigDecimal nums = new BigDecimal(num[i]);
            MaterialDetail materialDetail = new MaterialDetail();
            materialDetail.setMaterialDetailId( com.info.admin.utils.UUIDUtils.getUUid());
            materialDetail.setMaterialType(0L);
            materialDetail.setNum(nums);
            materialDetail.setProjectId(projectId);
            materialDetail.setMaterialName(materialName[i]);
            materialDetail.setOutId(outId);
            materialDetail.setOutName(outName);
            materialDetailList.add(materialDetail);
        }
        return dao.batchMaterialDetail(materialDetailList);
    }

    /**
     * 分页查询MaterialDetail对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-28 15:06:08
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil outPageQuery(MaterialDetail entity, int pageNum, int pageSize){
        int size = dao.getOutPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<MaterialDetail> result = dao.outPageQuery(entity, offset, pageSize);

        return new PageUtil(pageSize, size, pageNum, result);
    }

    /**
     * 修改 检验状态
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-28 15:06:08
     * @updater or other
     * @return   int
     */
    @Override
    public  int updateTestMaterialDetail( MaterialDetail entity){
        return dao.updateTestMaterialDetail(entity);
    }

    /**
     * 查询MaterialDetail对象By outId
     * @author  ysh
     * @date  2018-11-28 15:06:08
     * @updater or other
     * @return   List<MaterialDetail>
     */
    @Override
    public   List<MaterialDetail> getMaterialByOutId( String outId){
        return dao.getMaterialByOutId(outId);
    }

    /**
     * 查询MaterialDetail对象By outId
     * @author  ysh
     * @date  2018-11-28 15:06:08
     * @updater or other
     * @return   List<MaterialDetail>
     */
    @Override
    public  MaterialDetail  getMaterialDetailByOutId( String outId){
        return dao.getMaterialDetailByOutId(outId);
    }
}

	
