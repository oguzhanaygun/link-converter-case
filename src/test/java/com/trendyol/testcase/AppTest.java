package com.trendyol.testcase;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestComponent;

import com.trendyol.testcase.exception.NotValidUrlException;
import com.trendyol.testcase.exception.TrendyolException;
import com.trendyol.testcase.model.deeplink.TrendyolDeepLinkFactory;
import com.trendyol.testcase.model.url.TrendyolUrlFactory;

@TestComponent
public class AppTest {

	String queryUrl = "https://www.trendyol.com/tum--urunler?q=elbise";
	String detailUrl = "https://www.trendyol.com/casio/saat-p-1231?boutiqueId=989&merchantId=2342";
	String otherUrl = "https://www.trendyol.com";
	String detailLink = "ty://?Page=Product&ContentId=1231&CompaingId=989&MerchantId=2342";
	String queryLink = "ty://?Page=Search&Query=elbise";
	String otherLink = "ty://?Page=Home";

	@Test
	public void happyPathScenario() throws NotValidUrlException, TrendyolException {
		assertTrue(("ty://?Page=Search&Query=elbise".equals(TrendyolUrlFactory.getUrl(queryUrl).convertToDeepLink())));
		assertTrue("ty://?Page=Product&ContentId=1231".equals(TrendyolUrlFactory.getUrl(detailUrl).convertToDeepLink()));
		assertTrue("ty://?Page=Home".equals(TrendyolUrlFactory.getUrl(otherUrl).convertToDeepLink()));

		assertTrue("https://www.trendyol.com.tr/tum--urunler?q=elbise".equals(TrendyolDeepLinkFactory.getDeepLink(queryLink).convertToDeepLink()));
		assertTrue("https://www.trendyol.com.tr/brand/name-p-1231?boutiqueId=989&MerchantId=2342".equals(TrendyolDeepLinkFactory.getDeepLink(detailLink).convertToDeepLink()));
		assertTrue("https://www.trendyol.com.tr".equals(TrendyolDeepLinkFactory.getDeepLink(otherLink).convertToDeepLink()));
	}
}
