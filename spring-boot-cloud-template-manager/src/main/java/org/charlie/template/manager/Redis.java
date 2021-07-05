package org.charlie.template.manager;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

public class Redis {

    public static void main(String[] args) {
        Jedis jedis = new Jedis(new HostAndPort("localhost", 6379));
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
        jedis.
    }
}
