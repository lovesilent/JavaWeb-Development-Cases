package com.wyln.webset.mapper;

import java.util.List;

import com.wyln.webset.bean.Category;

/**
 * 
 * @ClassName: CategoryMapper
 * @Description: Category的映射类
 * @author Tommy
 * @date 2017年3月1日
 */
public interface CategoryMapper {
	Long addCategory(Category category);
	Long updateCategory(Category category);
	Long deleteByKey(Long id);
	Long deleteByKeys(List<Long> ids); 
	Category getCategoryByKey(Long id);
	Category getCategorysByKeys(List<Long> ids); 
	List<Category> getCategoryList();
	List<Category> getCategoryLimit();
}
