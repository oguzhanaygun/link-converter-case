package com.trendyol.testcase.model.deeplink;

import java.net.URI;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.trendyol.testcase.exception.TrendyolException;

public class ProductDeepLink extends TrendyolDeepLink {

	public ProductDeepLink(URI uri) {
		super(uri);
	}

	@Override
	public String convertToDeepLink() throws TrendyolException {
		URI uri = getUri();
		String url = URL_SUFFIX + "/brand/name-p-" + getProductId(uri.getRawQuery());
		String query = getMerchantId(uri.getQuery());
		if (!StringUtils.isEmpty(query)) {
			url = url + "?" + query;
		}
		return url;
	}

	private String getMerchantId(String query) {
		String urlQuery = Arrays.stream(query.split("&")).filter(q -> !q.contains("ContentId"))
				.filter(q -> !q.contains("Page=Product")).collect(Collectors.joining("&"));
		return urlQuery.replace("CompaingId", "boutiqueId");
	}

	public String getProductId(String query) throws TrendyolException {
		String id;
		Optional<String> contentIdQuery = Arrays.stream(query.split("&")).filter(q -> q.contains("ContentId"))
				.findFirst();
		if (contentIdQuery.isPresent()) {
			id = contentIdQuery.get().replace("ContentId=", "");
		} else {
			throw new TrendyolException("Could not find the contentId from the path: " + query);
		}
		return id;
	}

}
