package com.example.springTradeBot.utilities;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.springTradeBot.constants.ApplicationContants;
import com.example.springTradeBot.service.SHA256;

public class RestUtilities {

	public static String URLBuilder(Map<String, String> paramMap, boolean isSignatureRequired, String secret,
			String path , String baseUrl) {
		StringBuilder queryStringBuilder = new StringBuilder();
		StringBuilder finalQueryStringBuilder = new StringBuilder();
		int count = paramMap.size();
		for (Map.Entry<String, String> entry : paramMap.entrySet()) {
			count--;
			queryStringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
			if (count > 0)
				queryStringBuilder.append("&");
		}
		if (isSignatureRequired) {
			String signatureValue = SHA256.sign(queryStringBuilder.toString(), secret);
			queryStringBuilder.append("&signature=").append(signatureValue);
		}
		finalQueryStringBuilder.append("?");
		finalQueryStringBuilder.append(queryStringBuilder.toString());
		//String baseUrl = ApplicationContants.BASE_URL_API;
		String url = baseUrl + path + finalQueryStringBuilder.toString();
		return url;

	}

	public static ResponseEntity<? extends Object> processRestCall(String url, Class returnType, String apiKey,
			HttpMethod httpMethod, boolean isApiRequired) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		if (isApiRequired)
			headers.set("X-MBX-APIKEY", apiKey);
		final HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange(url, httpMethod, entity, returnType);
	}
}
