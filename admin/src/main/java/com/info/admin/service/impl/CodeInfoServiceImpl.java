package com.info.admin.service.impl;

import com.info.admin.dao.CodeInfoDao;
import com.info.admin.entity.CodeInfo;
import com.info.admin.service.CodeInfoService;
import com.info.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-15 22:58:50
 * @describe 二维码信息 ServiceImpl
 */
@Service
public class CodeInfoServiceImpl implements CodeInfoService {

    @Autowired
    private CodeInfoDao dao;

    /**
     *添加CodeInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int insert(CodeInfo entity){
        entity.setCodeId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     *修改CodeInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int update(CodeInfo entity){
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     *查询CodeInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return List<CodeInfo>
     */
    @Override
    public List<CodeInfo> query(CodeInfo entity){
        return dao.query(entity);
    }

    /**
     *删除CodeInfo对象
     *@param  entity 明细对象
     *@author  ysh
     *@date  2018-11-15 22:58:50 
     *@updater or other
     *@return int
     */
    @Override
    public int delete(CodeInfo entity){
      entity.setDeleteFlag(1L);
         return dao.update(entity);

    }

    /**
     * 分页查询CodeInfo对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-15 22:58:50 
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public PageUtil pageQuery(CodeInfo entity, int pageNum, int pageSize){
        int size = dao.getPageCount(entity);

        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

        List<CodeInfo> result = dao.pageQuery(entity, offset, pageSize);

        PageUtil paginator = new PageUtil(pageSize, size, pageNum);

        paginator.setObject(result);

        return paginator;
    }
    
    /**
	 * 根据 id获取 二维码信息
	 *@author   ysh
	 *@param codeId 主键id
	 *@date  2018-11-15 22:58:50
	 *@updater  or other
	 *@return   CodeInfo
	 */ 
	 @Override
	 public CodeInfo getCodeInfoById(String codeId) {
		 return dao.getCodeInfoById(codeId);
	 }
}

	
