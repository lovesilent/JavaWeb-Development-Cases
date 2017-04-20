package com.wyln.webset.mapper;

import java.util.List;

import com.wyln.webset.bean.Introduction;

/**
 * 
 * @ClassName: IntroductionMapper
 * @Description: Introduction映射类
 * @author Tommy
 * @date 2017年3月1日
 */
public interface IntroductionMapper {
	Long addIntroduction(Introduction introduction);
	Long updateIntroduction(Introduction introduction);
	Long deleteByKey(Long id);
	Long deleteByKeys(List<Long> ids); 
	Introduction getIntroductionByKey(Long id);
	Introduction getIntroductionsByKeys(List<Long> ids); 
}
