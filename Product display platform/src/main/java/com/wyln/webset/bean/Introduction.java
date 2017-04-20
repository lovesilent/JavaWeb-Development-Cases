package com.wyln.webset.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: Introduction
 * @Description: 基本介绍
 * @author Tommy
 * @date 2017年3月1日
 */
public class Introduction implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 主键 **/
	private Long id;
	/** 店家名 **/
	private String name;
	/** 地址 **/
	private String address;
	/** 手机号码 **/
	private String phone;
	/** 微信 **/
	private String wechat;
	/** 详细信息 **/
	private String description;
	/** 创建日期 **/
	private Date date;
	public Introduction(){}
	public Introduction(Long id, String name, String address, String phone, String wechat, String description,
			Date date) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.wechat = wechat;
		this.description = description;
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
