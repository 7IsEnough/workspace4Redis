package com.clearlove;

import redis.clients.jedis.Jedis;

public class TestPing {

  public static void main(String[] args) {
    // 1. new Jedis对象即可
    Jedis jedis = new Jedis("127.0.0.1", 6379);
    // jedis 所有的命令就是之前所有的指令
    System.out.println(jedis.ping());
  }
}
