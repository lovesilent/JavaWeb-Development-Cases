package com.wyln.webset.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyln.webset.bean.Category;
import com.wyln.webset.bean.Introduction;
import com.wyln.webset.bean.Item;
import com.wyln.webset.bean.Picture;
import com.wyln.webset.service.CategoryService;
import com.wyln.webset.service.IntroductionService;
import com.wyln.webset.service.ItemService;
import com.wyln.webset.service.PictureService;
import com.wyln.webset.web.ResponseUtils;

import cn.itcast.common.page.Pagination;

/**
 * 
 * @ClassName: ShowController
 * @Description: 处理前台控制器
 * @author Tommy
 * @date 2017年3月15日
 */
@Controller
@RequestMapping(value = "/show")
public class ShowController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private IntroductionService introductionService;

	@RequestMapping(value = "/index.shtml")
	public String index(ModelMap model) {
		List<Category> categorys = categoryService.getCategoryLimit();
		model.addAttribute("categorys", categorys);
		int count = 0;// 计数
		for (Category category : categorys) {
			// 新建Item分页查询对象
			Item item = new Item();
			item.setCategoryId(category.getId());
			// 设置页号
			item.setPageNo(Pagination.cpn(1));
			// 每页数
			item.setPageSize(4);
			// 分页对象
			Pagination pagination = itemService.getItemsWithPage(item);
			model.addAttribute("items_" + count, pagination.getList());
			count++;
		}
		return "index";
	}

	@RequestMapping(value = "/findMore.shtml")
	public void findMore(String cid, String pageNum, HttpServletResponse response) {
		// 新建Item分页查询对象
		Item item = new Item();
		item.setCategoryId(new Long(cid));
		// 设置页号
		item.setPageNo(Pagination.cpn(Integer.parseInt(pageNum)));
		// 每页数
		item.setPageSize(4);
		// 分页对象
		Pagination pagination = itemService.getItemsWithPage(item);
		List<String> urls = new ArrayList<String>();
		for (Item item2 : (List<Item>) pagination.getList()) {
			urls.add(item2.getPicurl());
		}
		// 返回数据 异步返回
		JSONObject jo = new JSONObject();
		jo.put("urls", urls);
		ResponseUtils.senderJson(response, jo.toString());
	}

	@RequestMapping(value = "/case.shtml")
	public String showCase(String cid, Integer pageNo, ModelMap model) {
		List<Category> categorys = categoryService.getCategoryList();
		model.addAttribute("categorys", categorys);
		// 新建Item分页查询对象
		Item item = new Item();
		if(null == cid){
			cid = categorys.get(0).getId().toString();
		}
		item.setCategoryId(new Long(cid));
		// 分页参数
		StringBuilder params = new StringBuilder();
		params.append("&").append("cid=").append(cid);
		// 设置页号
		item.setPageNo(Pagination.cpn(pageNo));
		// 分页对象
		Pagination pagination = itemService.getItemsWithPage(item);
		// 分页展示
		String url = "/webset/show/case.shtml";
		pagination.pageView(url, params.toString());
		model.addAttribute("pagination", pagination);
		model.addAttribute("cid", cid);
		return "case";
	}
	
	@RequestMapping(value="/detail.shtml")
	public String detail(String iid, ModelMap model){
		Item item = itemService.getItemByKey(new Long(iid));
		List<Picture> pics = pictureService.getPictureByIid(new Long(iid));
		model.addAttribute("item", item);
		model.addAttribute("pics", pics);
		return "case_detail";
	}
	
	@RequestMapping(value="/contact.shtml")
	public String contact(ModelMap model){
		Introduction introduction = introductionService.getIntroductionByKey(new Long(1));
		model.addAttribute("in", introduction);
		return "contact";
	}
}
