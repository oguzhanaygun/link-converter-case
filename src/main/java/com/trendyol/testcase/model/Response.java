package com.trendyol.testcase.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response {
	private List<String> messages = new ArrayList<String>();
	private String link;

}
