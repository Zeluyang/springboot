package com.bjsxt.dao;

import java.util.concurrent.TimeUnit;

public interface UserDao {

	void set(String key, String value);

	public void set(String key, Object value);

	public Object get(String key);

	long ttl(String key);

	void expire(String key, long times, TimeUnit timeUnit);

}
