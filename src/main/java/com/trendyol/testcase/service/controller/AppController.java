package com.trendyol.testcase.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trendyol.testcase.model.Response;
import com.trendyol.testcase.service.service.AppService;

@RestController
public class AppController {

	@Autowired
	AppService service;

	@GetMapping("/convert/link")
	public Response convertToUrl(@RequestParam(name = "link") String link) {
		return service.convertToUrl(link);
	}

	@GetMapping("/convert/url")
	public Response convertToDeepLink(@RequestParam(name = "url") String url) {
		return service.convertToUrl(url);
	}
}