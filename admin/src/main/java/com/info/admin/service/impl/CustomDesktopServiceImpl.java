package com.info.admin.service.impl;

import com.info.admin.dao.CustomDesktopDao;
import com.info.admin.entity.CustomDesktop;
import com.info.admin.service.CustomDesktopService;
import com.info.admin.utils.PageUtil;
import com.info.admin.utils.UUIDUtils;
import com.info.admin.vo.CustomDesktopVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
     * 添加CustomDesktop对象
     *
     * @param entity 明细对象
     * @return int
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    @Override
    public int insert(CustomDesktop entity) {
        entity.setDesktopId(UUIDUtils.getUUid());
        return dao.insert(entity);
    }

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
    @Override
    public int insertBatchDesktop(Long userId, String[] menuIds,
                                  String[] menuNames, String[] widths, String[] heights, String[] seqs) {
        List<CustomDesktop> customDesktops = new ArrayList<>();
        CustomDesktop cd = new CustomDesktop();
        cd.setUserId(userId);
        this.delete(cd);
        for (int i = 0; i < menuIds.length; i++) {
            CustomDesktop customDesktop = new CustomDesktop();
            customDesktop.setDesktopId(UUIDUtils.getUUid());
            customDesktop.setCreateUser(userId);
            customDesktop.setUserId(userId);
            customDesktop.setMenuId(Long.parseLong(menuIds[i]));
            customDesktop.setCustomName(menuNames[i]);
            String width = widths[i];
            String height = heights[i];
            String seq = seqs[i];
            customDesktop.setWidth(width == null || StringUtils.isBlank(width) ? "50%" : width);
            customDesktop.setHeight(height == null || StringUtils.isBlank(height) ? "320px" : height);
            customDesktop.setSeq(Long.parseLong(seq == null || StringUtils.isBlank(seq) ? "1" : seq));
            customDesktops.add(customDesktop);
        }

        return dao.insertBatchDesktop(customDesktops);
    }

    /**
     * 修改CustomDesktop对象
     *
     * @param entity 明细对象
     * @return int
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    @Override
    public int update(CustomDesktop entity) {
        return dao.update(entity);
    }

    /**
     * 查询CustomDesktop对象
     *
     * @param entity 明细对象
     * @return List<CustomDesktop>
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    @Override
    public List<CustomDesktop> query(CustomDesktop entity) {
        return dao.query(entity);
    }

    /**
     * 删除CustomDesktop对象
     *
     * @param entity 明细对象
     * @return int
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    @Override
    public int delete(CustomDesktop entity) {
        return dao.delete(entity);
    }

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
    @Override
    public PageUtil pageQuery(CustomDesktop entity, int pageNum, int pageSize) {
        int size = dao.getPageCount(entity);
        int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
        List<CustomDesktop> result = dao.pageQuery(entity, offset, pageSize);
        PageUtil paginator = new PageUtil(pageSize, size, pageNum);
        paginator.setObject(result);
        return paginator;
    }

    /**
     * 分页查询CustomDesktop对象
     *
     * @param userId 对象
     * @return PageUtil
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    @Override
    public List<CustomDesktopVo> myDesktop(Long userId) {
        return dao.myDesktop(userId);
    }

    /**
     * 根据 id获取 自定义桌面
     *
     * @param desktopId 主键id
     * @return CustomDesktop
     * @author ysh
     * @date 2018-11-13 16:23:57
     * @updater or other
     */
    @Override
    public CustomDesktop getCustomDesktopById(String desktopId) {
        return dao.getCustomDesktopById(desktopId);
    }
}

	
