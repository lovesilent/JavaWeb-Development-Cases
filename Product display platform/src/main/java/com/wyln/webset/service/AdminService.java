package com.wyln.webset.service;

import java.util.List;

import com.wyln.webset.bean.Admin;

/**
 * 
 * @ClassName: AdminService
 * @Description: Admin事务接口
 * @author Tommy
 * @date 2017年3月13日
 */
public interface AdminService {
	Long addAdmin(Admin admin);
	Long updateAdmin(Admin admin);
	Long deleteByKey(String id);
	Long deleteByKeys(List<String> ids); 
	Admin getAdminByKey(String id);
	Admin getAdminsByKeys(List<String> ids); 
}
