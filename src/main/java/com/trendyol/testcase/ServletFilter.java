package com.trendyol.testcase;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServletFilter implements Filter {

	private final Logger LOGGER = LoggerFactory.getLogger(ServletFilter.class);
	private final String X_REQUEST_ID = "X-Request-ID";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		try {
			String reqId = UUID.randomUUID().toString();
			LOGGER.info("path: {}, method: {}, query: {}, id: {}", req.getRequestURI(), req.getMethod(),
					req.getQueryString(), reqId);
			res.setHeader(X_REQUEST_ID, reqId);
			chain.doFilter(request, response);
			LOGGER.info("statusCode {}, path: {}, method: {}, query {}, id: {}", res.getStatus(), req.getRequestURI(),
					req.getMethod(), req.getQueryString(), res.getHeader(X_REQUEST_ID));

		} catch (Exception e) {
			LOGGER.error("Something went wrong while logging request and response", e);
		}
	}

}