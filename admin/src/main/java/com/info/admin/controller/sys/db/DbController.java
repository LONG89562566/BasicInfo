package com.info.admin.controller.sys.db;

import com.info.admin.constants.DBPropertie;
import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.DBP;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.utils.PropertiesUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 动态数据源
 * @author ljuenan
 * @date 2018/11/11
 */
@Controller
@RequestMapping("/admin")
public class DbController extends BaseController {

	private static final Logger logger=Logger.getLogger(DbController.class);
	
	/**
	 * 新增数据源
	 */
	@ResponseBody
	@RequestMapping(value="/setDB",method={RequestMethod.GET,RequestMethod.POST})
	public JsonResult setDB(DBP dbp)
	{
		logger.info("[DbController][setDB] 新增数据源:");
		try{
            if (null==dbp){
                return new JsonResult(JsonResultCode.FAILURE, "参数错误", "");
            }
            boolean result = PropertiesUtil.setDB(dbp,DBPropertie.PP_DB);
            return new JsonResult(result?JsonResultCode.SUCCESS:JsonResultCode.FAILURE, result?"新增成功":"新增失败", "");
		}catch(Exception e)
		{
			logger.error("[DbController][setDB] exception:",e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

    /**
     * 删除数据源
     */
    @ResponseBody
    @RequestMapping(value="/delDB",method={RequestMethod.GET,RequestMethod.POST})
    public JsonResult delDB(String code)
    {
        logger.info("[DbController][delDB] 删除数据源:");
        try{
            if (StringUtils.isEmpty(code)){
                return new JsonResult(JsonResultCode.FAILURE, "参数错误", "");
            }
            boolean result = PropertiesUtil.delDB(code,DBPropertie.PP_DB);
            return new JsonResult(result?JsonResultCode.SUCCESS:JsonResultCode.FAILURE, result?"删除成功":"删除失败", "");
        }catch(Exception e)
        {
            logger.error("[SysUserController][login] exception:",e);
            return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
        }
    }

    /**
     * 查询数据源
     */
    @ResponseBody
    @RequestMapping(value="/queryDB",method={RequestMethod.GET,RequestMethod.POST})
    public JsonResult queryDB(String code)
    {
        logger.info("[DbController][queryDB] 查询数据源:");
        try{
            if (StringUtils.isEmpty(code)){
                return new JsonResult(JsonResultCode.FAILURE, "参数错误", "");
            }
            return new JsonResult(JsonResultCode.SUCCESS, "查询成功", PropertiesUtil.queryDB(code,DBPropertie.PP_DB,DBPropertie.PP_ADMIN));
        }catch(Exception e)
        {
            logger.error("[DbController][queryDB] exception:",e);
            return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
        }
    }

    /**
     * 查询数据源列表
     */
    @ResponseBody
    @RequestMapping(value="/queryDBList",method={RequestMethod.GET,RequestMethod.POST})
    public JsonResult queryDBList()
    {
        logger.info("[DbController][queryDBList] 查询数据源:");
        try{
            return new JsonResult(JsonResultCode.SUCCESS, "查询成功", PropertiesUtil.queryDBList(DBPropertie.PP_DB,DBPropertie.PP_ADMIN));
        }catch(Exception e)
        {
            logger.error("[DbController][queryDBList] exception:",e);
            return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
        }
    }

    /**
     * 设置当前数据源
     */
    @ResponseBody
    @RequestMapping(value="/setUseDB",method={RequestMethod.GET,RequestMethod.POST})
    public JsonResult setUseDB(DBP dbp)
    {
        logger.info("[DbController][setUseDB] 查询数据源:");
        try{
            if (null==dbp){
                return new JsonResult(JsonResultCode.FAILURE, "参数错误", "");
            }
            PropertiesUtil.setUseDB(dbp,DBPropertie.PP_ADMIN);
            return new JsonResult(JsonResultCode.SUCCESS, "设置成功","" );
        }catch(Exception e)
        {
            logger.error("[DbController][setUseDB] exception:",e);
            return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
        }
    }
}