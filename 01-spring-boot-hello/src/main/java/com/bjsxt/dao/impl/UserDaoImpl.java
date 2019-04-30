package com.bjsxt.dao.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.bjsxt.dao.UserDao;

/**
 * @author Administrator
 * 将UserDaoImpl的实例对象（单例）注册到容器中
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public void set(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	/* 
	 * 以秒为单位，返回给定 key的剩余生存时间(TTL, time to live)
	 */
	@Override
	public long ttl(String key) {
		return this.redisTemplate.getExpire(key);
	}

	/* 
	 * 为给定 key 设置生存时间，当 key过期时(生存时间为 0 )，它会被自动删除。
	 */
	@Override
	public void expire(String key, long times, TimeUnit timeUnit) {
		this.redisTemplate.expire(key, times, timeUnit);
	}

}
