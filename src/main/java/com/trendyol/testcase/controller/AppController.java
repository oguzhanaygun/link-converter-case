package com.trendyol.testcase.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trendyol.testcase.exception.TrendyolException;
import com.trendyol.testcase.model.Response;
import com.trendyol.testcase.service.AppService;

@RestController
public class AppController {
	org.slf4j.Logger logger = LoggerFactory.getLogger(AppController.class);
	@Autowired
	AppService service;

	@GetMapping("/convert/link")
	public Response convertToUrl(@RequestParam(name = "link") String link) throws TrendyolException {
		return service.convertToDeepLink(link);
	}

	@GetMapping("/convert/url")
	public Response convertToDeepLink(@RequestParam(name = "url") String url) {
		return service.convertToUrl(url);
	}
}