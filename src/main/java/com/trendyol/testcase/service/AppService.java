package com.trendyol.testcase.service;

import org.springframework.stereotype.Service;

import com.trendyol.testcase.exception.NotValidUrlException;
import com.trendyol.testcase.exception.TrendyolException;
import com.trendyol.testcase.model.Response;
import com.trendyol.testcase.model.TrendyolUrl;
import com.trendyol.testcase.model.TrendyolUrlFactory;

@Service
public class AppService {

	public Response convertToDeepLink(String url) throws TrendyolException {
		Response response = new Response();
		TrendyolUrl trendyolUrl = TrendyolUrlFactory.getUrl(url);
		response.setLink(trendyolUrl.convertToDeepLink());
		response.getMessages().add("ok");
		return response;
	}

	public Response convertToUrl(String link) {
		Response response = new Response();
		response.setLink("test url");
		return response;
	}

}
