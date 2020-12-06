package com.trendyol.testcase.model.deeplink;

import java.net.URI;

import com.trendyol.testcase.exception.TrendyolException;

public class OtherDeepLink extends TrendyolDeepLink {

	public OtherDeepLink(URI uri) {
		super(uri);
	}

	@Override
	public String convertToDeepLink() throws TrendyolException {
		return URL_SUFFIX;
	}

}
