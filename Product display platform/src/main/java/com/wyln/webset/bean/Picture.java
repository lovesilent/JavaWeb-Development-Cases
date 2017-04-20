package com.wyln.webset.bean;

import java.io.Serializable;

import com.wyln.webset.web.Constants;


/**
 * 
 * @ClassName: Picture
 * @Description: 存放图片信息
 * @author Tommy
 * @date 2017年3月1日
 */
public class Picture implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 主键 **/
	private Long id;
	/** 商品id **/
	private Long itemId;
	/** 名字 **/
	private String name;
	/** 路径 **/
	private String url;
	/** 添加日期 **/
	private boolean isDef;

	public Picture() {
	}

	public Picture(Long id, Long itemId, String name, String url, boolean isDef) {
		this.id = id;
		this.itemId = itemId;
		this.name = name;
		this.url = url;
		this.isDef = isDef;
	}

	// 获取全路径
	public String getAllUrl() {
		return Constants.IMAGE_URL + url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isDef() {
		return isDef;
	}

	public void setDef(boolean isDef) {
		this.isDef = isDef;
	}

}
