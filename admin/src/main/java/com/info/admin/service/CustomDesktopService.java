package com.info.admin.service;

import com.info.admin.entity.CustomDesktop;
import com.info.admin.utils.PageUtil;
import com.info.admin.vo.CustomDesktopVo;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-13 16:23:57
 * @describe 自定义桌面 Service
 */
public interface CustomDesktopService {
    /**
     * 添加CustomDesktop对象
     *
     * @param entity 对象
     * @return int
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    int insert(CustomDesktop entity);

    /**
     * 批量添加CustomDesktop对象
     *
     * @param userId  用户id
     * @param menuIds 菜单数组
     * @return int
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    int insertBatchDesktop(Long userId, String[] menuIds,
                           String[] menuNames, String[] widths, String[] heights, String[] seqs);

    /**
     * 修改CustomDesktop对象
     *
     * @param entity 对象
     * @return int
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    int update(CustomDesktop entity);

    /**
     * 查询CustomDesktop对象
     *
     * @param entity 对象
     * @return List<CustomDesktop>
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    List<CustomDesktop> query(CustomDesktop entity);

    /**
     * 删除CustomDesktop对象
     *
     * @param entity 对象
     * @return int
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    int delete(CustomDesktop entity);

    /**
     * 分页查询CustomDesktop对象
     *
     * @param entity   对象
     * @param pageNum  页数
     * @param pageSize 大小
     * @return PageUtil
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    PageUtil pageQuery(CustomDesktop entity, int pageNum, int pageSize);

    /**
     * 分页查询CustomDesktop对象
     *
     * @param entity   对象
     * @param pageNum  页数
     * @param pageSize 大小
     * @return PageUtil
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    List<CustomDesktopVo> myDesktop(Long userId);

    /**
     * 根据 id获取 自定义桌面
     *
     * @param desktopId 主键id
     * @return CustomDesktop
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    public CustomDesktop getCustomDesktopById(String desktopId);

}

	
