package com.info.admin.service.impl;

import com.info.admin.dao.MaterialDao;
import com.info.admin.entity.Material;
import com.info.admin.service.MaterialService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-13 16:23:57
 * @describe 材料 ServiceImpl
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialDao dao;

    /**
     *添加Material对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(Material entity){
        entity.setMaterialId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改Material对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    @Override
    public int update(Material entity){
        return dao.update(entity);
    }

    /**
     *查询Material对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return List<Material>
     */
    @Override
    public List<Material> query(Material entity){
        return dao.query(entity);
    }

    /**
     *删除Material对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(Material entity){
        return dao.delete(entity);
    }

    /**
     * 分页查询Material对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 16:23:57 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(Material entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<Material> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 材料
	 *@author   ysh
	 *@param materialId 主键id
	 *@date  2018-11-13 16:23:57
	 *@updater  or other
	 *@return   Material
	 */ 
	 @Override
	 public Material getMaterialById(String materialId) {
		 return dao.getMaterialById(materialId);
	 }
}

	
