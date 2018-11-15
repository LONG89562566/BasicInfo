package com.info.admin.service.impl;

import com.info.admin.dao.BeamSectionDao;
import com.info.admin.entity.BeamSection;
import com.info.admin.service.BeamSectionService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-15 22:58:49
 * @describe 梁段信息 ServiceImpl
 */
@Service
public class BeamSectionServiceImpl implements BeamSectionService {

    @Autowired
    private BeamSectionDao dao;

    /**
     *添加BeamSection对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:49 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(BeamSection entity){
        entity.setSectionId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改BeamSection对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:49 
     *@updater or other
     *@return int
     */
    @Override
    public int update(BeamSection entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询BeamSection对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:49 
     *@updater or other
     *@return List<BeamSection>
     */
    @Override
    public List<BeamSection> query(BeamSection entity){
        return dao.query(entity);
    }

    /**
     *删除BeamSection对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:49 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(BeamSection entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询BeamSection对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:49 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(BeamSection entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<BeamSection> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 梁段信息
	 *@author   ysh
	 *@param sectionId 主键id
	 *@date  2018-11-15 22:58:49
	 *@updater  or other
	 *@return   BeamSection
	 */ 
	 @Override
	 public BeamSection getBeamSectionById(String sectionId) {
		 return dao.getBeamSectionById(sectionId);
	 }
}

	
