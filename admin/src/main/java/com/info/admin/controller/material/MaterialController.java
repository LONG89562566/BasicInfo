package com.info.admin.controller.material;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.Material;
import com.info.admin.entity.MaterialTree;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.MaterialService;
import com.info.admin.utils.PageUtil;
import freemarker.template.utility.StringUtil;
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

/**
 * @author administrator  
 * @date 2018-11-14 23:45:42 
 * @describe 材料 Controller
 */
@Controller
@RequestMapping("/admin/material")
public class MaterialController extends BaseController{	
	
    private static final Logger logger = LoggerFactory.getLogger(MaterialController.class);

    @Autowired
    private MaterialService service;
    
     /**
     *查询材料列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("material:query")
    public String getMaterialList(HttpServletRequest request, @ModelAttribute Material entity, Model model) {
        logger.info("[MaterialController][getMaterialList] 查询材料列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("material", entity);
        return "material/listMaterial";
    }

     /**
     *我的桌面查询材料列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("material:query")
    public String getMaterialListDesktop(HttpServletRequest request, @ModelAttribute Material entity, Model model) {
        logger.info("[MaterialController][getMaterialListDesktop] 我的桌面查询材料列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("material", entity);
        return "material/listMaterialDesktop";
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,String materialId,String projectId,Model model){
        try{
            if(null != materialId){
                //根据id查询系统用户
                Material material = service.getMaterialById(materialId);
                model.addAttribute("material", material);
            }
            model.addAttribute("materialId", materialId);
            model.addAttribute("projectId", projectId);
            return "material/addMaterial";
        }catch(Exception e){
            logger.error("[MaterialController][addOrEdit]: materialId="+materialId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改Material对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertAndUpdate(HttpServletRequest request,Material entity) {
        logger.info("[MaterialController][insertAndUpdate] 新增或者修改Material对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            // 通过id来判断是新增还是修改
            if ( StringUtils.isNotEmpty(entity.getMaterialId())) {
                result = service.update(entity);
            } else {
                result = service.insert(entity);
            }
            if (result > 0) {
                 return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[MaterialController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询Material对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "query", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult query(Material entity) {
        logger.info("[MaterialController][query] 查询Material对象:");
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[MaterialController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除Material对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult delete(Material entity) {
        logger.info("[MaterialController][delete] 删除Material对象:");
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
            logger.error("[MaterialController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询Material对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQuery(HttpServletRequest request,Material entity) {
        logger.info("[MaterialController][pageQuery] 查询Material对象:");
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[MaterialController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     *  材料 树
     *@return   java.lang.String
     *@author
     *@createTime   2018/11/17
     *@updater  or other
     */
    @ResponseBody
    @RequestMapping(value = "/materialTree", method = { RequestMethod.GET, RequestMethod.POST })
    public Object materialTree( MaterialTree materialTree ,String projectId ) {
        List<MaterialTree> materialTreeList = service.getMaterialTree(materialTree,projectId);
        return service.materialTree(materialTreeList, 0);
    }
}	
