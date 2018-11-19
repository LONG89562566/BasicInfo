package com.info.admin.service.impl;

import com.info.admin.dao.ReleaseInfoLogDao;
import com.info.admin.entity.ReleaseInfoLog;
import com.info.admin.service.ReleaseInfoLogService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-18 19:39:48
 * @describe 信息发布日志 ServiceImpl
 */
@Service
public class ReleaseInfoLogServiceImpl implements ReleaseInfoLogService {

    @Autowired
    private ReleaseInfoLogDao dao;

    /**
     *添加ReleaseInfoLog对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-18 19:39:48 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(ReleaseInfoLog entity){

        return dao.insert(entity);
    }

    /**
     *修改ReleaseInfoLog对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-18 19:39:48 
     *@updater or other
     *@return int
     */
    @Override
    public int update(ReleaseInfoLog entity){
        return dao.update(entity);
    }

    /**
     *查询ReleaseInfoLog对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-18 19:39:48 
     *@updater or other
     *@return List<ReleaseInfoLog>
     */
    @Override
    public List<ReleaseInfoLog> query(ReleaseInfoLog entity){
        return dao.query(entity);
    }

    /**
     *删除ReleaseInfoLog对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-18 19:39:48 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(ReleaseInfoLog entity){
         return dao.delete(entity);
    }

    /**
     * 分页查询ReleaseInfoLog对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-18 19:39:48 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(ReleaseInfoLog entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<ReleaseInfoLog> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 信息发布日志
	 *@author   ysh
	 *@param releaseInfoLogId 主键id
	 *@date  2018-11-18 19:39:48
	 *@updater  or other
	 *@return   ReleaseInfoLog
	 */ 
	 @Override
	 public ReleaseInfoLog getReleaseInfoLogById(Long releaseInfoLogId) {
		 return dao.getReleaseInfoLogById(releaseInfoLogId);
	 }
}

	
