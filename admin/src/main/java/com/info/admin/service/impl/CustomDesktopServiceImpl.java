package com.info.admin.service.impl;

import com.info.admin.dao.CustomDesktopDao;
import com.info.admin.entity.CustomDesktop;
import com.info.admin.service.CustomDesktopService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-13 16:23:57
 * @describe 自定义桌面 ServiceImpl
 */
@Service
public class CustomDesktopServiceImpl implements CustomDesktopService {

    @Autowired
    private CustomDesktopDao dao;

    /**
     *添加CustomDesktop对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(CustomDesktop entity){
        entity.setDesktopId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改CustomDesktop对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    @Override
    public int update(CustomDesktop entity){
        return dao.update(entity);
    }

    /**
     *查询CustomDesktop对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return List<CustomDesktop>
     */
    @Override
    public List<CustomDesktop> query(CustomDesktop entity){
        return dao.query(entity);
    }

    /**
     *删除CustomDesktop对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(CustomDesktop entity){
        return dao.delete(entity);
    }

    /**
     * 分页查询CustomDesktop对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 16:23:57 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(CustomDesktop entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<CustomDesktop> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 自定义桌面
	 *@author   ysh
	 *@param desktopId 主键id
	 *@date  2018-11-13 16:23:57
	 *@updater  or other
	 *@return   CustomDesktop
	 */ 
	 @Override
	 public CustomDesktop getCustomDesktopById(String desktopId) {
		 return dao.getCustomDesktopById(desktopId);
	 }
}

	
