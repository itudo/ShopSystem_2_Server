package com.yc.mail;

import java.util.Map;

public interface SendMailService {

	void sendSimpleMail(String subject, String content, String toMail);

	void sendHtmlMail(String subject, String content, String toMail);

	void sendMailTakeAccessory(String subject, String content, String toMail,String filePath);

	void sendInlineResourceMail(String subject, String content, String toMail,
			String rscPath, String rscId);
	
}
