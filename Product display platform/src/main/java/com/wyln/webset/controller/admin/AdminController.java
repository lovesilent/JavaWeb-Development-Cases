package com.wyln.webset.controller.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyln.webset.bean.Admin;
import com.wyln.webset.bean.Category;
import com.wyln.webset.bean.Introduction;
import com.wyln.webset.bean.Item;
import com.wyln.webset.bean.Picture;
import com.wyln.webset.service.AdminService;
import com.wyln.webset.service.CategoryService;
import com.wyln.webset.service.IntroductionService;
import com.wyln.webset.service.ItemService;
import com.wyln.webset.service.PictureService;
import com.wyln.webset.service.impl.AdminServiceImpl;
import com.wyln.webset.service.impl.CategoryServiceImpl;
import com.wyln.webset.service.impl.IntroductionServiceImpl;
import com.wyln.webset.service.impl.ItemServiceImpl;
import com.wyln.webset.service.impl.PictureServiceImpl;
import com.wyln.webset.web.Constants;
import com.wyln.webset.web.ResponseUtils;
import com.wyln.webset.web.session.HttpSessionProvider;
import com.wyln.webset.web.session.SessionProvider;

import cn.itcast.common.page.Pagination;

/**
 * 
 * @ClassName: AdminController
 * @Description: Admin管理
 * @author Tommy
 * @date 2017年3月12日
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	SessionProvider sessionProvider = new HttpSessionProvider();
	@Autowired
	CategoryService categoryService = new CategoryServiceImpl();
	@Autowired
	IntroductionService introductionService = new IntroductionServiceImpl();
	@Autowired
	AdminService adminService = new AdminServiceImpl();
	@Autowired
	ItemService itemService = new ItemServiceImpl();
	@Autowired
	PictureService pictureService = new PictureServiceImpl();

	// 跳转入口页面
	@RequestMapping(value = "/index.do")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/column/show.do")
	public String show(ModelMap model) {
		List<Category> categorys = categoryService.getCategoryList();
		model.addAttribute("columns", categorys);
		return "column";
	}

	@RequestMapping(value = "/column/add.do")
	public void add(String column_name, HttpServletResponse response) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String datestr = dateFormat.format(date);
		String id = "0" + datestr;
		Category category = new Category(new Long(id), column_name, date);
		categoryService.addCategory(category);
		JSONObject jo = new JSONObject();
		jo.put("message", "保存成功!");
		ResponseUtils.senderJson(response, jo.toString());
	}

	@RequestMapping(value = "/column/del.do")
	public void del(String column_id, HttpServletResponse response) {
		categoryService.deleteByKey(new Long(column_id));
		JSONObject jo = new JSONObject();
		jo.put("message", "删除成功!");
		ResponseUtils.senderJson(response, jo.toString());
	}

	@RequestMapping(value = "/column/edit.do")
	public void edit(Category category, HttpServletResponse response) {
		category.setDate(new Date());
		categoryService.updateCategory(category);
		JSONObject jo = new JSONObject();
		jo.put("message", "修改成功!");
		ResponseUtils.senderJson(response, jo.toString());
	}

	@RequestMapping(value = "/information/show.do")
	public String inshow(ModelMap model) {
		Introduction introduction = introductionService.getIntroductionByKey(new Long(1));
		model.addAttribute("in", introduction);
		return "introduction";
	}

	@RequestMapping(value = "/information/edit.do")
	public void inedit(Introduction introduction, HttpServletResponse response) {
		introduction.setId(new Long(1));
		introduction.setDate(new Date());
		introductionService.updateIntroduction(introduction);
		JSONObject jo = new JSONObject();
		jo.put("message", "修改成功!");
		ResponseUtils.senderJson(response, jo.toString());
	}

	// 修改密码
	@RequestMapping(value = "/password.do")
	public String inedit(String password, HttpServletRequest request, HttpServletResponse response) {
		Admin admin = (Admin) sessionProvider.getAttribute(request, Constants.ADMIN_SESSION);
		admin.setPassword(password);
		adminService.updateAdmin(admin);
		sessionProvider.logout(request, response);
		return "login";
	}

	// 查询商品
	@RequestMapping(value = "/item/show.do")
	public String itemshow(Integer pageNo, String cid, ModelMap model) {
		// 新建Item分页查询对象
		Item item = new Item();
		item.setCategoryId(new Long(cid));
		// 分页参数
		StringBuilder params = new StringBuilder();
		params.append("&").append("cid=").append(cid);
		// 设置页号
		item.setPageNo(Pagination.cpn(pageNo));
		// 分页对象
		Pagination pagination = itemService.getItemsWithPage(item);
		// 分页展示
		String url = "/webset/admin/item/show.do";
		pagination.pageView(url, params.toString());
		model.addAttribute("pagination", pagination);
		model.addAttribute("cid", cid);
		return "picture";
	}

	// public String itemshow(String cid, ModelMap model) {
	// List<Item> items = itemService.getItemByCid(new Long(cid));
	// for (Item item : items) {
	// item.setPicurl(pictureService.getPictureDefault(new
	// Long(item.getId())).getAllUrl());
	// }
	// model.addAttribute("items", items);
	// model.addAttribute("cid", cid);
	// return "picture";
	// }

	// 打开添加商品页面
	@RequestMapping(value = "/item/aopen.do")
	public String itemaopen(String cid, ModelMap model) {
		model.addAttribute("cid", cid);
		return "addpicture";
	}

	// 添加商品
	@RequestMapping(value = "/item/add.do")
	public String itemadd(Item item, String urls, String cid) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String datestr = dateFormat.format(date);
		String iid = "1" + datestr;
		item.setId(new Long(iid));
		item.setCategoryId(new Long(cid));
		item.setDate(date);
		itemService.addItem(item);
		String[] strs = urls.split(",");
		for (int i = 0; i < strs.length; i++) {
			String id = "2" + datestr + i;
			Picture pic = new Picture(new Long(id), new Long(iid), "pic", strs[i], i == 0 ? true : false);
			pictureService.addPicture(pic);
		}
		return "redirect:/admin/item/show.do?cid=" + cid;
	}

	// 打开修改商品页面
	@RequestMapping(value = "/item/eopen.do")
	public String itemeopen(String iid, ModelMap model) {
		Item item = itemService.getItemByKey(new Long(iid));
		List<Picture> pics = pictureService.getPictureByIid(new Long(iid));
		model.addAttribute("item", item);
		model.addAttribute("pics", pics);
		return "editpicture";
	}

	// 修改商品
	@RequestMapping(value = "/item/edit.do")
	public String itemedit(Item item) {
		item.setDate(new Date());
		itemService.updateItem(item);
		return "redirect:/admin/item/show.do?cid=" + item.getCategoryId();
	}

	// 删除商品
	@RequestMapping(value = "/item/del.do")
	public String itemdel(String iid, String cid) {
		itemService.deleteByKey(new Long(iid));
		return "redirect:/admin/item/show.do?cid=" + cid;
	}
}
