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
 *���ع�����
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
		//�ж��Ƿ�Ϊindex.jsp����login.jsp���棬�ǵĻ�����������
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
			//�Ѿ���½�������
			chain.doFilter(httpServletRequest, httpServletResponse);
		}else {
			//δ��¼�������
			httpServletResponse.sendRedirect("/ShopMall/jsp/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
