package com.info.admin.controller.mybatis;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.admin.controller.base.BaseController;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;

/**
 * mybatis热部署工具类
 * @author administrator
 */
@Controller	
@RequestMapping("/admin")
public class MyBatisController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(MyBatisController.class);
	
	@Autowired
	private MybatisSessionCache mybatisSessionCache;
	
	@Value("#{applicationProperties['environment']}")	
	private String environment;
	
	@ResponseBody
	@RequestMapping(value = "/mybatis/clear", method = { RequestMethod.GET, RequestMethod.POST })
	public Object clear(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException 
	{
		try 
		{
			//生成环境
			if("product".equals(environment))
			{
				return new JsonResult(JsonResultCode.FAILURE, "非法请求", "");
			}
			mybatisSessionCache.refreshMapper();
			return new JsonResult(JsonResultCode.SUCCESS, "mybatis缓存清空成功", "");
		} catch (Exception e) {
			logger.error("[MyBatisController][clear] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "清理异常，请稍后重试", "");
		}
	}
}