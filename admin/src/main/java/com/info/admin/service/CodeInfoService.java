package com.info.admin.service;

import com.info.admin.entity.CodeInfo;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-13 16:23:57 
 * @describe 二维码信息 Service
 */
public interface CodeInfoService {
    /**
     *添加CodeInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    int insert(CodeInfo entity);

    /**
     *修改CodeInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    int update(CodeInfo entity);

    /**
     *查询CodeInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return List<CodeInfo>
     */
    List<CodeInfo> query(CodeInfo entity);

    /**
     *删除CodeInfo对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    int delete(CodeInfo entity);

    /**
     * 分页查询CodeInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 16:23:57 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(CodeInfo entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 二维码信息
	 * @author   ysh
	 * @param codeId 主键id
	 * @date  2018-11-13 16:23:57
	 * @updater  or other
	 * @return   CodeInfo
	 */ 
	public CodeInfo getCodeInfoById(String codeId);
	
}

	
