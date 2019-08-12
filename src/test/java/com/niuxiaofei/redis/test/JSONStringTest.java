package com.niuxiaofei.redis.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.niuxiaofei.redis.domain.User;
import com.niuxiaofei.redis.utils.RandomUtil;
import com.niuxiaofei.redis.utils.StringUtil;

/**
 * 
 * @author json形式测试
 *
 */
@ContextConfiguration(locations= {"classpath:spring-beans2.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class JSONStringTest {
	//redis操作的工具
	@Resource
	RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
	/**
	 * 添加方式string 使用json
	 */
	@Test
	public void insert_String() {
		//定义空集合放10万条数据
		List<User> list = new ArrayList<>();
		//循环放入对象到集合
		for (int i = 0; i < 100000; i++) {
			User u = new User(i,StringUtil.generateChineseName()+StringUtil.randomChineseString(2),RandomUtil.randomSex(),"13"+RandomUtil.randomString(9),RandomUtil.randomEmail(RandomUtil.random(3, 20))+RandomUtil.randomCom(),RandomUtil.random(18, 70));
			list.add(u);
		}
		
		//开始加入的时间
		long start = System.currentTimeMillis();
		for (User user : list) {
			redisTemplate.opsForValue().set("user_"+user.getId(),user);
		}
		long end = System.currentTimeMillis();
		System.out.println("输出系列化方式:JSON");
		System.out.println("保存数量:"+list.size());
		System.out.println("耗时:"+(end-start));
	}
}
