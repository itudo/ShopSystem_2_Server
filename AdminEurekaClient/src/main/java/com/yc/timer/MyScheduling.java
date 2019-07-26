package com.yc.timer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

//@Configuration          //证明这个类是一个配置文件
//@EnableScheduling       //打开quartz定时器总开关
public class MyScheduling  {

	 @Scheduled(cron = "0/2 * * * * *")
	    public void timer(){
	        //获取当前时间
	        LocalDateTime localDateTime =LocalDateTime.now();
	        System.out.println("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	    }
}
