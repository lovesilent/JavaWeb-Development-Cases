package com.wyln.webset.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wyln.webset.bean.Admin;
import com.wyln.webset.service.AdminService;
import com.wyln.webset.web.Constants;
import com.wyln.webset.web.session.SessionProvider;

/**
 * 
 * @ClassName: CenterController
 * @Description: 后台管理
 * @author Tommy
 * @date 2017年3月11日
 */
@Controller
@RequestMapping(value = "/login")
public class CenterController {
	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private AdminService adminService;

	// 管理登陆
	// GET方式提交
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// POST方式提交
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(Admin admin, ModelMap model, HttpServletRequest request) {
		// 验证码是否为空
		if (null != admin && StringUtils.isNotBlank(admin.getUsername())) {
			if (StringUtils.isNotBlank(admin.getPassword())) {
				Admin a = adminService.getAdminByKey(admin.getUsername());
				if (null != a) {
					if (a.getPassword().equals(admin.getPassword())) {
						// 把用户对象放在session中
						sessionProvider.setAttribute(request, Constants.ADMIN_SESSION, a);
						return "redirect:/admin/index.do";
					} else {
						model.addAttribute("error", "密码错误");
					}
				} else {
					model.addAttribute("error", "用户名输入错误");
				}
			} else {
				model.addAttribute("error", "请输入密码");
			}
		} else {
			model.addAttribute("error", "请输入用户名");
		}
		return "login";
	}

	// 退出登陆
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		sessionProvider.logout(request, response);
		return "login";
	}
}
