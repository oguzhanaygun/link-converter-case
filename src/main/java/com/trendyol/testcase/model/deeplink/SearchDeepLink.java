package com.trendyol.testcase.model.deeplink;

import java.net.URI;
import java.util.Arrays;
import java.util.Optional;

import com.trendyol.testcase.exception.TrendyolException;

public class SearchDeepLink extends TrendyolDeepLink {

	public SearchDeepLink(URI uri) {
		super(uri);
	}

	@Override
	public String convertToDeepLink() throws TrendyolException {
		URI uri = getUri();
		String url = URL_SUFFIX;
		Optional<String> queryString = Arrays.stream(uri.getRawQuery().split("&"))
				.filter(q -> q.contains("Query")).findFirst();
		if(queryString.isPresent()) {
			url = url + "/tum--urunler?"+ queryString.get().replace("Query", "q");
		}
		return url;
	}

}
