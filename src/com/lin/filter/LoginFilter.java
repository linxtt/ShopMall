package com.lin.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *拦截过滤器
 */
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession();
		String path = httpServletRequest.getRequestURI();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		//判断是否为index.jsp或者login.jsp界面，是的话不进行拦截
		if(path.indexOf("/index.jsp") != -1 ) {
			chain.doFilter(httpServletRequest, httpServletResponse);
			return;
		}
		if(path.indexOf("/login.jsp") != -1 ) {
			chain.doFilter(httpServletRequest, httpServletResponse);
			return;
		}
		if(path.indexOf("/regist.jsp") != -1 ) {
			chain.doFilter(httpServletRequest, httpServletResponse);
			return;
		}
		if(username != null && password != null) {
			//已经登陆的情况下
			chain.doFilter(httpServletRequest, httpServletResponse);
		}else {
			//未登录的情况下
			httpServletResponse.sendRedirect("/ShopMall/jsp/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
