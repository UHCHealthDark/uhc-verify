package io.github.wickeddroid.plugin.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import team.unnamed.inject.Provider;

public class JedisPoolProvider implements Provider<JedisPool> {

  private static final JedisPoolConfig JEDIS_POOL_CONFIG = buildPoolConfig();

  @Override
  public JedisPool get() {
    return new JedisPool(JEDIS_POOL_CONFIG,
            System.getProperty("redis.host"),
            Integer.parseInt(System.getProperty("redis.port")),
            2000,
            System.getProperty("redis.password")
    );
  }

  private static JedisPoolConfig buildPoolConfig() {
    final var jedisPoolConfig = new JedisPoolConfig();
    jedisPoolConfig.setMaxTotal(128);
    jedisPoolConfig.setMaxIdle(128);
    jedisPoolConfig.setMinIdle(16);
    jedisPoolConfig.setTestOnBorrow(true);
    jedisPoolConfig.setTestOnReturn(true);
    jedisPoolConfig.setTestWhileIdle(true);
    jedisPoolConfig.setNumTestsPerEvictionRun(3);
    jedisPoolConfig.setBlockWhenExhausted(true);
    return jedisPoolConfig;
  }
}
