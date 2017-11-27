package com.weather.controller;

import com.weather.domains.Quote;
import com.weather.domains.Request;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.context.request.WebRequest;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get(Model m, WebRequest request) throws IOException {
		String city = "";
		String units = "";

		// set get value
		city = request.getParameter("city");
		units = request.getParameter("metricSystem");

		try {
			Request send = new Request();
			Quote quote = send.MakeRequest(city, units);
			
			m.addAttribute("city", quote.getName());
			m.addAttribute("country", quote.getSys().getCountry());
			m.addAttribute("latitude", quote.getCoord().getLat());
			m.addAttribute("longitude", quote.getCoord().getLon());
			m.addAttribute("currentweather", quote.getMain().getTemp());
			m.addAttribute("windspeed", quote.getWind().getSpeed());
			
			return "index";

		} catch (Exception e) {
			m.addAttribute("error", e.getMessage());
			m.addAttribute("response", "");
			return "get";
		}

		// String url =
		// "http://api.openweathermap.org/data/2.5/weather?id=819827&units=imperial&APPID=25d6137d41c0b9e4bf28733842490f32";
		//
		// URL obj = new URL(url);
		// HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		//
		// // optional default is GET
		// con.setRequestMethod("GET");
		//
		// //add request header
		// con.setRequestProperty("User-Agent", "Mozilla/5.0");
		//
		// int responseCode = con.getResponseCode();
		//
		// BufferedReader in = new BufferedReader(
		// new InputStreamReader(con.getInputStream()));
		// String inputLine;
		// StringBuffer response = new StringBuffer();
		//
		// while ((inputLine = in.readLine()) != null) {
		// response.append(inputLine);
		// }
		// in.close();
		//
		// ObjectMapper mapper = new ObjectMapper();
		// String jsonInString = response.toString();
		//
		// //JSON from String to Object
		// Quote quote = mapper.readValue(jsonInString, Quote.class);
		//
		// m.addAttribute("response", quote.toString());
		// m.addAttribute("error", "");

		// return "index";
	}
}
