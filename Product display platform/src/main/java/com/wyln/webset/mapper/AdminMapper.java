package com.wyln.webset.mapper;

import java.util.List;

import com.wyln.webset.bean.Admin;


/**
 * 
 * @ClassName: AdminMapper
 * @Description: Admin的映射类
 * @author Tommy
 * @date 2017年3月13日
 */
public interface AdminMapper {
	Long addAdmin(Admin admin);
	Long updateAdmin(Admin admin);
	Long deleteByKey(String id);
	Long deleteByKeys(List<String> ids); 
	Admin getAdminByKey(String id);
	Admin getAdminsByKeys(List<String> ids); 
}
