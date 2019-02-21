package com.lin.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtil {
	//��ȡcookie����
	public static Cookie getCookieName (HttpServletRequest request , String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if(cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		}else {
			return null;
		}
	}
	//��cookie��װ��map������
	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[]  cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				cookieMap.put(c.getName(), c);
			}
		}
		return cookieMap;
	}
	//����cookie
	 public static HttpServletResponse setCookie(HttpServletResponse response, String name, String value,int time) {
	        // newһ��Cookie����,��ֵ��Ϊ����
	        Cookie cookie = new Cookie(name, value);
	        // tomcat�¶�Ӧ�ù���
	        cookie.setPath("/");
	        // ���cookie��ֵ�к�������ʱ����Ҫ��cookie���б��룬��Ȼ���������
	        try {
	            URLEncoder.encode(value, "utf-8");
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        cookie.setMaxAge(60*60*60);
	        // ��Cookie��ӵ�Response��,ʹ֮��Ч
	        response.addCookie(cookie); // addCookie������Ѿ�������ͬ���ֵ�cookie�������µĸ��Ǿɵ�cookie
	        return response;
	    }

}
