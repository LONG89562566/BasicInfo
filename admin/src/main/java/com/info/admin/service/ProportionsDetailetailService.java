package com.info.admin.service;

import com.info.admin.entity.ProportionsDetailetail;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42 
 * @describe 配合比详情 Service
 */
public interface ProportionsDetailetailService {
    /**
     *添加ProportionsDetailetail对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int insert(ProportionsDetailetail entity);

    /**
     *修改ProportionsDetailetail对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int update(ProportionsDetailetail entity);

    /**
     *查询ProportionsDetailetail对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<ProportionsDetailetail>
     */
    List<ProportionsDetailetail> query(ProportionsDetailetail entity);

    /**
     *删除ProportionsDetailetail对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int delete(ProportionsDetailetail entity);

    /**
     * 分页查询ProportionsDetailetail对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(ProportionsDetailetail entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 配合比详情
	 * @author   ysh
	 * @param detailId 主键id
	 * @date  2018-11-14 23:45:42
	 * @updater  or other
	 * @return   ProportionsDetailetail
	 */ 
	public ProportionsDetailetail getProportionsDetailetailById(String detailId);

    /**
     *  batchProportionsMaterial批量入库
     *@author
     * @param
     * @param  detailId 详情ID
     * @param  materialNum 材料数量
     * @param  materialId 材料ID
     * @param
     *@createTime   2
     *@updater  or other
     *@return   Integer
     */
    public Integer batchProportionsMaterial(String detailId, String[] materialNum, String[] materialId);
	
}

	
