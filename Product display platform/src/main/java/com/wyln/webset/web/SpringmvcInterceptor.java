package com.wyln.webset.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wyln.webset.bean.Admin;
import com.wyln.webset.web.Constants;
import com.wyln.webset.web.session.SessionProvider;

/**
 * 
 * @ClassName: SpringmvcInterceptor
 * @Description: 处理上下文，处理Session全局
 * @author Tommy
 * @date 2017年3月12日
 */
public class SpringmvcInterceptor implements HandlerInterceptor {

	@Autowired
	private SessionProvider sessionProver;
	private static final String INTERCEPTOR_URL = "/webset/admin/";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Admin admin = (Admin) sessionProver.getAttribute(request, Constants.ADMIN_SESSION);
		boolean flag = false;
		if (null != admin) {
			flag = true;
		}
		request.setAttribute("isLogin", flag);
		// 是否拦截
		String requestURI = request.getRequestURI();
		if (requestURI.startsWith(INTERCEPTOR_URL)) {
			// 必须验证是否登录
			if (null == admin) {
				response.sendRedirect("/webset/login/login.do");
				return false;
			}
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

}
