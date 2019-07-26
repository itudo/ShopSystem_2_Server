package com.yc.freemaker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service("freeMarkerServiceImpl")
public class FreeMarkerServictImpl<T> implements FreeMarkerService {

	@Override
	public void getHtml(Map<String,Object> map, String tempName, String htmlName) {
		//第一步：实例化Freemarker的配置类
        Configuration conf = new Configuration();
        //第二步：给配置类设置路径
        String sys = System.getProperty("user.dir");
        String dir = sys+"\\freeMarker\\";

        try {
			conf.setDirectoryForTemplateLoading(new File(dir));
			Template template = conf.getTemplate(tempName);
			//第三步：处理模板及数据之间将数据与模板合成一个HTML
			//第四步：输出html
			Writer out = new FileWriter(new File(dir+htmlName));
			Map<String,Object> root = new HashMap<String,Object>();
			if(map!=null&&map.size()>0) {
				for(String key:map.keySet()) {
					Object t = map.get(key);
					root.put(key, t);
				}
			}
			template.process(root, out);
			System.out.println("模板生成！！！");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
