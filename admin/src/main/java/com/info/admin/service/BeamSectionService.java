package com.info.admin.service;

import com.info.admin.entity.BeamSection;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:41 
 * @describe 梁段信息 Service
 */
public interface BeamSectionService {
    /**
     *添加BeamSection对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int insert(BeamSection entity);

    /**
     *修改BeamSection对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int update(BeamSection entity);

    /**
     *查询BeamSection对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return List<BeamSection>
     */
    List<BeamSection> query(BeamSection entity);

    /**
     *删除BeamSection对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int delete(BeamSection entity);

    /**
     * 分页查询BeamSection对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(BeamSection entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 梁段信息
	 * @author   ysh
	 * @param sectionId 主键id
	 * @date  2018-11-14 23:45:41
	 * @updater  or other
	 * @return   BeamSection
	 */ 
	public BeamSection getBeamSectionById(String sectionId);
	
}

	
