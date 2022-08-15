package com.search.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class RedisServiceMapImpl implements RedisServiceMap{

    private static final Logger logger =  LogManager.getLogger(RedisServiceMap.class);;

    @Value("${redis.server.port}")
    private String redisPort;

    @Value("${redis.host.url}")
    private String redisHost;

    private JedisPool jedisPool;

    @PostConstruct
    public void init() {
        logger.info("Port ::"+redisPort);
        logger.info("host ::"+redisHost);
        this.jedisPool = new JedisPool(new JedisPoolConfigUtil().getPoolConfig(), redisHost, Integer.parseInt(redisPort));
    }

    public List<String> getQueue(String queue) {
        try (Jedis jedis = jedisPool.getResource()) {
            if (queue != null) {
                return jedis.lrange(queue, -0,-1);
            } else {
                logger.debug("Redis popFromQueue :: cannot pass null value");
            }
        } catch (JedisConnectionException ex) {
            logger.error("Redis server connection exception " + ex);
        } catch (Exception e) {
            logger.error("Redis exception: " + e);
        }
        return new ArrayList<>();
    }

    @Override
    public void pushIntoQueue(String queue, String item) {
        try (Jedis jedis = jedisPool.getResource()) {
            if (queue != null) {
                Long pushed = jedis.lpush(queue, item);
                if (pushed > 0) {
                    logger.debug("Successfully inserted item " + item + " in list " + queue);
                } else {
                    logger.debug("Item " + item + " already in list " + queue);
                }
            } else {
                logger.debug("Redis pushIntoQueue :: cannot pass null value");
            }
        } catch (JedisConnectionException ex) {
            logger.error("Redis server connection exception " + ex);
        } catch (Exception e) {
            logger.error("Redis exception: " + e);
        }
    }

    @Override
    public String popFromQueue(String queue) {
        try (Jedis jedis = jedisPool.getResource()) {
            if (queue != null) {
                return jedis.rpop(queue);
            } else {
                logger.debug("Redis popFromQueue :: cannot pass null value");
            }
        } catch (JedisConnectionException ex) {
            logger.error("Redis server connection exception " + ex);
        } catch (Exception e) {
            logger.error("Redis exception: " + e);
        }
        return null;
    }

    @Override
    public String peekFromQueue(String queue) {
        try (Jedis jedis = jedisPool.getResource()) {
            if (queue != null) {
                return jedis.lindex(queue, -1);
            } else {
                logger.debug("Redis popFromQueue :: cannot pass null value");
            }
        } catch (JedisConnectionException ex) {
            logger.error("Redis server connection exception " + ex);
        } catch (Exception e) {
            logger.error("Redis exception: " + e);
        }
        return null;
    }

    public void rightPushIntoQueue(String queue, String item)
    {
        try (Jedis jedis = jedisPool.getResource()) {
            if (queue != null) {
                Long pushed = jedis.rpush(queue, item);
                if (pushed > 0) {
                    logger.debug("Successfully inserted item " + item + " in list " + queue);
                } else {
                    logger.debug("Item " + item + " already in list " + queue);
                }
            } else {
                logger.debug("Redis pushIntoQueue :: cannot pass null value");
            }
        } catch (JedisConnectionException ex) {
            logger.error("Redis server connection exception " + ex);
        } catch (Exception e) {
            logger.error("Redis exception: " + e);
        }
    }
}
