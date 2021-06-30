package com.clearlove;

import com.clearlove.pojo.User;
import com.clearlove.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

  @Autowired
  @Qualifier("redisTemplate")
  private RedisTemplate redisTemplate;

  @Autowired
  private RedisUtil redisUtil;

  @Test
  void contextLoads() {

    // redisTemplate 操作不同的数据类型，api和我们的指令是一样的
    // opsForValue 操作字符串 类似String
    // opsForList  操作List 类似List
    // opsForSet
    // opsForHash
    // opsForZSet
    // opsForGeo
    // opsForHyperLogLog

    // 除了基本的操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务，基本CRUD

    // 获取Redis的连接对象
//    RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//    connection.flushDb();
//    connection.flushAll();

    redisTemplate.opsForValue().set("mykey", "科比布莱恩特");
    System.out.println(redisTemplate.opsForValue().get("mykey"));


  }

  @Test
  public void test() throws JsonProcessingException {
    // 真实的开发一般都使用json来传递对象
    User user = new User("科比", 41);
//    String jsonUser = new ObjectMapper().writeValueAsString(user);
    redisTemplate.opsForValue().set("user", user);
    System.out.println(redisTemplate.opsForValue().get("user"));
  }

  @Test
  public void test1() {
    redisUtil.set("name", "kobe");
    System.out.println(redisUtil.get("name"));
  }

}
