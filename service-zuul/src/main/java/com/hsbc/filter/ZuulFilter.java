package com.hsbc.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import ch.qos.logback.classic.Logger;
import io.netty.util.internal.StringUtil;
@Component
public class ZuulFilter extends com.netflix.zuul.ZuulFilter {
	
	private static Logger log = (Logger) LoggerFactory.getLogger(ZuulFilter.class);
	
	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		log.debug("request value:" + request.getMethod() + "request URl:" + request.getRequestURL());
		
		String token = request.getParameter("token");
		if(StringUtil.isNullOrEmpty(token)) {
			log.warn("token is not empty");
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			try {
				context.getResponse().getWriter().write("token is not empty");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log.debug("it is ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
