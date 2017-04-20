package com.wyln.webset.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyln.webset.bean.Item;
import com.wyln.webset.mapper.ItemMapper;
import com.wyln.webset.mapper.PictureMapper;
import com.wyln.webset.service.ItemService;

import cn.itcast.common.page.Pagination;

/**
 * 
 * @ClassName: ItemServiceImpl
 * @Description: Item事务实现
 * @author Tommy
 * @date 2017年3月1日
 */

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private PictureMapper pictureMapper;

	@Override
	public Long addItem(Item item) {
		return itemMapper.addItem(item);
	}

	@Override
	public Long updateItem(Item item) {
		return itemMapper.updateItem(item);
	}

	@Override
	public Long deleteByKey(Long id) {
		// 先删除picture
		pictureMapper.deleteByIid(id);
		return itemMapper.deleteByKey(id);
	}

	@Override
	public Long deleteByKeys(List<Long> ids) {
		// 先删除picture
		pictureMapper.deleteByIids(ids);
		return itemMapper.deleteByKeys(ids);
	}

	@Override
	public Item getItemByKey(Long id) {
		return itemMapper.getItemByKey(id);
	}

	@Override
	public Item getItemsByKeys(List<Long> ids) {
		return itemMapper.getItemsByKeys(ids);
	}

	@Override
	public List<Item> getItemByCid(Long id) {
		return itemMapper.getItemByCid(id);
	}

	@Override
	public Pagination getItemsWithPage(Item item) {
		Pagination p = new Pagination(item.getPageNo(), item.getPageSize(),
				itemMapper.getItemsCount(item.getCategoryId()));
		List<Item> items = itemMapper.getItemsWithPage(item);
		//遍历商品,添加默认Url
		for (Item item2 : items) {
			item2.setPicurl(pictureMapper.getPictureDefault(new Long(item2.getId())).getAllUrl());
		}
		p.setList(items);
		return p;
	}

}
