/**
 * @filename CookieUtil.java
 */
package com.maogousoft.wuliuweb.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maogousoft.wuliuweb.domain.Constant;

/**
 * @description 
 * @author shevliu
 * @email shevliu@gmail.com
 * Apr 5, 2013 11:00:48 PM
 */
public class CookieUtil {

	/**
	 * 
	 * @description 增加cookie 
	 * @author shevliu
	 * @email shevliu@gmail.com
	 * Apr 5, 2013 11:06:06 PM
	 * @param response
	 * @param name
	 * @param value
	 */
	public static void addCookie(HttpServletResponse response , String name,String value){
	    Cookie cookie = new Cookie(name,value);
	    cookie.setPath("/");
	    response.addCookie(cookie);
	}
	
	/**
	 * 
	 * @description 增加cookie 
	 * @author shevliu
	 * @email shevliu@gmail.com
	 * Jun 14, 2013 5:43:41 PM
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 */
	public static void addCookie(HttpServletResponse response , String name,String value , int maxAge){
		Cookie cookie = new Cookie(name,value);
		cookie.setPath("/");
		 cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
	
	/**
	 * 获取cookie
	 */
	public static String getCookie(HttpServletRequest request ,String name) {
		Cookie[] cookies = request.getCookies();
		String value= "";
		if (cookies != null) {
			for (Cookie cookie:cookies) {
				if(cookie.getName().equalsIgnoreCase(name)) {
					value=cookie.getValue();
				}
			}
		}
		return value;
	}
	
	/**
	 * 清空cookie
	 * @param request
	 * @param response
	 * @param path cookie路径
	 */
	public static void clearCookie(HttpServletRequest request ,HttpServletResponse response ,String path){
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie c : cookies){
				if(c.getName().equals(Constant.COOKIE_LOGIN_PHONE)){
					continue;
				}
				c.setPath(path);
				c.setValue(null);
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
	}
	
	/**
	 * 清空cookie,默认path为/
	 * @param request
	 * @param response
	 * @param name cookie名称
	 * @param value cookie值
	 */
	public static void clearCookie(HttpServletRequest request ,HttpServletResponse response ){
		clearCookie(request, response , "/");
	}
}
