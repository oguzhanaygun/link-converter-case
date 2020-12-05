package com.trendyol.testcase.service.service;

import org.springframework.stereotype.Service;

import com.trendyol.testcase.model.Response;

@Service
public class AppService {

	public Response convertToDeepLink(String url) {
		Response response = new Response();
		response.getMessages();
		return response;
	}
	
	public Response convertToUrl(String link) {
		Response response = new Response();
		response.getMessages();
		return response;
	}

}
