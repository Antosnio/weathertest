package com.weather.test;

import java.io.IOException;

import org.junit.Test;

import com.weather.domains.Quote;
import com.weather.domains.Request;

import junit.framework.TestCase;

public class homeTest extends TestCase {
	
	@Test
	public void hometest() throws IOException {
		Quote voidquote = new Quote();
		voidquote.setCod(200);
		Request send = new Request();
		Quote quote = send.MakeRequest("819827", "imperial");
		assertEquals(voidquote.getCod(), quote.getCod());
	}
}
