package com.siml.shop.market.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SearchForTitle {
	public ResponseEntity<String> serachResult(String title, String pageNum) {
		String clientId = "6p81xwCR7qgxXvAH8NSY";
        String clientSecret = "EmDjqBoRkG";
        
        ResponseEntity<String> responseEntity = null;
        
//		try {
//			String text = URLEncoder.encode(title, "UTF-8");
			String text = title;
			String display = "5";
			int page = (Integer.parseInt(pageNum) - 1 ) * 5 + 1;
			String start = Integer.toString(page);
			String apiURL = "https://openapi.naver.com/v1/search/book.json?query="+ 
					text + "&display=" + display  + "&start=" + start;
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("X-Naver-Client-Id", clientId);
			headers.add("X-Naver-Client-Secret", clientSecret);
			headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//			headers.add("Content-Type", "text/html; charset=UTF-8");

			RestTemplate template = new RestTemplate();
			responseEntity = template.exchange(apiURL, HttpMethod.GET, new HttpEntity<>(headers), String.class);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
        return responseEntity;
	}
	
    /*public static void main(String[] args) {
        String clientId = "6p81xwCR7qgxXvAH8NSY";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "EmDjqBoRkG";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode("명탐정코난", "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/book.json?query="+ text; // json 결과
            //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/
}