package com.weather.domains;

import java.io.IOException;
import java.util.Properties;

import org.springframework.web.client.RestTemplate;

public class Request {

	private String url = "";
	private String apikey = "";

	public Request() {

	}

	public Quote MakeRequest(String city, String units) throws IOException {

		Properties prop = new Properties();
		prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
		url = prop.getProperty("weather.url");
		apikey = prop.getProperty("weather.apikey");

		RestTemplate restTemplate = new RestTemplate();
		Quote weather = restTemplate.getForObject(url + "id=" + city + "&units=" + units + "&APPID=" + apikey,
				Quote.class);

		return weather;

	}
}
