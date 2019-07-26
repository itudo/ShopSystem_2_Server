package com.yc.freemaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

@Component
public class DataBaseBizImpl implements DataBaseBiz{

	@Override
	public String readFile(String path) {
		StringBuffer sb = new StringBuffer();
	    File file = new File(path);
		try {
		    if (file.isFile() && file.exists()) { //判断文件是否存在
		        InputStreamReader read = new InputStreamReader(new FileInputStream(file), "utf-8");//考虑到编码格式
		        BufferedReader bufferedReader = new BufferedReader(read);
		        String lineTxt = null;
		        while ((lineTxt = bufferedReader.readLine()) != null) {
		               //System.out.println(lineTxt);         
		        	sb.append(lineTxt);
		         }       
		        read.close();
		    } else {
		        System.out.println("找不到指定的文件");
		        return null;
		    }
		} catch (Exception e) {
		    System.out.println("读取文件内容出错");
		    e.printStackTrace();
		}
		return sb.toString();
	}

}
