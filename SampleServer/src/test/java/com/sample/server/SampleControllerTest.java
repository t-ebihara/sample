package com.sample.server;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SampleControllerTest {

	private final static SampleController controller = new SampleController();

	@Test
	public void init() {
		String target = "ab";
		Map<String, String> request = new HashMap<>();
		request.put("param1", "a");
		request.put("param2", "b");
		String result = controller.init(request);
		assertEquals(target, result);
	}
}
