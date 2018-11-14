package com.info.admin.service;

import com.info.admin.entity.ProblemLibrary;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:41 
 * @describe 问题库 Service
 */
public interface ProblemLibraryService {
    /**
     *添加ProblemLibrary对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int insert(ProblemLibrary entity);

    /**
     *修改ProblemLibrary对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int update(ProblemLibrary entity);

    /**
     *查询ProblemLibrary对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return List<ProblemLibrary>
     */
    List<ProblemLibrary> query(ProblemLibrary entity);

    /**
     *删除ProblemLibrary对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:41 
     *@updater or other
     *@return int
     */
    int delete(ProblemLibrary entity);

    /**
     * 分页查询ProblemLibrary对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(ProblemLibrary entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 问题库
	 * @author   ysh
	 * @param supplierId 主键id
	 * @date  2018-11-14 23:45:41
	 * @updater  or other
	 * @return   ProblemLibrary
	 */ 
	public ProblemLibrary getProblemLibraryById(String supplierId);
	
}

	
