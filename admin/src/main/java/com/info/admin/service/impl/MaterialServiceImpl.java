package com.info.admin.service.impl;

import com.info.admin.dao.MaterialDao;
import com.info.admin.entity.Material;
import com.info.admin.entity.MaterialTree;
import com.info.admin.service.MaterialService;
import com.info.admin.utils.PageUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-15 22:58:50
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
     *@date  2018-11-15 22:58:50 
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
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int update(Material entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询Material对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
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
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(Material entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询Material对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:50 
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
	 *@date  2018-11-15 22:58:50
	 *@updater  or other
	 *@return   Material
	 */ 
	 @Override
	 public Material getMaterialById(String materialId) {
		 return dao.getMaterialById(materialId);
	 }

    /**
     *  材料信息List
     * @author
     * @param
     * @date  2018-11-14 23:45:42
     * @updater  or other
     * @return   OrgInfo
     */
    @Override
    public List<MaterialTree>  getMaterialTree(MaterialTree materialTree, String projectId){
        return dao.getMaterialTree(materialTree,projectId);
    }
    /**
     * 材料名称树
     */
    @Override
    public JSONArray materialTree(List<MaterialTree> materialTreeList, int parentId) {
        JSONArray all = new JSONArray();
        for (MaterialTree materialTree : materialTreeList) {
            JSONObject main = JSONObject.fromObject(materialTree);
            all.add(main);
        }
        return all;
    }

    /**
     *  材料信息List
     * @author
     * @param
     * @date  2018-11-14 23:45:42
     * @updater  or other
     * @return   OrgInfo
     */
    @Override
    public List<Material>  getMaterial( String projectId){
        return dao.getMaterial(projectId);
    }
}

	
