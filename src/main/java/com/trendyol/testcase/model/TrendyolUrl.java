package com.trendyol.testcase.model;

import java.net.URI;
import java.net.URISyntaxException;

import com.trendyol.testcase.exception.NotValidUrlException;

public class TrendyolUrl {
	private String url;
	private URI uri;

	public TrendyolUrl(String url) throws NotValidUrlException {
		if (url == null) {
			throw new NotValidUrlException("No url found you must be specify an url");
		}
		try {
		uri = new URI(url);
		} catch (URISyntaxException e) {
			
			throw new NotValidUrlException("The given url is not valid");
		}
		if (!url.contains("trendyOl")) {
			throw new NotValidUrlException("The given url is not a trendyol url. Url must be trendyol url");
		}
	}

}
