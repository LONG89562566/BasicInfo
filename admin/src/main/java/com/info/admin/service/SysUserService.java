package com.info.admin.service;

import com.info.admin.entity.ActiveSysUser;
import com.info.admin.entity.SysUser;
import com.info.admin.entity.ActiveSysUser;
import com.info.admin.entity.SysUser;
import com.info.admin.utils.PageUtil;
import net.sf.json.JSONArray;

import java.util.List;

public interface SysUserService {
	
	/**
	 * 分页查询用户信息
	 * 
	 * @param user
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAllSysUser(SysUser user, int pageNum, int pageSize);

	/**
	 * 分页查询用户信息
	 *
	 * @param user
	 * @return
	 */
	public List<SysUser> getAllSysUserList(SysUser user);

	/**
	 *
	 * @return
	 */
	public JSONArray getUserTree(List<SysUser> sysUsers);

	/**
	 * 根据登录名称查询用户
	 * @param username
	 * @return
	 */
	public ActiveSysUser getUserByUserName(String username);
	
	/**
	 * 根据登录名称查询用户
	 * @param phone
	 * @return
	 */
	public SysUser getUserByPhone(String phone);
	
	/**
	 * 根据登录名称查询用户
	 * @param id
	 * @return
	 */
	public SysUser getUserById(Long id);

	/**
	 * 修改数据
	 * @param user
	 * @return
	 */
	int updateSysUser(SysUser user);

	/**
	 * 取消绑定用户
	 * @param user
	 * @return
	 */
	int escBoundUser(SysUser user);
	
	/**
	 * 新增系统用户
	 * @param user
	 * @return
	 */
	public int insertAndUpdate(SysUser user);
	
	/**
	 * 禁用系统用户
	 * @param id
	 * @return
	 */
	public int disabledSysUser(Long id);
	
	/**
	 * 启用系统用户
	 * @param id
	 * @return
	 */
	public int enabledSysUser(Long id);
}
