package com.wyln.webset.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName: SessionProvider
 * @Description: Session供应接口
 * @author Tommy
 * @date 2017年3月12日
 */
public interface SessionProvider {
	/**
	 * 往session里面设置值
	 * @param request  请求
	 * @param name  key值
	 * @param value  用户对象
	 */
	public void setAttribute(HttpServletRequest request ,String name, Serializable value);
	/**
	 * 从session里面取值
	 * @param request
	 * @param name
	 * @return
	 */
	public Serializable getAttribute(HttpServletRequest request ,String name);
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 获取SessionId
	 * @param request
	 * @return
	 */
	public String getSessionId(HttpServletRequest request);
}
