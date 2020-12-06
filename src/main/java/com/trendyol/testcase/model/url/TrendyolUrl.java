package com.trendyol.testcase.model.url;

import java.net.URI;

import com.trendyol.testcase.exception.TrendyolException;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public abstract class TrendyolUrl {
	protected final String DEEPLINK_SUFFIX = "ty://";
	private URI uri;

	public TrendyolUrl(URI uri) {
		this.uri = uri;
	}

	public abstract String convertToDeepLink() throws TrendyolException;

}
