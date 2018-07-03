package com.siml.shop.market;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.siml.shop.market.dto.NaverBookDTOTemp;

import static org.assertj.core.api.Assertions.assertThat;

public class BookSearchTest {
	private static final Logger logger = Logger.getLogger(BookSearchTest.class);
	
	private static final String clientId = "6p81xwCR7qgxXvAH8NSY";
	private static final String clientSecret = "EmDjqBoRkG";
	private static final String url = "https://openapi.naver.com/v1/search/book.json";
	
	private HttpEntity<?> headers;
	private RestTemplate template = new RestTemplate();
	
	@Before
	public void setUp() throws Exception{
		MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
		headerMap.add("X-Naver-Client-Id", clientId);
        headerMap.add("X-Naver-Client-Secret", clientSecret);
        headerMap.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        this.headers = new HttpEntity<>(headerMap);
	}
	
	@Test
	public void requestString() throws Exception{
		String url2 = url + "?query=java&display=5";
		ResponseEntity<String> responseEntity = template.exchange(url2, HttpMethod.GET, headers, String.class);
		assertThat(responseEntity).isNotNull();
		
		String body = responseEntity.getBody();
		assertThat(body).isNotNull();
	}
	
	@Test
	public void requestJson() throws Exception{
		String url2 = url + "?query=java&display=5";
		ResponseEntity<NaverBookDTOTemp> responseEntity = template.exchange(url2, HttpMethod.GET, headers, NaverBookDTOTemp.class);
		assertThat(responseEntity).isNotNull();
		
		NaverBookDTOTemp body = responseEntity.getBody();
		assertThat(body).isNotNull();
		assertThat(body.getDisplay()).isNotNull();
		assertThat(body.getDisplay()).isEqualTo(5);
		assertThat(body.getLastBuildDate()).isNotNull();
		assertThat(body.getStart()).isNotNull();
		assertThat(body.getTotal()).isNotNull();
		/*assertThat(body.getItems()).isNotNull().isNotEmpty();
		assertThat(body.getItems().size()).isEqualTo(5);*/
	}
}
