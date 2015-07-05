package com.example.sampleclient;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;


@SuppressWarnings("deprecation")
public class MainAsyncTask extends AsyncTask<String, Integer, Integer> {

	@Override
	protected Integer doInBackground(String... contents) {
		String url="http://10.0.2.2:8080/server/index.html";
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		ArrayList <NameValuePair> params = new ArrayList <>();
		params.add(new BasicNameValuePair("param1", "a"));
		params.add(new BasicNameValuePair("param2", "b"));

		HttpResponse res = null;
		try {
			System.out.println("【Debug Client】request:" + params);
			post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
			res = httpClient.execute(post);
			System.out.println("【Debug Client】responce:" + res);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Integer.valueOf(res.getStatusLine().getStatusCode());
	}
}
