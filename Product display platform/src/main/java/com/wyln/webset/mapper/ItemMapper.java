package com.wyln.webset.mapper;

import java.util.List;

import com.wyln.webset.bean.Item;

/**
 * 
 * @ClassName: ItemMapper
 * @Description: Item的映射类
 * @author Tommy
 * @date 2017年3月1日
 */
public interface ItemMapper {
	Long addItem(Item item);
	Long updateItem(Item item);
	Long deleteByKey(Long id);
	Long deleteByKeys(List<Long> ids); 
	Long deleteByCid(Long id);
	Long deleteByCids(List<Long> ids); 
	Item getItemByKey(Long id);
	Item getItemsByKeys(List<Long> ids); 
	List<Item> getItemByCid(Long id);
	int getItemsCount(Long id);
	List<Item> getItemsWithPage(Item item);
}
