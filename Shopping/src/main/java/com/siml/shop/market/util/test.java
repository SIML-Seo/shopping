package com.siml.shop.market.util;

import org.springframework.http.ResponseEntity;

public class test {
	public static void main(String[] args) {
		SearchForTitle a = new SearchForTitle();
		ResponseEntity<String> result = a.serachResult("1189126745 9791189126742", "1");
		System.out.println(result.toString());
	}
}
