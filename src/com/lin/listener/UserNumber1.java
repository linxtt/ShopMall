package com.lin.listener;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserNumber1 implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		// TODO Auto-generated method stub
		HttpSession session = httpSessionEvent.getSession();
		ServletContext sc = session.getServletContext();
		int count = (int) sc.getAttribute("count");
		count++;
		sc.setAttribute("count", count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		// TODO Auto-generated method stub
		HttpSession session = httpSessionEvent.getSession();
		ServletContext sc = session.getServletContext();
		int count = (int) sc.getAttribute("count");
		count--;
		sc.setAttribute("count", count);
	}

}
