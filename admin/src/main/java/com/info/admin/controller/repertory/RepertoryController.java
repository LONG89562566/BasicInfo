package com.info.admin.controller.repertory;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.Repertory;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.RepertoryService;
import com.info.admin.utils.PageUtil;
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
 * @describe 仓库 Controller
 */
@Controller
@RequestMapping("/admin/repertory")
public class RepertoryController extends BaseController{	
	
    private static final Logger logger = LoggerFactory.getLogger(RepertoryController.class);

    @Autowired
    private RepertoryService service;
    
     /**
     *查询仓库列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("repertory:query")
    public String getRepertoryList(HttpServletRequest request, @ModelAttribute Repertory entity, Model model) {
        logger.info("[RepertoryController][getRepertoryList] 查询仓库列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        entity.setDeleteFlag(0L);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("repertory", entity);
        return "repertory/listRepertory";
    }

     /**
     *我的桌面查询仓库列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("repertory:query")
    public String getRepertoryListDesktop(HttpServletRequest request, @ModelAttribute Repertory entity, Model model) {
        logger.info("[RepertoryController][getRepertoryListDesktop] 我的桌面查询仓库列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        entity.setDeleteFlag(0L);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("repertory", entity);
        return "repertory/listRepertoryDesktop";
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,String repertoryId,Model model){
        try{
            if(StringUtils.isNotEmpty(repertoryId)){
                //根据id查询系统用户
                Repertory repertory = service.getRepertoryById(repertoryId);
                model.addAttribute("repertory", repertory);
            }
            model.addAttribute("repertoryId", repertoryId);
            return "repertory/addRepertory";
        }catch(Exception e){
            logger.error("[RepertoryController][addOrEdit]: repertoryId="+repertoryId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改Repertory对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertAndUpdate(HttpServletRequest request,Repertory entity) {
        logger.info("[RepertoryController][insertAndUpdate] 新增或者修改Repertory对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            // 通过id来判断是新增还是修改
            if (StringUtils.isNotEmpty(entity.getRepertoryId())) {
                result = service.update(entity);
            } else {
                entity.setCreateUser(this.getLoginUserId(request));
                entity.setDeleteFlag(0L);
                result = service.insert(entity);
            }
            if (result > 0) {
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[RepertoryController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询Repertory对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "query", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult query(Repertory entity) {
        logger.info("[RepertoryController][query] 查询Repertory对象:");
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[RepertoryController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除Repertory对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult delete(Repertory entity) {
        logger.info("[RepertoryController][delete] 删除Repertory对象:");
        try {
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }
            int result = service.delete(entity);
            if (result > 0) {
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[RepertoryController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询Repertory对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQuery(HttpServletRequest request,Repertory entity) {
        logger.info("[RepertoryController][pageQuery] 查询Repertory对象:");
        try {
            entity.setDeleteFlag(0L);
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[RepertoryController][pageQuery] exception", e);
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
    @RequestMapping(value = "/repertoryTree", method = { RequestMethod.GET, RequestMethod.POST })
    public Object repertoryTree( Repertory entity ) {
        List<Repertory> repertoryList = service.query(entity);
        CopyOnWriteArrayList<Repertory> cowList = new CopyOnWriteArrayList<>(repertoryList);
        return service.getRepertoryTreeJson(cowList);
    }
}	
