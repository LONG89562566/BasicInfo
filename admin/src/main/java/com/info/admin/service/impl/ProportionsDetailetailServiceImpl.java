package com.info.admin.service.impl;

import com.info.admin.dao.ProportionsDetailetailDao;
import com.info.admin.entity.ProportionsDetailetail;
import com.info.admin.entity.ProportionsMaterial;
import com.info.admin.service.ProportionsDetailetailService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ysh
 * @date 2018-11-15 22:58:50
 * @describe 配合比详情 ServiceImpl
 */
@Service
public class ProportionsDetailetailServiceImpl implements ProportionsDetailetailService {

    @Autowired
    private ProportionsDetailetailDao dao;

    /**
     *添加ProportionsDetailetail对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(ProportionsDetailetail entity){
        return dao.insert(entity);
    }

    /**
     *修改ProportionsDetailetail对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int update(ProportionsDetailetail entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询ProportionsDetailetail对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return List<ProportionsDetailetail>
     */
    @Override
    public List<ProportionsDetailetail> query(ProportionsDetailetail entity){
        return dao.query(entity);
    }

    /**
     *删除ProportionsDetailetail对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(ProportionsDetailetail entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询ProportionsDetailetail对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:50 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(ProportionsDetailetail entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<ProportionsDetailetail> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 配合比详情
	 *@author   ysh
	 *@param detailId 主键id
	 *@date  2018-11-15 22:58:50
	 *@updater  or other
	 *@return   ProportionsDetailetail
	 */ 
	 @Override
	 public ProportionsDetailetail getProportionsDetailetailById(String detailId) {
		 return dao.getProportionsDetailetailById(detailId);
	 }

    /**
     *  批量ProportionsMaterial入库管理
     *@author
     * @param
     * @param
     *@createTime
     *@updater  or other
     *@return   Integer
     */
    @Override
    public Integer batchProportionsMaterial(  String detailId, String[] materialNum, String[] materialId){
        if(materialNum == null || materialId == null ){
            return  0;
        }
        List<ProportionsMaterial> proportionsMaterialsList = new ArrayList<>();
        for (int i=0;i<materialNum.length;i++) {
            ProportionsMaterial proportionsMaterials = new ProportionsMaterial();
            proportionsMaterials.setProportionsMaterialId(com.info.admin.utils.UUIDUtils.getUUid());
            proportionsMaterials.setDetailId(detailId);
            proportionsMaterials.setMaterialNum(Long.parseLong(materialNum[i].trim()));
            proportionsMaterials.setMaterialId(materialId[i]);
            proportionsMaterialsList.add(proportionsMaterials);
        }
        return dao.batchProportionsMaterial(proportionsMaterialsList);
    }


    /**
     * 根据 id获取 配合比材料详情
     *@author
     *@param
     *@date  2018-11-14 23:45:41
     *@updater  or other
     *@return   ProportionsDetailetail
     */
    @Override
    public List<ProportionsMaterial> getProportionsMaterialById(String detailId){
        return dao.getProportionsMaterialById(detailId);
    };


    /**
     *修改ProportionsDetailetail对象
     *@param  proportionsMaterial 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41
     *@updater or other
     *@return int
     */
    @Override
    public int updateProportionsMaterial(ProportionsMaterial proportionsMaterial){

        proportionsMaterial.setUpdateTime(new java.util.Date());
        return dao.updateProportionsMaterial(proportionsMaterial);
    };
}

	
