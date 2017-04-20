package com.wyln.webset.bean;

import java.io.Serializable;

/**
 * 
 * @ClassName: Admin
 * @Description: 管理员账号密码
 * @author Tommy
 * @date 2017年3月12日
 */
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	public Admin(){}
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
