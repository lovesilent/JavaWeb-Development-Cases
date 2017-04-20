package com.wyln.webset.web.session;

import java.io.Serializable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wyln.webset.web.Constants;

/**
 * 
 * @ClassName: HttpSessionProvider
 * @Description: 本地Session实现类
 * @author Tommy
 * @date 2017年3月12日
 */
public class HttpSessionProvider implements SessionProvider {

	@Override
	public void setAttribute(HttpServletRequest request, String name, Serializable value) {
		HttpSession session = request.getSession();//通过Cookie中JSESSIONID  判断 如果有就拿出来用，没有就创建
		session.setAttribute(name, value);
	}

	@Override
	public Serializable getAttribute(HttpServletRequest request, String name) {
		HttpSession session = request.getSession(false);//有就给，没有就直接null（不创建）
		if(session != null){
			return (Serializable) session.getAttribute(name);
		}
		return null;
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);//有就给，没有就直接null（不创建）
		if(session != null){
			session.invalidate();
		}
		//将Cookie中JSESSIONID也清理 也可以不管
		Cookie c  = new Cookie(Constants.SESSION_ID,null);
		c.setMaxAge(0);
		response.addCookie(c);
	}

	@Override
	public String getSessionId(HttpServletRequest request) {
		//request.getRequestedSessionId(); 只能获取URL上的JSESSIONID
		return request.getSession().getId();
	}

}
