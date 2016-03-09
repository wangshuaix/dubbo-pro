package com.isoft.dubbo.demo.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.isoft.dubbo.demo.user.bean.User;
import com.isoft.dubbo.demo.user.dao.UserBaseDao;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserBaseDao userBaseDao;

	@Override
	public boolean delUser(String name) {
		return userBaseDao.delUser(name);
	}

	@Override
	public User getUser(String name) {
		return userBaseDao.getUser(name);
	}

	@Override
	public boolean saveUser(User user) {
		return userBaseDao.saveUser(user);
	}

}
