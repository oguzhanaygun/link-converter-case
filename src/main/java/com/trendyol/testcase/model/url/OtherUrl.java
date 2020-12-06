package com.trendyol.testcase.model.url;

import java.net.URI;

public class OtherUrl extends TrendyolUrl {

	public OtherUrl(URI uri) {
		super(uri);
	}

	@Override
	public String convertToDeepLink() {
		return DEEPLINK_SUFFIX + "?Page=Home";
	}

}
