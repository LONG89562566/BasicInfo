package com.info.admin.service.impl;

import com.info.admin.dao.UsersDao;
import com.info.admin.entity.Users;
import com.info.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersDao usersDao;

	/**
	 * 判断当前账号是否注册;
	 */
	@Override
	public int getByAccount(String account) {
		int result = 0;
		Users usersByAccount = usersDao.getUsersByAccount(account);
		if (usersByAccount != null) {
			result = 1;
		}
		return result;
	}

	@Override
	public Users getUsersByAccount(String account) {
		return usersDao.getUsersByAccount(account);
	}
}