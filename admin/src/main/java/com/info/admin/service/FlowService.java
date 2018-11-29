package com.info.admin.service;

import com.info.admin.entity.Flow;
import com.info.admin.utils.PageUtil;
import com.info.admin.vo.FlowVo;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-14 23:45:42 
 * @describe 流程 Service
 */
public interface FlowService {
    /**
     *添加Flow对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int insert(Flow entity);

    /**
     *修改Flow对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return int
     */
    int update(Flow entity);

    /**
     *查询Flow对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@updater or other
     *@return List<Flow>
     */
    List<Flow> query(Flow entity);

    /**
     *删除Flow对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-14 23:45:42 
     *@date  2018-11-14 23:45:42
     *@updater or other
     *@return int
     */
    int delete(Flow entity);

    /**
     * 分页查询Flow对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(Flow entity, int pageNum, int pageSize);

    /**
     * 查询Flow对象
     * @param entity 对象
     * @author  ysh
     * @date  2018-11-14 23:45:42
     * @updater or other
     * @return   PageUtil
     */
    List<FlowVo> queryFlow(Flow entity);

    /**
     * 查询Flow对象
     * @param entity 对象
     * @author  ysh
     * @date  2018-11-14 23:45:42
     * @updater or other
     * @return   PageUtil
     */
    int getSubmitByDocUnid(Flow entity);

    /**
     * 分页查询Flow对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42
     * @updater or other
     * @return   PageUtil
     */
    PageUtil queryPageFlow(Flow entity, int pageNum, int pageSize);

    /**
     * 分页查询待办Flow对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageDbQuery(Flow entity, int pageNum, int pageSize);

    /**
     * 分页查询预警待办Flow对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageYjDbQuery(Flow entity, int pageNum, int pageSize);

    /**
     * 分页查询在办Flow对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageZbQuery(Flow entity, int pageNum, int pageSize);

    /**
     * 分页查询办结Flow对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:42
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageBjQuery(Flow entity, int pageNum, int pageSize);
    /**
	 * 根据 id获取 流程
	 * @author   ysh
	 * @param flowId 主键id
	 * @date  2018-11-14 23:45:42
	 * @updater  or other
	 * @return   Flow
	 */ 
	 Flow getFlowById(String flowId);

    /**
     * 根据 id获取 流程
     *@author   ysh
     *@param flowId 主键id
     *@date  2018-11-14 23:45:41
     *@updater  or other
     *@return   Flow
     */
    FlowVo getFlowByIdVo(String flowId);

    /**
     * 初次发起流程(应创建至少2条数据)
     * @author   ljuenan
     * @param list 流程列表
     * @date  2018-11-14 23:45:42
     * @updater  or other
     * @return   Flow
     */
    int startFlow(List<Flow> list);

    /**
     * 新增多分支流程
     * @author   ljuenan
     * @param list 流程列表
     * @date  2018-11-14 23:45:42
     * @updater  or other
     * @return   Flow
     */
    int batchFlow(List<Flow> list);

    List<Flow> getFlowByDocUnid(Flow entity);

    void setId(List<Flow> list);
}

	
