package com.wyln.webset.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyln.webset.bean.Category;
import com.wyln.webset.bean.Item;
import com.wyln.webset.mapper.CategoryMapper;
import com.wyln.webset.mapper.ItemMapper;
import com.wyln.webset.mapper.PictureMapper;
import com.wyln.webset.service.CategoryService;

/**
 * 
 * @ClassName: CategoryServiceImpl
 * @Description: Category事务实现
 * @author Tommy
 * @date 2017年3月1日
 */

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private PictureMapper pictureMapper;
	
	@Override
	public Long addCategory(Category category) {
		return categoryMapper.addCategory(category);
	}

	@Override
	public Long updateCategory(Category category) {
		return categoryMapper.updateCategory(category);
	}

	@Override
	public Long deleteByKey(Long id) {
		//先找到items
		List<Long> ids = new ArrayList<Long>();
		List<Item> items = itemMapper.getItemByCid(id);
		if(!items.isEmpty()){
			for (Item item : items) {
				ids.add(item.getId());
			}
			if(!ids.isEmpty()){
				pictureMapper.deleteByIids(ids);
			}
			itemMapper.deleteByCid(id);
		}
		return categoryMapper.deleteByKey(id);
	}

	@Override
	public Long deleteByKeys(List<Long> ids) {
		//先删除item,而且item中都是空的
		itemMapper.deleteByCids(ids);
		return categoryMapper.deleteByKeys(ids);
	}

	@Override
	public Category getCategoryByKey(Long id) {
		return categoryMapper.getCategoryByKey(id);
	}

	@Override
	public Category getCategorysByKeys(List<Long> ids) {
		return categoryMapper.getCategorysByKeys(ids);
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryMapper.getCategoryList();
	}

	@Override
	public List<Category> getCategoryLimit() {
		return categoryMapper.getCategoryLimit();
	}

}
