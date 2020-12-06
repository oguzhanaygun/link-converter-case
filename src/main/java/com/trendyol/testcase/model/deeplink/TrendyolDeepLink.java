package com.trendyol.testcase.model.deeplink;

import java.net.URI;

import com.trendyol.testcase.exception.TrendyolException;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public abstract class TrendyolDeepLink {
	protected final String URL_SUFFIX = "https://www.trendyol.com.tr";
	private URI uri;

	public TrendyolDeepLink(URI uri) {
		this.uri = uri;
	}

	public abstract String convertToDeepLink() throws TrendyolException;
}
