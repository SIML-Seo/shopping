package com.siml.shop.market.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.siml.shop.market.dto.NaverBookDTO;

@Component
public class SearchForISBNTemp {
	public NaverBookDTO insertResult(String isbn) {
		String clientId = "6p81xwCR7qgxXvAH8NSY";
        String clientSecret = "EmDjqBoRkG";
		NaverBookDTO book = new NaverBookDTO();
		try {
			String text = URLEncoder.encode(isbn, "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/book.json?query="+ text;
			
			URL url = new URL(apiURL);
	        HttpURLConnection con = (HttpURLConnection)url.openConnection();
	        con.setRequestMethod("GET");
	        con.setRequestProperty("X-Naver-Client-Id", clientId);
	        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	        int responseCode = con.getResponseCode();
	        BufferedReader br;
	        if(responseCode==200) {
	            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        } else { 
	            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	        }
	        
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = br.readLine()) != null) {
	            response.append(inputLine);
	        }
	        br.close();
	
	        JSONParser jsonParser = new JSONParser();
	        JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());
	        JSONArray items = (JSONArray) jsonObject.get("items");
	        JSONObject item = (JSONObject)items.get(0);
	        
	        book.setTitle(item.get("title").toString());
	        book.setLink(item.get("link").toString());
	        book.setImage(item.get("image").toString());
	        book.setAuthor(item.get("author").toString());
	        book.setPrice(item.get("price").toString());
	        book.setPublisher(item.get("publisher").toString());
	        book.setPubdate(item.get("pubdate").toString());
	        
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
		return book;
	}
	
    /*public static void main(String[] args) {
        String clientId = "6p81xwCR7qgxXvAH8NSY";
        String clientSecret = "EmDjqBoRkG";
        NaverBookDTO2 book = new NaverBookDTO2();
        try {
			String text = URLEncoder.encode("1189126745 9791189126742", "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text;
			
			URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else { 
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());
            JSONArray items = (JSONArray) jsonObject.get("items");
            JSONObject item = (JSONObject)items.get(0);
            
			book.setTitle(item.get("title").toString());
	        book.setLink(item.get("link").toString());
	        book.setImage(item.get("image").toString());
	        book.setAuthor(item.get("author").toString());
	        book.setPrice(item.get("price").toString());
	        book.setPublisher(item.get("publisher").toString());
	        book.setPubdate(item.get("pubdate").toString());
            
	        System.out.println(book.getTitle());
	        System.out.println(book.getLink());
	        System.out.println(book.getImage());
	        System.out.println(book.getAuthor());
	        System.out.println(book.getPrice());
	        System.out.println(book.getPublisher());
	        System.out.println(book.getPubdate());
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/
}
