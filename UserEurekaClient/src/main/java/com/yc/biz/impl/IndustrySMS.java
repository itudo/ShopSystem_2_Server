package com.yc.biz.impl;

import java.net.URLEncoder;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;

	/**
	 * 验证码通知短信
	 */
	public static void execute(String code,String sendTo)
	{
		String smsContent = "【轻松购】尊敬的用户，您正在轻松购APP进行注册，验证码为"+code+"，请尽快完成验证。如非本人操作，请忽略。";
		//String smsContent = "【兼职通讯】您的验证码为"+code+"，请于"+code+"分钟内正确输入，如非本人操作，请忽略此短信。";
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + sendTo + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	}
}
