package com.wyln.webset.controller.admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.wyln.webset.web.Constants;
import com.wyln.webset.web.ResponseUtils;

/**
 * 
 * @ClassName: UploadController
 * @Description: 处理上传图片
 * @author Tommy
 * @date 2017年3月14日
 */
@Controller
public class UploadController {
	// 上传图片
	@RequestMapping(value = "/admin/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response) {

		// 获取图片的扩展名
		String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
		// 图片名称生成策略
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		// 将当前时间作为图片名称的一部分
		String format = dateFormat.format(new Date());
		// 随机三位数
		Random rd = new Random();
		for (int i = 0; i < 3; i++) {
			format += rd.nextInt(10);
		}

		// 实例化一个Jesey
		Client client = new Client();
		// 另一台tomcat的请求路径为:
		String path = "upload/" + format + "." + extension;
		String url = Constants.IMAGE_URL + path;
		// 设置请求路径
		WebResource resource = client.resource(url);
		// 发送开始
		try {
			resource.put(String.class, pic.getBytes());
		} catch (UniformInterfaceException e) {
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 返回两个路径 异步返回
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path", path);

		ResponseUtils.senderJson(response, jo.toString());
	}
}
