package com.yc.mail;
 
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;





import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service; 
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.yc.mail.SendMailService;

import freemarker.template.Template;


@Service
@Slf4j
public class SendMailServiceImpl implements SendMailService{
 
	@Autowired
	JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
    private String from;
 
	/**
	 * 
	 * @Description:普通文本发邮件形式
	 * @param subject 主题
	 * @param content 正文
	 * @param toMail 收件人邮箱
	 * void
	 * @exception:
	 * @author: fengjk
	 * @time:2017年4月20日 下午8:06:05
	 */
	@Override
	public void sendSimpleMail(String subject,String content,String toMail) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(toMail);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
            log.info("简单邮件已经发送。");
        } catch (Exception e) {
            log.error("发送简单邮件时发生异常！", e);
        }
	}
	
	/**
	 * 
	 * @Description:html发邮件形式
	 * @param subject 主题
	 * @param content 正文
	 * @param toMail 收件人邮箱
	 * void
	 * @exception:
	 * @author: fengjk
	 * @time:2017年4月20日 下午8:06:38
	 */
	@Override
	public void sendHtmlMail(String subject,String content,String toMail) {
		MimeMessage message = mailSender.createMimeMessage();

	    try {
	        //true表示需要创建一个multipart message
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(from);
	        helper.setTo(toMail);
	        helper.setSubject(subject);
	        helper.setText(content, true);

	        mailSender.send(message);
	        log.info("html邮件发送成功");
	    } catch (MessagingException e) {
	        log.error("发送html邮件时发生异常！", e);
	    }
	}
	
	/**
	 * 
	 * @Description: 带静态资源发邮件形式
	 * @param subject 主题
	 * @param content 正文
	 * @param toMail 收件人邮箱
	 * @param picturePath 图片路径
	 * 添加多个图片可以使用多条 <img src='cid:" + rscId + "' > 和 helper.addInline(rscId, res) 来实现
	 * @exception:
	 * @author: fengjk
	 * @time:2017年4月20日 下午8:05:40
	 */
	@Override
	public void sendInlineResourceMail(String subject, String content,String toMail, String rscPath, String rscId){
	    MimeMessage message = mailSender.createMimeMessage();

	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(from);
	        helper.setTo(toMail);
	        helper.setSubject(subject);
	        helper.setText(content, true);

	        FileSystemResource res = new FileSystemResource(new File(rscPath));
	        helper.addInline(rscId, res);

	        mailSender.send(message);
	        log.info("嵌入静态资源的邮件已经发送。");
	    } catch (MessagingException e) {
	        log.error("发送嵌入静态资源的邮件时发生异常！", e);
	    }
	}
	
	/**
	 * 
	 * @Description:带附件发邮件形式
	 * @param subject 标题
	 * @param content 正文
	 * @param toMail 收件人邮箱
	 * @param accessoryPath 附件路径
	 * @param accessoryName 附件名
	 * void
	 * @exception:
	 * @author: fengjk
	 * @time:2017年4月20日 下午8:05:14
	 */
	@Override
	public void sendMailTakeAccessory(String subject,String content,String toMail,String filePath){
		MimeMessage message = mailSender.createMimeMessage();

	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(from);
	        helper.setTo(toMail);
	        helper.setSubject(subject);
	        helper.setText(content, true);

	        FileSystemResource file = new FileSystemResource(new File(filePath));
	        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
	        helper.addAttachment(fileName, file);

	        mailSender.send(message);
	        log.info("带附件的邮件已经发送。");
	    } catch (MessagingException e) {
	        log.error("发送带附件的邮件时发生异常！", e);
	    }
	}
	

}
