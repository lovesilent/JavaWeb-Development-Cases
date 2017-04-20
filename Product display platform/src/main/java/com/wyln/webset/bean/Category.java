package com.wyln.webset.bean;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 主键 **/
	private Long id;
	/** 类名 **/
	private String name;
	/** 创建日期 **/
	private Date date;
	public Category(){}
	public Category(Long id, String name, Date date) {
		this.id = id;
		this.name = name;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
