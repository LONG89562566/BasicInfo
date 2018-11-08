package com.info.admin.controller.sysSystemConfig;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.admin.entity.SysSystemConfig;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.SysSystemConfig;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.SysSystemConfigService;
import com.info.admin.utils.PageUtil;

/**
 * 系统配置;
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class SysSystemConfigController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(SysSystemConfigController.class);

	@Autowired
	private SysSystemConfigService sysSystemConfigService;

	/**
	 * 到添加页面去；
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sysSystemConfig/toAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String  toAddSysSystemConfig(HttpServletRequest request, HttpServletResponse response,Long id,Model model) {
		
		if (id != null) {
			SysSystemConfig sysSystemConfig = sysSystemConfigService.getSysSystemConfigByKey(id);
			model.addAttribute("sysSystemConfig",sysSystemConfig);
		}
		
		return "sys/system/addConfig";
		
	}
	
	/*
	 * 根据id查找加工方式
	 */
	@RequestMapping(value = "/sysSystemConfig/getById", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody SysSystemConfig getById(HttpServletRequest request, HttpServletResponse response,Long id) {
		SysSystemConfig sysSystemConfig = sysSystemConfigService.getSysSystemConfigByKey(id);
		return sysSystemConfig;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sysSystemConfig/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String  addSysSystemConfig(HttpServletRequest request, HttpServletResponse response,SysSystemConfig sysSystemConfig) {
		
		try{

			if(null == sysSystemConfig.getId()){
				//新增
				sysSystemConfig.setCreateTime(new Date());
				
				Integer size = sysSystemConfigService.insertSysSystemConfig(sysSystemConfig);
				
				if(size > 0){
					
					return "redirect:"+"/admin/sysSystemConfig/list";
				}else {
					return "500";
				}
			}else {
				Integer size = sysSystemConfigService.updateSysSystemConfig(sysSystemConfig);
				
				if(size > 0){
					
					return "redirect:"+"/admin/sysSystemConfig/list";
				}else {
					return "500";
				}
			}
			
		}catch(Exception e){
			logger.error("[SysSystemConfigController][addSysSystemConfig]:", e);
            return "500";
		}
		
	}
	
	/**
	 * 根据Id删除
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sysSystemConfig/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public Object deleteSysSystemConfig(HttpServletRequest request, HttpServletResponse response ,Long id) {
		
		logger.info("SysSystemConfigController.deleteSysSystemConfigController.id-->" +  id);
		
		if (id == null) {
			
			return new JsonResult(JsonResultCode.FAILURE, "参数有误", "");
		}
		try {
			
			int result = sysSystemConfigService.deleteSysSystemConfig(id);
			
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "删除成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "删除失败", "");
			}
			
		} catch (Exception e) {
			logger.error("[SysSystemConfigController][deleteSysSystemConfigController] id:", e);
			
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/sysSystemConfig/update", method = { RequestMethod.GET, RequestMethod.POST })
	public void updateSysSystemConfig(HttpServletRequest request, HttpServletResponse response) {
		
		SysSystemConfig sysSystemConfig=new SysSystemConfig();
		
		sysSystemConfig.setId((long) 2);
		
		sysSystemConfig.setParamCode("222");
		
		sysSystemConfigService.updateSysSystemConfig(sysSystemConfig);
	}
	
	/**
	 * 系统配置列表
	 * 
	 * @param request
	 * @param response
	 * @param SysSystemConfig 条件查询
	 * @return
	 */
	@RequestMapping(value = "/sysSystemConfig/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String sysSystemConfigList(HttpServletRequest request, HttpServletResponse response,SysSystemConfig sysSystemConfig,Model model) 
	{
		// 获取分页当前的页码
		int currentPageNum = this.getPageNum(request);
		// 获取分页的大小
		int currentPageSize = this.getPageSize(request);

		PageUtil paginator = sysSystemConfigService.getPageResult(sysSystemConfig, currentPageNum, currentPageSize);

		model.addAttribute("paginator", paginator);
		
		model.addAttribute("sysSystemConfig",sysSystemConfig);

		return "sys/system/configList";
	}
	
	/**
	 * 到添加页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sysSystemConfig/get", method = { RequestMethod.GET, RequestMethod.POST })
	public String  getSysSystemConfigByKey(HttpServletRequest request, HttpServletResponse response,Long id,Model model) {
		SysSystemConfig sysSystemConfig = sysSystemConfigService.getSysSystemConfigByKey(id);
		model.addAttribute("sysSystemConfig",sysSystemConfig);
		return "redirect:"+"/admin/sysSystemConfig/addConfig";
	}
}