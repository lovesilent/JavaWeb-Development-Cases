package com.wyln.webset.service;

import java.util.List;

import com.wyln.webset.bean.Category;

/**
 * 
 * @ClassName: CategoryService
 * @Description: Category事务接口
 * @author Tommy
 * @date 2017年3月1日
 */
public interface CategoryService {
	Long addCategory(Category category);
	Long updateCategory(Category category);
	Long deleteByKey(Long id);
	Long deleteByKeys(List<Long> ids); 
	Category getCategoryByKey(Long id);
	Category getCategorysByKeys(List<Long> ids); 
	List<Category> getCategoryList();
	List<Category> getCategoryLimit();
}
