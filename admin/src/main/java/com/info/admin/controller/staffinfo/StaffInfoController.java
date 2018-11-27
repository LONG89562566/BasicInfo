package com.info.admin.controller.staffinfo;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.StaffInfo;
import com.info.admin.entity.SysUser;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.StaffInfoService;
import com.info.admin.service.SysUserService;
import com.info.admin.utils.PageUtil;
import com.info.admin.utils.TreeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author administrator
 * @date 2018-11-14 23:45:42
 * @describe 员工信息 Controller
 */
@Controller
@RequestMapping("/admin/staffInfo")
public class StaffInfoController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(StaffInfoController.class);

    @Autowired
    private StaffInfoService service;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询员工信息列表
     *
     * @return String
     * @author ysh
     * @date 2018-07-12 10:50:32
     * @updater or other
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresPermissions("staffInfo:query")
    public String getStaffInfoList(HttpServletRequest request, @ModelAttribute StaffInfo entity, Model model) {
        logger.info("[StaffInfoController][getStaffInfoList] 查询员工信息列表:");
        entity.setDeleteFlag(0L);
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("staffInfo", entity);
        return "staffinfo/listStaffInfo";
    }

    /**
     * 我的桌面查询员工信息列表
     *
     * @return String
     * @author ysh
     * @date 2018-07-12 10:50:32
     * @updater or other
     */
    @RequestMapping(value = "/list/desktop", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresPermissions("staffInfo:query")
    public String getStaffInfoListDesktop(HttpServletRequest request, @ModelAttribute StaffInfo entity, Model model) {
        logger.info("[StaffInfoController][getStaffInfoListDesktop] 我的桌面查询员工信息列表:");
        entity.setDeleteFlag(0L);
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("staffInfo", entity);
        return "staffinfo/listStaffInfoDesktop";
    }

    /**
     * 跳转到新增页面
     *
     * @return String
     * @author
     * @date 2018-07-12 10:50:32
     * @updater or other
     */
    @RequestMapping(value = "/addOrEdit", method = {RequestMethod.GET, RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request, String staffId, String orgId, Model model) {
        try {
            if (null != staffId && StringUtils.isNotBlank(staffId)) {
                //根据id查询系统用户
                StaffInfo staffInfo = service.getStaffInfoById(staffId);
                model.addAttribute("staffInfo", staffInfo);
            }
            model.addAttribute("staffId", staffId);
            model.addAttribute("orgId", orgId);
            return "staffinfo/addStaffInfo";
        } catch (Exception e) {
            logger.error("[StaffInfoController][addOrEdit]: staffId=" + staffId, e);
            return "500";
        }
    }

    /**
     * 跳转到绑定页面
     *
     * @return String
     * @author
     * @date 2018-07-12 10:50:32
     * @updater or other
     */
    @RequestMapping(value = "/boundUser", method = {RequestMethod.GET, RequestMethod.POST})
    public String boundUser(HttpServletRequest request, String staffId, Model model) {
        try {
            model.addAttribute("staffId", staffId);
            return "staffinfo/boundUser";
        } catch (Exception e) {
            logger.error("[StaffInfoController][boundUser]: staffId=" + staffId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改StaffInfo对象
     *
     * @param request 请求
     * @param entity  对象
     * @return com.netcai.admin.result.JsonResult
     * @author ysh
     * @date 2018-11-14 23:45:42
     * @updater or other
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult insertAndUpdate(HttpServletRequest request, StaffInfo entity) {
        logger.info("[StaffInfoController][insertAndUpdate] 新增或者修改StaffInfo对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            // 通过id来判断是新增还是修改
            if (StringUtils.isNotEmpty(entity.getStaffId())) {
                result = service.update(entity);
            } else {
                entity.setDeleteFlag(0L);
                entity.setCreateUser(getLoginUserId(request));
                result = service.insert(entity);
            }
            if (result > 0) {
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[StaffInfoController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 保存绑定数据
     *
     * @param request 请求
     * @param staffId  人员id
     * @param boundUserId  绑定用户id
     * @return com.netcai.info.result.JsonResult
     * @author ysh
     * @date 2018-11-14 23:45:42
     * @updater or other
     */
    @ResponseBody
    @RequestMapping(value = "saveBoundUser", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult saveBoundUser(HttpServletRequest request, String staffId,Long boundUserId) {
        logger.info("[StaffInfoController][saveBoundUser] 新增或者修改StaffInfo对象:");
        try {
            if (StringUtils.isEmpty(staffId)) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            SysUser user = new SysUser();
            user.setIsBound("1");
            user.setStaffId(staffId);
            user.setId(boundUserId);
            int  result = sysUserService.updateSysUser(user);

            if (result > 0) {
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[StaffInfoController][saveBoundUser] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 取消绑定的用户
     *
     * @param request 请求
     * @param staffId  人员id
     * @return com.netcai.info.result.JsonResult
     * @author ysh
     * @date 2018-11-14 23:45:42
     * @updater or other
     */
    @ResponseBody
    @RequestMapping(value = "escBoundUser", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult escBoundUser(HttpServletRequest request, String staffId) {
        logger.info("[StaffInfoController][escBoundUser] 取消绑定的用户:");
        try {
            if (StringUtils.isEmpty(staffId)) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            SysUser user = new SysUser();
            user.setIsBound("1");
            user.setStaffId(staffId);
            int  result = sysUserService.escBoundUser(user);

            if (result > 0) {
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[StaffInfoController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询StaffInfo对象
     *
     * @param flowId 对象
     * @return com.netcai.admin.result.JsonResult
     * @author ysh
     * @date 2018-11-14 23:45:42
     * @updater or other
     */
    @ResponseBody
    @RequestMapping(value = "getStaffInfoByFlowId", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult getStaffInfoByFlowId(String flowId ) {
        logger.info("[StaffInfoController][getStaffInfoByFlowId] 查询StaffInfo对象:");
        try {

            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.getStaffInfoByFlowId(flowId));
        } catch (Exception e) {
            logger.error("[StaffInfoController][getStaffInfoByFlowId] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询StaffInfo对象
     *
     * @param entity 对象
     * @return com.netcai.admin.result.JsonResult
     * @author ysh
     * @date 2018-11-14 23:45:42
     * @updater or other
     */
    @ResponseBody
    @RequestMapping(value = "query", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult query(StaffInfo entity) {
        logger.info("[StaffInfoController][query] 查询StaffInfo对象:");
        try {
            entity.setDeleteFlag(0L);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[StaffInfoController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除StaffInfo对象
     *
     * @param entity 对象
     * @return com.netcai.admin.result.JsonResult
     * @author ysh
     * @date 2018-11-14 23:45:42
     * @updater or other
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult delete(StaffInfo entity) {
        logger.info("[StaffInfoController][delete] 删除StaffInfo对象:");
        try {
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }
            int result = service.delete(entity);
            if (result > 0) {
                SysUser user = new SysUser();
                user.setIsBound("1");
                user.setStaffId(entity.getStaffId());
                result = sysUserService.escBoundUser(user);

                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[StaffInfoController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询StaffInfo对象
     *
     * @param entity 对象
     * @return com.netcai.admin.result.JsonResult
     * @author ysh
     * @date 2018-11-14 23:45:42
     * @updater or other
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult pageQuery(HttpServletRequest request, StaffInfo entity) {
        logger.info("[StaffInfoController][pageQuery] 查询StaffInfo对象:");
        try {
            entity.setDeleteFlag(0L);
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.pageQuery(entity, pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[StaffInfoController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     *人员结构 树
     *@return   java.lang.String
     *@author
     *@createTime   2018/11/17
     *@updater  or other
     */
    @ResponseBody
    @RequestMapping(value = "/staffInfoTree", method = { RequestMethod.GET, RequestMethod.POST })
    public Object staffInfoTree( StaffInfo entity ) {
        List<StaffInfo> staffInfoList = service.query(entity);
        CopyOnWriteArrayList<StaffInfo> cowList = new CopyOnWriteArrayList<>(staffInfoList);
        return service.getTreeJson(cowList);
    }


}
