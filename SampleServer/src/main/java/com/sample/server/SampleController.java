package com.sample.server;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;

/**
 * Sampleコントローラー.
 */
@Controller
public class SampleController {

	public String init(Map<String, String> request) {
		System.out.println("【Debug Server】request:" + request);
		String result = request.entrySet().stream().map(e -> e.getValue()).collect(Collectors.joining());
		System.out.println("【Debug Server】responce:" + result);
		return result;
	}
}
