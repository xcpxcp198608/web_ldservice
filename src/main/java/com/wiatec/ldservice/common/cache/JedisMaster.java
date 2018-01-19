package com.wiatec.ldservice.common.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author patrick
 */
public class JedisMaster {

    private final Logger logger = LoggerFactory.getLogger(JedisMaster.class);

    private static JedisCluster jc;

    static {
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7379));
        jc = new JedisCluster(jedisClusterNodes);
    }

    public void set(String key, Object object){
        jc.set(key, (String)object);
    }

    public void get(String key){
        String s = jc.get(key);
    }
}
