package com.trendyol.testcase.model.url;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.trendyol.testcase.exception.TrendyolException;

public class ProductUrl extends TrendyolUrl {

	public ProductUrl(URI uri) {
		super(uri);
	}

	@Override
	public String convertToDeepLink() throws TrendyolException {
		URI uri = getUri();
		String deepLink = DEEPLINK_SUFFIX + "?Page=Product&ContentId=" + getContentId(uri.getPath());
		if(StringUtils.isEmpty(uri.getQuery())) {
			deepLink = deepLink +"&"+ uri.getQuery().replace("boutiqueId", "CompaingId");
		}
		
		return deepLink;
	}

	private String getContentId(String path) throws TrendyolException {
		Pattern p = Pattern.compile("-p-(.*)");
		Matcher m = p.matcher(path);
		if (m.find()) {
			return m.group(1);
		} else {
			throw new TrendyolException("Could not find the contentId from the path: " + path);
		}
	}

}
