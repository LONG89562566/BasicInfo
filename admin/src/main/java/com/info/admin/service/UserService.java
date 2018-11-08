package com.info.admin.service;

import com.info.admin.entity.Users;
import com.info.admin.entity.Users;

public interface UserService {
	
	/**
	 * 启用系统用户
	 */
	public int getByAccount(String account);
	
	public Users getUsersByAccount(String account);
}
