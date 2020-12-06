package com.trendyol.testcase.service;

import org.springframework.stereotype.Service;

import com.trendyol.testcase.exception.TrendyolException;
import com.trendyol.testcase.model.Response;
import com.trendyol.testcase.model.deeplink.TrendyolDeepLink;
import com.trendyol.testcase.model.deeplink.TrendyolDeepLinkFactory;
import com.trendyol.testcase.model.url.TrendyolUrl;
import com.trendyol.testcase.model.url.TrendyolUrlFactory;

@Service
public class AppService {

	public Response convertToDeepLink(String url) throws TrendyolException {
		Response response = new Response();
		TrendyolUrl trendyolUrl = TrendyolUrlFactory.getUrl(url);
		response.setLink(trendyolUrl.convertToDeepLink());
		response.getMessages().add("ok");
		return response;
	}

	public Response convertToUrl(String link) throws TrendyolException {
		Response response = new Response();
		TrendyolDeepLink trendyolDeepLink = TrendyolDeepLinkFactory.getDeepLink(link);
		response.setLink(trendyolDeepLink.convertToDeepLink());
		response.getMessages().add("ok");
		return response;
	}

}
