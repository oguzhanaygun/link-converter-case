package com.trendyol.testcase.model.url;

import java.net.URI;
import java.net.URISyntaxException;

import com.trendyol.testcase.exception.NotValidUrlException;

public class TrendyolUrlFactory {
	public static TrendyolUrl getUrl(String url) throws NotValidUrlException {
		URI uri;
		if (url == null) {
			throw new NotValidUrlException("No url found you must be specify an url");
		}
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			throw new NotValidUrlException("The given url is not valid");
		}

		if (uri.getHost() == null || !uri.getHost().contains("trendyol")) {
			throw new NotValidUrlException("The given url is not a trendyol url. Url must be trendyol url");
		}

		if (uri.getPath() == null) {
			return new OtherUrl(uri);
		} else if (uri.getPath().contains("tum--urunler") && uri.getQuery().contains("q")) {
			return new SearchUrl(uri);
		} else if (uri.getPath().contains("-p-") && uri.getPath().matches("(.*)(-p-)([a-zA-Z0-9])+")) {
			return new ProductUrl(uri);
		} else {
			return new OtherUrl(uri);
		}
	}
}
