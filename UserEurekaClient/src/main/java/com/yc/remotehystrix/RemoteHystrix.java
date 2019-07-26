package com.yc.remotehystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


@Component
public class RemoteHystrix implements MyRemote{

	@Override
	public boolean sendEmail(int code,String email) {
		return false;
	}
    
}
