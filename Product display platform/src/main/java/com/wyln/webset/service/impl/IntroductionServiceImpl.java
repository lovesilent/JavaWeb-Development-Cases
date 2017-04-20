package com.wyln.webset.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyln.webset.bean.Introduction;
import com.wyln.webset.mapper.IntroductionMapper;
import com.wyln.webset.service.IntroductionService;

/**
 * 
 * @ClassName: IntroductionServiceImpl
 * @Description: Introduction事务实现
 * @author Tommy
 * @date 2017年3月1日
 */

@Service
public class IntroductionServiceImpl implements IntroductionService {

	@Autowired
	private IntroductionMapper introductionMapper;
	
	@Override
	public Long addIntroduction(Introduction introduction) {
		return introductionMapper.addIntroduction(introduction);
	}

	@Override
	public Long updateIntroduction(Introduction introduction) {
		return introductionMapper.updateIntroduction(introduction);
	}

	@Override
	public Long deleteByKey(Long id) {
		return introductionMapper.deleteByKey(id);
	}

	@Override
	public Long deleteByKeys(List<Long> ids) {
		return introductionMapper.deleteByKeys(ids);
	}

	@Override
	public Introduction getIntroductionByKey(Long id) {
		return introductionMapper.getIntroductionByKey(id);
	}

	@Override
	public Introduction getIntroductionsByKeys(List<Long> ids) {
		return introductionMapper.getIntroductionsByKeys(ids);
	}

}
