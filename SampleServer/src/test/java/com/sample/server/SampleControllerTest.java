package com.sample.server;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import com.sample.controller.SampleController;

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

	@Test
	public void callInitFromServerRequest() {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		int statusCode;
		try {
			httpClient = HttpClients.createDefault();
			HttpGet request = new HttpGet("http://localhost:8080/server/WEB-INF/classes/com/sample/controller/SampleController.class");
			response = httpClient.execute(request);
			statusCode = response.getStatusLine().getStatusCode();
			System.out.println(statusCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
