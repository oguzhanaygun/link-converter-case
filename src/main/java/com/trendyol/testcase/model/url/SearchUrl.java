package com.trendyol.testcase.model.url;

import java.net.URI;
import java.util.Arrays;
import java.util.Optional;

public class SearchUrl extends TrendyolUrl {
	
	public SearchUrl(URI uri) {
		super(uri);
	}

	@Override
	public String convertToDeepLink() {
		String deepLink = DEEPLINK_SUFFIX + "?Page=Search&Query=";
		URI uri = getUri();
		Optional<String> option = Arrays.stream(uri.getRawQuery().split("&")).filter(q -> q.contains("q=")).findAny();
		if (option.isPresent()) {
			deepLink = deepLink + option.get().replace("q=", "");
		}
		return deepLink;
	}

}
