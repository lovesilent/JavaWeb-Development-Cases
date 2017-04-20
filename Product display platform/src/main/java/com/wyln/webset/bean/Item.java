package com.wyln.webset.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @ClassName: Item
 * @Description: 用来表示每一个商品的POJO
 * @author Tommy
 * @date 2017年2月28日
 */
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 主键 **/
	private Long id;
	/** 类别id **/
	private Long categoryId;
	/** 商品名 **/
	private String name;
	/** 价格 **/
	private String price;
	/** 描述 **/
	private String description;
	/** 创建日期 **/
	private Date date;
	/** 保存默认图片url **/
	private String picurl;

	public Item() {
	}

	public Item(Long id, Long categoryId, String name, String price, String description, Date date) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	/** ------------定义分页------------ **/
	// 定义常量 每页数
	public final static int DEFAULT_SIZE = 8;
	// 每页数
	protected int pageSize = DEFAULT_SIZE;
	// 起始行
	protected int startRow;// 起始行
	// 页码
	protected int pageNo = 1;
	// Sql查询字段
	protected String fields;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		this.startRow = (pageNo - 1) * this.pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public Item setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.startRow = (pageNo - 1) * this.pageSize;
		return this;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
}
