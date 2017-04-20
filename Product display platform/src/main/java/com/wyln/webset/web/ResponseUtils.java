package com.wyln.webset.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName: ResponseUtils
 * @Description: 异步返回各种格式 json xml text
 * @author Tommy
 * @date 2017年3月12日
 */
public class ResponseUtils {
	// 发送内容
		public static void sender(HttpServletResponse response, String contentType, String text) {
			response.setContentType(contentType);
			try {
				response.getWriter().write(text);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 发送Json
		public static void senderJson(HttpServletResponse response, String text) {
			sender(response, "application/json;charset=UTF-8", text);
		}

		// 发送Xml
		public static void senderXml(HttpServletResponse response, String text) {
			sender(response, "text/xml;charset=UTF-8", text);
		}

		// 发送text
		public static void senderText(HttpServletResponse response, String text) {
			sender(response, "text/plain;charset=UTF-8", text);
		}
}
