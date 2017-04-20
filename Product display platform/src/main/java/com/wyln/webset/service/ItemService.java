package com.wyln.webset.service;

import java.util.List;

import com.wyln.webset.bean.Item;

import cn.itcast.common.page.Pagination;

/**
 * 
 * @ClassName: ItemService
 * @Description: Item事务接口
 * @author Tommy
 * @date 2017年3月1日
 */
public interface ItemService {
	Long addItem(Item item);
	Long updateItem(Item item);
	Long deleteByKey(Long id);
	Long deleteByKeys(List<Long> ids); 
	Item getItemByKey(Long id);
	Item getItemsByKeys(List<Long> ids); 
	List<Item> getItemByCid(Long id);
	Pagination getItemsWithPage(Item item);
}
