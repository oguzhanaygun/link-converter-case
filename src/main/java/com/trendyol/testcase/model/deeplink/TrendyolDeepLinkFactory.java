package com.trendyol.testcase.model.deeplink;

import java.net.URI;
import java.net.URISyntaxException;

import com.trendyol.testcase.exception.NotValidUrlException;

public class TrendyolDeepLinkFactory {
	public static TrendyolDeepLink getDeepLink(String deepLink) throws NotValidUrlException {
		URI uri;
		if (deepLink == null) {
			throw new NotValidUrlException("No url found you must be specify an url");
		}
		try {
			uri = new URI(deepLink);
		} catch (URISyntaxException e) {
			throw new NotValidUrlException("The given url is not valid");
		}

		if (uri.getQuery() == null) {
			return new OtherDeepLink(uri);
		} else if (uri.getQuery().contains("Page=Search")) {
			return new SearchDeepLink(uri);
		} else if (uri.getQuery().contains("Page=Product")) {
			return new ProductDeepLink(uri);
		} else {
			return new OtherDeepLink(uri);
		}
	}
}
