package com.info.admin.service.impl;

import com.info.admin.dao.FlowDao;
import com.info.admin.entity.Flow;
import com.info.admin.service.FlowService;
import com.info.admin.utils.PageUtil;
import com.info.admin.vo.FlowVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-15 22:58:50
 * @describe 流程 ServiceImpl
 */
@Service
public class FlowServiceImpl implements FlowService {

    @Autowired
    private FlowDao dao;

    /**
     * 添加Flow对象
     *
     * @param entity 明细对象
     * @return int
     * @author ysh
     * @date 2018-11-15 22:58:50
     * @updater or other
     */
    @Override
    public int insert(Flow entity) {
        entity.setFlowId(com.info.admin.utils.UUIDUtils.getUUid());
        return dao.insert(entity);
    }

    /**
     * 修改Flow对象
     *
     * @param entity 明细对象
     * @return int
     * @author ysh
     * @date 2018-11-15 22:58:50
     * @updater or other
     */
    @Override
    public int update(Flow entity) {
        entity.setUpdateTime(new java.util.Date());

        return dao.update(entity);
    }

    /**
     * 查询Flow对象
     *
     * @param entity 明细对象
     * @return List<Flow>
     * @author ysh
     * @date 2018-11-15 22:58:50
     * @updater or other
     */
    @Override
    public List<Flow> query(Flow entity) {
        return dao.query(entity);
    }

    /**
     * 删除Flow对象
     *
     * @param entity 明细对象
     * @return int
     * @author ysh
     * @date 2018-11-15 22:58:50
     * @updater or other
     */
    @Override
    public int delete(Flow entity) {
        entity.setDeleteFlag(1L);
        return dao.update(entity);

    }

    /**
     * 分页查询Flow对象
     *
     * @param entity   对象
     * @param pageNum  页数
     * @param pageSize 大小
     * @return PageUtil
     * @author ysh
     * @date 2018-11-15 22:58:50
     * @updater or other
     */
    @Override
    public PageUtil pageQuery(Flow entity, int pageNum, int pageSize) {
        int size = dao.getPageCount(entity);
        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
        List<Flow> result = dao.pageQuery(entity, offset, pageSize);
        return new PageUtil(pageSize, size, pageNum, result);
    }

    /**
     * 查询Flow对象
     *
     * @param entity   对象
     * @return PageUtil
     * @author ysh
     * @date 2018-11-15 22:58:50
     * @updater or other
     */
    @Override
    public List<FlowVo>  queryFlow(Flow entity) {
        return dao.queryFlow(entity);
    }

    /**
     * 查询Flow对象
     * @param entity 对象
     * @author  ysh
     * @date  2018-11-14 23:45:42
     * @updater or other
     * @return   PageUtil
     */
    @Override
    public int getSubmitByDocUnid(Flow entity){
        entity =  getFlowById(entity.getFlowId());
        if(entity == null){
            return 0;
        }
        Flow flow = new Flow();
        flow.setLastNode(entity.getLastNode());
        flow.setIsDone(0L);
        return  dao.queryFlowCount(flow);
    }

    /**
     * 分页查询Flow对象
     *
     * @param entity   对象
     * @param pageNum  页数
     * @param pageSize 大小
     * @return PageUtil
     * @author ysh
     * @date 2018-11-15 22:58:50
     * @updater or other
     */
    @Override
    public PageUtil queryPageFlow(Flow entity, int pageNum, int pageSize) {
        int size = dao.queryFlowCount(entity);
        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
        List<FlowVo> result = dao.queryPageFlow(entity, offset, pageSize);
        return new PageUtil(pageSize, size, pageNum, result);
    }


    /**
     * 分页查询待办Flow对象
     *
     * @param entity   对象
     * @param pageNum  页数
     * @param pageSize 大小
     * @return PageUtil
     * @author ysh
     * @date 2018-11-15 22:58:50
     * @updater or other
     */
    @Override
    public PageUtil pageDbQuery(Flow entity, int pageNum, int pageSize) {
        int size = dao.getDbPageCount(entity);
        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
        List<Flow> result = dao.pageDbQuery(entity, offset, pageSize);
        return new PageUtil(pageSize, size, pageNum, result);
    }

    /**
     * 分页查询在办Flow对象
     *
     * @param entity   对象
     * @param pageNum  页数
     * @param pageSize 大小
     * @return PageUtil
     * @author ysh
     * @date 2018-11-15 22:58:50
     * @updater or other
     */
    @Override
    public PageUtil pageZbQuery(Flow entity, int pageNum, int pageSize) {
        int size = dao.getZbPageCount(entity);
        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
        List<Flow> result = dao.pageZbQuery(entity, offset, pageSize);
        return new PageUtil(pageSize, size, pageNum, result);
    }

    /**
     * 分页查询办结Flow对象
     *
     * @param entity   对象
     * @param pageNum  页数
     * @param pageSize 大小
     * @return PageUtil
     * @author ysh
     * @date 2018-11-15 22:58:50
     * @updater or other
     */
    @Override
    public PageUtil pageBjQuery(Flow entity, int pageNum, int pageSize) {
        int size = dao.getBjPageCount(entity);
        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
        List<Flow> result = dao.pageBjQuery(entity, offset, pageSize);
        return new PageUtil(pageSize, size, pageNum, result);
    }

    /**
     * 根据 id获取 流程
     *
     * @param flowId 主键id
     * @return Flow
     * @author ysh
     * @date 2018-11-15 22:58:50
     * @updater or other
     */
    @Override
    public Flow getFlowById(String flowId) {
        return dao.getFlowById(flowId);
    }

    /**
     * 根据 id获取 流程
     *
     * @param flowId 主键id
     * @return Flow
     * @author ysh
     * @date 2018-11-15 22:58:50
     * @updater or other
     */
    @Override
    public FlowVo getFlowByIdVo(String flowId) {
        return dao.getFlowByIdVo(flowId);
    }

    /**
     * 初次发起流程(应创建至少2条数据)
     *
     * @param list 流程列表
     * @return Flow
     * @author ljuenan
     * @date 2018-11-14 23:45:42
     * @updater or other
     */
    @Override
    public int startFlow(List<Flow> list) {
        return dao.batchFlow(list);
    }

    /**
     * 新增多分支流程
     *
     * @param list 流程列表
     * @return Flow
     * @author ljuenan
     * @date 2018-11-14 23:45:42
     * @updater or other
     */
    @Override
    public int batchFlow(List<Flow> list) {
        return dao.batchFlow(list);
    }

    @Override
    public List<Flow> getFlowByDocUnid(Flow entity) {
        return dao.getFlowByDocUnid(entity);
    }

    /**
     * 设置id
     *
     * @param list
     */
    @Override
    public void setId(List<Flow> list) {
        String uuid = "";
        for (Flow flow : list) {
            if (StringUtils.isBlank(flow.getFlowId())) {
                flow.setLastNode(uuid);
                uuid = com.info.admin.utils.UUIDUtils.getUUid();
                flow.setFlowId(uuid);

            }
        }
    }
}

	
