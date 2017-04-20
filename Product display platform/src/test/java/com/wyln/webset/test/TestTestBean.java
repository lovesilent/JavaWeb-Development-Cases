package com.wyln.webset.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wyln.webset.bean.Introduction;
import com.wyln.webset.service.IntroductionService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-framework.xml")
public class TestTestBean  {
	@Autowired
	private IntroductionService introductionService;
	@Test
	public void testAdd() throws Exception {
		Introduction introduction = new Introduction(new Long(1), "美丽的老板娘", "北京朝阳", "199", "XXX", "...", new Date());
		System.out.println(introductionService.addIntroduction(introduction));
	}

}
