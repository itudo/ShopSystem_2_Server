package com.yc.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.yc.bean.Users;

@Component
@Slf4j
public class MyFilter extends ZuulFilter{

	 /**
     * 过滤器类型
     * pre 事前
     * routing 路由请求时候调用
     * error 发生错误时候调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    //filterOrder：过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否过来
     * 0 不过滤
     * 1 过滤
     * 这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     * @return
     */
    @Override
    public boolean shouldFilter() {
    	 RequestContext ctx = RequestContext.getCurrentContext();
         HttpServletRequest request = ctx.getRequest();
         String uri = request.getRequestURI().toString();
         if(uri.endsWith(".jsp")) {
        	 return true;
         }
         return false;
    }

    //run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI().toString();
        if(uri.contains("/user/")) {
        	Users user = (Users) request.getSession().getAttribute("user");
        	if(user==null) {
        		log.info("user is not login");
        		ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(500);
                ctx.setResponseBody("{\"result\":\"first to loginning!!\"}");
                return null;
        	}
        } else if(uri.contains("/admin/")) {
        	return null;
        }
		return null;
    }
}

