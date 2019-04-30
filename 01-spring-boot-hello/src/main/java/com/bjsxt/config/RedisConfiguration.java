/**
 * 
 */
package com.bjsxt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Administrator
 * 
 * 序列化器GenericJackson2JsonRedisSerializer将任意类型的java对象和json字符串做双向转换。 
 * 如：a.b.User类型的java对象，有属性name和age 
 * 序列化 -> {'class':'a.b.User','name':'zhangsan', 'age':20} 
 * 反序列化 -> 读取json中的class属性，决定转换为什么类型的对象。
 * 特殊类型字符串： 如： String s = "abc" 序列化 -》 {\"abc\"}
 */
@Configuration
public class RedisConfiguration {
	@Bean
	public RedisTemplate<String, Object> initRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
		// 创建template对象
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		// 设置链接工厂对象
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		// 设置key序列化器
		redisTemplate.setStringSerializer(new StringRedisSerializer());
		// 设置value序列化器
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());		
		return redisTemplate;
	}
}
