package org.manage.utils;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
/**
 * 
 * @ClassName:  RedisUtil   
 * @Description:TODO(操作redis工具类)   
 * @author: lyg  
 * @date:   2017年4月1日 上午11:02:16   
 *
 */
public class RedisUtil {

    Logger logger = Logger.getLogger(RedisUtil.class);

    private JedisPool jedisPool;

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public JedisPool getJedisPool(){
        return this.jedisPool;
    }

    /**
     * 
     * @Title: exists   
     * @Description: TODO(判断key是否存在)   
     * @param: @param key
     * @param: @return      
     * @return: boolean      
     * @throws
     */
    public boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(key);
        } catch (Exception e) {
            logger.error("set", e);
        } finally {
            if (null != jedis)
                jedis.close();
        }
        return false;
    }

    /**
     * 
     * @Title: set   
     * @Description: TODO(设置数据)   
     * @param: @param key
     * @param: @param value      
     * @return: void      
     * @throws
     */
    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            logger.error("set", e);
        } finally {
            if (null != jedis)
                jedis.close();
        }
    }

    /**
     * 
     * @Title: del   
     * @Description: TODO(删除数据)   
     * @param: @param key
     * @param: @return      
     * @return: Long      
     * @throws
     */
    public Long del(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.del(key);
        } catch (Exception e) {
            logger.error("set", e);
        } finally {
            if (null != jedis)
                jedis.close();
        }
        return null;
    }

    /**
     * setex
     */
    public void setex(String key, int seconds, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.setex(key, seconds, value);
        } catch (Exception e) {
            logger.error("setex", e);
        } finally {
            if (null != jedis)
                jedis.close();
        }
    }

    /**
     * 获取数据
     */
    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } catch (Exception e) {
            logger.error("get", e);
        } finally {
            if (null != jedis)
                jedis.close();
        }
        return null;
    }

    /**
     * 获取自增数据
     */
    public Long incr(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.incr(key);
        } catch (Exception e) {
            logger.error("incr", e);
        } finally {
            if (null != jedis)
                jedis.close();
        }
        return null;
    }

    /**
     * hset
     */
    public Long hset(String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hset(key, field, value);
        } catch (Exception e) {
            logger.error("hset", e);
        } finally {
            if (null != jedis)
                jedis.close();
        }
        return null;
    }

    /**
     * hget
     */
    public String hget(String key, String field) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hget(key, field);
        } catch (Exception e) {
            logger.error("hset", e);
        } finally {
            if (null != jedis)
                jedis.close();
        }
        return null;
    }
    /**
     * hdel
     */
    public Long hdel(String key, String... field) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hdel(key, field);
        } catch (Exception e) {
            logger.error("hset", e);
        } finally {
            if (null != jedis)
                jedis.close();
        }
        return null;
    }

    /**
     * 不存在时更新
     */
    public Long hsetnx(String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hsetnx(key, field, value);
        } catch (Exception e) {
            logger.error("hsetnx", e);
        } finally {
            if (null != jedis)
                jedis.close();
        }
        return null;
    }




}
