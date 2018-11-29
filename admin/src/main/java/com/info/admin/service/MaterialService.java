package com.info.admin.service;

import com.info.admin.entity.Material;
import com.info.admin.entity.MaterialTree;
import com.info.admin.utils.PageUtil;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42 
 * @describe 材料 Service
 */
public interface MaterialService {
    /**
     *添加Material对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int insert(Material entity);

    /**
     *修改Material对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int update(Material entity);

    /**
     *查询Material对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<Material>
     */
    List<Material> query(Material entity);

    /**
     *删除Material对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int delete(Material entity);

    /**
     * 分页查询Material对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(Material entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 材料
	 * @author   ysh
	 * @param materialId 主键id
	 * @date  2018-11-14 23:45:42
	 * @updater  or other
	 * @return   Material
	 */ 
	public Material getMaterialById(String materialId);

    /**
     *  材料信息List
     * @author
     * @param
     * @date  2018-11-14 23:45:42
     * @updater  or other
     * @return   OrgInfo
     */
    public List<MaterialTree>  getMaterialTree(MaterialTree materialTree,String projectId);
    /**
     *梁场树
     *@param
     *@param  parentId 父节点
     *@return JSONArray
     *@author
     *@createTime
     */
    public JSONArray materialTree(List<MaterialTree> materialTreeTreeList, int parentId);

    /**
     *  材料信息List
     * @author
     * @param
     * @date  2018-11-14 23:45:42
     * @updater  or other
     * @return   OrgInfo
     */
    public List<Material>  getMaterial( String projectId);
	
}

	
