package com.search.configuration;

import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolConfigUtil {

    private static JedisPoolConfig poolConfig;

    public JedisPoolConfigUtil() {
        poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
    }

    public JedisPoolConfig getPoolConfig() {
        return poolConfig;
    }
}
