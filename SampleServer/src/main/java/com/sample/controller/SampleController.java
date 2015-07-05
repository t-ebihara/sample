package com.sample.controller;

import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Sampleコントローラー.
 */
@Controller
public class SampleController {

	private static Logger logger = Logger.getLogger(SampleController.class);

	@ResponseBody
	public String init(Map<String, String> request) {
		logger.debug("create instance");
		System.out.println("【Debug Server】request:" + request);
		String result = request.entrySet().stream().map(e -> e.getValue()).collect(Collectors.joining());
		System.out.println("【Debug Server】responce:" + result);
		return result;
	}
}
