package com.info.admin.service;

import com.info.admin.entity.MaterialDetail;
import com.info.admin.utils.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-28 15:06:08 
 * @describe 材料出入库 Service
 */
public interface MaterialDetailService {
    /**
     *添加MaterialDetail对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-28 15:06:08 
     *@updater or other
     *@return int
     */
    int insert(MaterialDetail entity);

    /**
     *修改MaterialDetail对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-28 15:06:08 
     *@updater or other
     *@return int
     */
    int update(MaterialDetail entity);

    /**
     *查询MaterialDetail对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-28 15:06:08 
     *@updater or other
     *@return List<MaterialDetail>
     */
    List<MaterialDetail> query(MaterialDetail entity);

    /**
     *删除MaterialDetail对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-28 15:06:08 
     *@updater or other
     *@return int
     */
    int delete(MaterialDetail entity);

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
    PageUtil pageQuery(MaterialDetail entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 材料出入库
	 * @author   ysh
	 * @param materialDetailId 主键id
	 * @date  2018-11-28 15:06:08
	 * @updater  or other
	 * @return   MaterialDetail
	 */ 
	public MaterialDetail getMaterialDetailById(String materialDetailId);

    /**
     *  batchMaterialDetail批量入库
     *@author
     * @param
     * @param
     * @param  num 材料数量
     * @param  materialName 材料名字
     * @param
     *@createTime   2
     *@updater  or other
     *@return   Integer
     */
    public Integer batchMaterialDetail(String projectId ,String[] num, String[] materialName,String outName);


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
    PageUtil outPageQuery(MaterialDetail entity, int pageNum, int pageSize);

    /**
     * 修改 检验状态
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-28 15:06:08
     * @updater or other
     * @return   int
     */
    int updateTestMaterialDetail( MaterialDetail entity);

    /**
     * 查询MaterialDetail对象By outId
     * @author  ysh
     * @date  2018-11-28 15:06:08
     * @updater or other
     * @return   List<MaterialDetail>
     */
    List<MaterialDetail> getMaterialByOutId( String outId);
    /**
     * 查询MaterialDetail对象By outId
     * @author  ysh
     * @date  2018-11-28 15:06:08
     * @updater or other
     * @return   List<MaterialDetail>
     */
    MaterialDetail  getMaterialDetailByOutId( String outId);
}

	
