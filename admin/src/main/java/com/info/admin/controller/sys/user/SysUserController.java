package com.info.admin.controller.sys.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.SysRole;
import com.info.admin.entity.SysUser;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.SysRoleService;
import com.info.admin.service.SysUserService;
import com.info.admin.shiro.UserRealm;
import com.info.admin.utils.PageUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.SysRole;
import com.info.admin.entity.SysUser;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.SysRoleService;
import com.info.admin.service.SysUserService;
import com.info.admin.shiro.UserRealm;
import com.info.admin.utils.PageUtil;

/**
 * 系统用户信息操作
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class SysUserController extends BaseController {

	private static final Logger logger=Logger.getLogger(SysUserController.class);
	
	@Autowired 
	private SysUserService sysUserService;
	@Autowired 
	private SysRoleService sysRoleService;
	@Autowired
	private UserRealm userRealm;
	
	@RequestMapping("/login")
	public String toLogin(HttpServletRequest request,HttpServletResponse response){
		//获取主体信息
		Subject subject = SecurityUtils.getSubject();
		//判断用户是否已登录，若登陆则直接跳转到主页
		if(subject.isAuthenticated()){
			return "index";
		}
		return "login";
	}
	
	@RequestMapping("/checkLogin")
	public String login(HttpServletRequest request,HttpServletResponse response){
		String loggin_Code = (String) request.getAttribute("shiroLoginFailure");
		if(StringUtils.isBlank(loggin_Code)){
			return "login";
		}
		if(UnknownAccountException.class.getName().equals(loggin_Code)){
			System.out.println("用户名错误");
		}else if(IncorrectCredentialsException.class.getName().equals(loggin_Code)){
			System.out.println("密码错误");
		}else if (AuthenticationException.class.getName().equals(loggin_Code)) {
			System.out.println("shiro认证异常");
		}
		return "login";
	}
	
	/**
	 * 调到无权访问页面
	 */
	@RequestMapping(value="/unauthorized",method={RequestMethod.GET,RequestMethod.POST})
	public String unauthorized(HttpServletRequest request, HttpServletResponse response)
	{
		return "unauthorized";
	}
	
	/**
	 * 退出登录
	 */
	@RequestMapping(value="/logout",method={RequestMethod.GET,RequestMethod.POST})
	public String logout(HttpServletRequest request, HttpServletResponse response)
	{
		//清除资源权限缓存
		userRealm.clearCache();
		Subject subject = SecurityUtils.getSubject();
		//退出登录
		subject.logout();
		return "login";
	}
	
	
	
	/**
	 * 查询系统用户列表
	 */
	@RequestMapping(value="/sysUser/list",method={RequestMethod.GET,RequestMethod.POST})
	@RequiresPermissions("sysUser:query")
	public String getSysUserList(HttpServletRequest request, HttpServletResponse response,Model model,SysUser user)
	{
		logger.info("[SysUserController][getSysUserList] 查询系统用户列表:");
		int pageNum=this.getPageNum(request);
		int pageSize=this.getPageSize(request);
		PageUtil paginator= sysUserService.getAllSysUser(user, pageNum, pageSize);
		model.addAttribute("paginator", paginator);
		model.addAttribute("sysUser", user);
		return "sys/user/userList";
	}

	/**
	 * 查询系统用户列表
	 */
	@RequestMapping(value="/sysUser/list/desktop",method={RequestMethod.GET,RequestMethod.POST})
	@RequiresPermissions("sysUser:query")
	public String userListDesktop(HttpServletRequest request, HttpServletResponse response,Model model,SysUser user)
	{
		logger.info("[SysUserController][userListDesktop] 查询系统用户列表:");
		int pageNum=this.getPageNum(request);
		int pageSize=this.getPageSize(request);
		PageUtil paginator= sysUserService.getAllSysUser(user, pageNum, pageSize);
		model.addAttribute("paginator", paginator);
		model.addAttribute("sysUser", user);
		return "sys/user/userListDesktop";
	}

	/**
	 * 查询系统用户列表
	 */
	@ResponseBody
	@RequestMapping(value="/sysUser/pageQuery",method={RequestMethod.GET,RequestMethod.POST})
	public JsonResult pageQuery(HttpServletRequest request, HttpServletResponse response,Model model,SysUser user)	{
		logger.info("[SysUserController][pageQuery] 查询CkCommunity对象:");
		try {
			// 获取分页当前的页码
			int pageNum = this.getPageNum(request);
			// 获取分页的大小
			int pageSize = this.getPageSize(request);
			PageUtil paginator = sysUserService.getAllSysUser(user , pageNum, pageSize);
			return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
		} catch (Exception e) {
			logger.error("[SysUserController][pageQuery] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 查询系统用户列表
	 */
	@ResponseBody
	@RequestMapping(value="/sysUser/getUserTree",method={RequestMethod.GET,RequestMethod.POST})
	public Object getUserTree(HttpServletRequest request, HttpServletResponse response,Model model,SysUser user)	{
		logger.info("[SysUserController][getUserTree] 查询CkCommunity对象:");
		try {
			List<SysUser>  sysUserList = sysUserService.getAllSysUserList(user);
			return sysUserService.getUserTree(sysUserList);
		} catch (Exception e) {
			logger.error("[SysUserController][getUserTree] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 查询系统已绑定用户列表
	 */
	@ResponseBody
	@RequestMapping(value="/sysUser/getUserTreeYesBound",method={RequestMethod.GET,RequestMethod.POST})
	public Object getUserTreeYesBound(HttpServletRequest request, HttpServletResponse response,Model model,SysUser user)	{
		logger.info("[SysUserController][getUserTreeYesBound] 查询CkCommunity对象:");
		try {
			user.setIsBound("1");
			List<SysUser>  sysUserList = sysUserService.getAllSysUserList(user);
			return sysUserService.getUserTree(sysUserList);
		} catch (Exception e) {
			logger.error("[SysUserController][getUserTreeYesBound] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 查询系统未绑定用户列表
	 */
	@ResponseBody
	@RequestMapping(value="/sysUser/getUserTreeNoBound",method={RequestMethod.GET,RequestMethod.POST})
	public Object getUserTreeNoBound(HttpServletRequest request, HttpServletResponse response,Model model,SysUser user)	{
		logger.info("[SysUserController][getUserTreeNoBound] 查询CkCommunity对象:");
		try {
			user.setIsBound("0");
			user.setStaffId("");
			List<SysUser>  sysUserList = sysUserService.getAllSysUserList(user);
			return sysUserService.getUserTree(sysUserList);
		} catch (Exception e) {
			logger.error("[SysUserController][getUserTreeNoBound] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(value="/sysUser/addSysUser",method={RequestMethod.GET,RequestMethod.POST})
	public String addSysUser(HttpServletRequest request, HttpServletResponse response,Long id,Model model)
	{
		List<SysRole> sysRoleList = sysRoleService.getAllSysRoleByStatus();
		model.addAttribute("sysRoleList", sysRoleList);
		if(null != id){
			//根据id查询系统用户
			SysUser sysUser = sysUserService.getUserById(id);
			List<SysRole> myRoleList = sysRoleService.getRoleByUserId(id);
			model.addAttribute("user", sysUser);
			model.addAttribute("myRoleList", myRoleList);
		} 
		return "sys/user/addUser";
	}
	
	/**
	 * 新增和修改
	 */
	@ResponseBody
	@RequestMapping(value="/sysUser/insertAndUpdate",method={RequestMethod.GET,RequestMethod.POST})
	public JsonResult insertAndUpdateSysUserList(HttpServletRequest request, HttpServletResponse response, SysUser user)
	{
		logger.info("[SysUserController][insertAndUpdateSysUserList] 新增和更新:"+user);
		try{
			if(null == user){
				return new JsonResult(JsonResultCode.FAILURE, "用户信息为空", "");
			}
			int result = sysUserService.insertAndUpdate(user);
			//清除权限资源缓存
			if(result>0){
				return new JsonResult(JsonResultCode.SUCCESS, "更新数据成功", "");
			}
			return new JsonResult(JsonResultCode.FAILURE, "更新数据失败", "");
		}catch(Exception e)
		{
			logger.error("[SysUserController][insertAndUpdateSysUserList] exception:",e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}
	
	/**
	 * 禁用
	 */
	@ResponseBody
	@RequestMapping(value="/sysUser/disabled",method={RequestMethod.GET,RequestMethod.POST})
	public JsonResult disabledSysUser(HttpServletRequest request, HttpServletResponse response,Long id)
	{
		logger.info("[SysUserController][disabledSysUser] 禁用用户:");
		try{
			if(null == id){
				return new JsonResult(JsonResultCode.FAILURE, "用户id为空", "");
			}
			int result = sysUserService.disabledSysUser(id);
			if(result>0){
				return new JsonResult(JsonResultCode.SUCCESS, "禁用成功", "");
			}
			return new JsonResult(JsonResultCode.FAILURE, "禁用失败", "");
		}catch(Exception e)
		{
			logger.error("[SysUserController][login] exception:",e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}
	
	/**
	 * 启用
	 */
	@ResponseBody
	@RequestMapping(value="/sysUser/enabled",method={RequestMethod.GET,RequestMethod.POST})
	public JsonResult enabledSysUser(HttpServletRequest request, HttpServletResponse response,Long id)
	{
		logger.info("[SysUserController][enabledSysUser] 启用用户:");
		try{
			if(null == id){
				return new JsonResult(JsonResultCode.FAILURE, "用户id为空", "");
			}
			int result = sysUserService.enabledSysUser(id);
			if(result>0){
				return new JsonResult(JsonResultCode.SUCCESS, "启用成功", "");
			}
			return new JsonResult(JsonResultCode.FAILURE, "启用失败", "");
		}catch(Exception e)
		{
			logger.error("[SysUserController][login] exception:",e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}
	
}