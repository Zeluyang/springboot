package com.bjsxt.service;

import java.util.concurrent.TimeUnit;

public interface UserService {
	void set(String key, String value);

	void set(String key, Object value);

	Object get(String key);

	long ttl(String key);

	void expire(String key, long times, TimeUnit timeUnit);
}
