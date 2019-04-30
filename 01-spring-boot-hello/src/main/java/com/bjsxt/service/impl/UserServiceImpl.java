package com.bjsxt.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.dao.UserDao;
import com.bjsxt.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void set(String key, String value) {
		userDao.set(key, value);
	}

	@Override
	public void set(String key, Object value) {
		userDao.set(key, value);
	}

	@Override
	public Object get(String key) {
		
		return userDao.get(key);
	}

	@Override
	public long ttl(String key) {
		return userDao.ttl(key);
	}

	@Override
	public void expire(String key, long times, TimeUnit timeUnit) {
		userDao.expire(key, times, timeUnit);
	}

}
