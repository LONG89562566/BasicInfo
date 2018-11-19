package com.info.admin.service.impl;

import java.util.Date;
import java.util.List;

import com.info.admin.dao.SysMenuDao;
import com.info.admin.dao.SysUserDao;
import com.info.admin.entity.ActiveSysUser;
import com.info.admin.entity.SysMenu;
import com.info.admin.entity.SysUser;
import com.info.admin.service.SysUserService;
import com.info.admin.utils.PageUtil;
import com.info.admin.utils.RandomUtil;
import com.info.admin.utils.ShiroMD5Utils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.admin.constants.SysStatus;
import com.info.admin.dao.SysMenuDao;
import com.info.admin.dao.SysUserDao;
import com.info.admin.entity.ActiveSysUser;
import com.info.admin.entity.SysMenu;
import com.info.admin.entity.SysUser;
import com.info.admin.service.SysUserService;
import com.info.admin.utils.PageUtil;
import com.info.admin.utils.RandomUtil;
import com.info.admin.utils.ShiroMD5Utils;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysMenuDao sysMenuDao;
	
	/**
	 * 根据登录名获取用户
	 */
	@Override
	public ActiveSysUser getUserByUserName(String username) {
		SysUser sysUser = sysUserDao.getUserByUserName(username);
		if(sysUser==null){
			return null;
		}
		ActiveSysUser user = new ActiveSysUser();
		user.setId(sysUser.getId());
		user.setUserName(sysUser.getUserName());
		user.setPassword(sysUser.getPassword());
		user.setName(sysUser.getName());
		user.setSalt(sysUser.getSalt());
		
		//查询用户拥有的菜单
		List<SysMenu> menuList = sysMenuDao.getAllMenuByUserId(sysUser.getId(), 1);
		user.setMenuList(menuList);
		return user;
	}

	/**
	 * 分页查询数据
	 */
	@Override
	public PageUtil getAllSysUser(SysUser user, int pageNum, int pageSize) {

		int size = sysUserDao.getPageCount(user);

		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

		List<SysUser> userList = sysUserDao.getAllSysUser(user, offset, pageSize);

		PageUtil pageUtil = new PageUtil(pageSize, size, pageNum);

		pageUtil.setObject(userList);

		return pageUtil;
	}

	/**
	 * 查询数据
	 */
	@Override
	public List<SysUser> getAllSysUserList(SysUser user) {
		return sysUserDao.getAllSysUserList(user);
	}

	/**
	 *
	 * @return
	 */
	@Override
	public JSONArray getUserTree(List<SysUser> sysUsers){
		JSONArray all = new JSONArray();
		for(SysUser sysUser : sysUsers){
			JSONObject main = new JSONObject();
			main.put("id",sysUser.getId());
			main.put("name",sysUser.getName());
			main.put("text",sysUser.getName());
			main.put("select","true");
			all.add(main);
		}
		return all;
	}

	/**
	 * 根据id查询
	 */
	@Override
	public SysUser getUserById(Long id) {
		return sysUserDao.getUserById(id);
	}
	
	/**
	 * 根据登录名称查询用户
	 */
	@Override
	public SysUser getUserByPhone(String phone) {
		return sysUserDao.getUserByPhone(phone);
	}

	/**
	 * 新增和更新
	 */
	@Override
	public int insertAndUpdate(SysUser user) {
		Date time = new Date();
		String salt = RandomUtil.generateMixString(6);
		if(StringUtils.isNotBlank(user.getPassword())){
			String password = ShiroMD5Utils.getMd5Password(user.getPassword(), salt);
			user.setPassword(password);
			user.setSalt(salt);
		}
		//修改
		if (user.getId() != null) {
			//删除角色
			sysUserDao.deleteUserRole(user.getId());
			//添加角色
			sysUserDao.insertUserRole(user.getId(), user.getRoleIds());
			user.setLastUpdateTime(time);
			return sysUserDao.updateSysUser(user);
		}
		user.setStatus(SysStatus.UN_FORBIDDEN);
		user.setCreateTime(time);
		user.setLastUpdateTime(time);
		int result = sysUserDao.insertSysUser(user);
		//添加角色
		sysUserDao.insertUserRole(user.getId(), user.getRoleIds());
		return result;
	}

	/**
	 * 禁用用户
	 */
	@Override
	public int disabledSysUser(Long id) {
		return sysUserDao.disabledSysUser(id);
	}

	/**
	 * 启用用户
	 */
	@Override
	public int enabledSysUser(Long id) {
		return sysUserDao.enabledSysUser(id);
	}
	
}
