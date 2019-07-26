package com.yc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //Spring Boot核心注解，用于开启自动配置
@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE) //配置session存储后立刻刷新设置刷新模式为立刻刷新，否则可能获取不到session。
@EnableEurekaClient
@RestController
@EnableFeignClients
public class UserEurekaClient {
	
	public static void main(String[] args) {
        SpringApplication.run(UserEurekaClient.class, args);
    }  
	
	@Bean
	public JedisConnectionFactory connectionFactory() {
	        return new JedisConnectionFactory();
	}
}
