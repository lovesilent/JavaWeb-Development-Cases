package com.wyln.webset.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyln.webset.bean.Admin;
import com.wyln.webset.mapper.AdminMapper;
import com.wyln.webset.service.AdminService;

/**
 * 
 * @ClassName: AdminServiceImpl
 * @Description: Admin事务实现
 * @author Tommy
 * @date 2017年3月13日
 */

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Long addAdmin(Admin admin) {
		return adminMapper.addAdmin(admin);
	}

	@Override
	public Long updateAdmin(Admin admin) {
		return adminMapper.updateAdmin(admin);
	}

	@Override
	public Long deleteByKey(String id) {
		return adminMapper.deleteByKey(id);
	}

	@Override
	public Long deleteByKeys(List<String> ids) {
		return adminMapper.deleteByKeys(ids);
	}

	@Override
	public Admin getAdminByKey(String id) {
		return adminMapper.getAdminByKey(id);
	}

	@Override
	public Admin getAdminsByKeys(List<String> ids) {
		return adminMapper.getAdminsByKeys(ids);
	}

}
