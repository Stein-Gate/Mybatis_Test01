package com.market.util;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 *  通过Spring  管理redis 缓存配置
 * @author Cherry
 */

@Configuration
@EnableCaching
public class RedisUtil extends CachingConfigurerSupport{
    private volatile JedisConnectionFactory jedisConnectionFactory;
    private volatile RedisTemplate<String,String> redisTemplate;
    private volatile RedisCacheManager redisCacheManager;

    /**
     * 无参数的构造方法
     */
    public RedisUtil(){
        super();
    }

    public RedisUtil(JedisConnectionFactory jedisConnectionFactory,
                     RedisTemplate<String,String> redisTemplate,
                     RedisCacheManager redisCacheManager){
        this.jedisConnectionFactory = jedisConnectionFactory;
        this.redisTemplate = redisTemplate;
        this.redisCacheManager = redisCacheManager;
    }

    public JedisConnectionFactory getJedisConnectionFactory() {
        return jedisConnectionFactory;
    }

    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public RedisCacheManager getRedisCacheManager() {
        return redisCacheManager;
    }

    public KeyGenerator customKeyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(o.getClass().getName());
                stringBuilder.append(method.getName());
                for (Object obj : objects){
                    stringBuilder.append(obj.toString());
                }
                return stringBuilder.toString();
            }
        };
    }
}
