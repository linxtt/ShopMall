package com.lin.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtil {
	//获取cookie名字
	public static Cookie getCookieName (HttpServletRequest request , String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if(cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		}else {
			return null;
		}
	}
	//将cookie封装到map集合中
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
	//保存cookie
	 public static HttpServletResponse setCookie(HttpServletResponse response, String name, String value,int time) {
	        // new一个Cookie对象,键值对为参数
	        Cookie cookie = new Cookie(name, value);
	        // tomcat下多应用共享
	        cookie.setPath("/");
	        // 如果cookie的值中含有中文时，需要对cookie进行编码，不然会产生乱码
	        try {
	            URLEncoder.encode(value, "utf-8");
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        cookie.setMaxAge(60*60*60);
	        // 将Cookie添加到Response中,使之生效
	        response.addCookie(cookie); // addCookie后，如果已经存在相同名字的cookie，则最新的覆盖旧的cookie
	        return response;
	    }

}
