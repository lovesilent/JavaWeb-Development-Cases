package com.wyln.webset.service;

import java.util.List;

import com.wyln.webset.bean.Introduction;

/**
 * 
 * @ClassName: IntroductionService
 * @Description: Introduction事务接口
 * @author Tommy
 * @date 2017年3月1日
 */
public interface IntroductionService {
	Long addIntroduction(Introduction introduction);
	Long updateIntroduction(Introduction introduction);
	Long deleteByKey(Long id);
	Long deleteByKeys(List<Long> ids); 
	Introduction getIntroductionByKey(Long id);
	Introduction getIntroductionsByKeys(List<Long> ids); 
}
