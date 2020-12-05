package com.trendyol.testcase.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {


	@GetMapping("/")
	public String convertToUrl(@RequestParam(name = "url") String url) {
		return url;
	}
	
	@GetMapping("/")
	public String convertToDeepLink(@RequestParam(name = "link") String link) {
		return link;
	}
}