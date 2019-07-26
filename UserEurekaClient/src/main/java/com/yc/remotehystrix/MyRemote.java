package com.yc.remotehystrix;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "service-email",fallback = RemoteHystrix.class)//对应到的server端的spring.application.name
public interface MyRemote {	
	
    @RequestMapping(value = "sendEmailtoReg.action")
    public boolean sendEmail(@RequestParam("code") int code,@RequestParam("email") String email);
    
}
