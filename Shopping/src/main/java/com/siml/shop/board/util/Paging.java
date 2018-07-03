package com.siml.shop.board.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.siml.shop.board.dto.PagingDTO;

public class Paging {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;	//뷰단에서 c:if에 이용
	private boolean next;
	
	private int displayPageNum = 10;
	
	private PagingDTO pagingDto;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		initPaging();
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	private void initPaging() {
		endPage = (int)(Math.ceil(pagingDto.getPage() / (double) displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
        int tempEndPage = (int) (Math.ceil(totalCount / (double) pagingDto.getPerPageNum()));
        if(endPage > tempEndPage){
            endPage = tempEndPage;
        }    
        prev = startPage == 1 ? false : true;
        next = endPage * pagingDto.getPerPageNum() >= totalCount ? false : true;
	}
	
	public String searchQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page).queryParam("searchOption", ((PagingDTO) pagingDto).getSearchOption())
				.queryParam("searchValue", encoding(((PagingDTO) pagingDto).getSearchValue())).build();
		
		return uriComponents.toUriString();
	}
	
	public String encoding(String searchValue) {					//없어도 되는 지 확인하기
		if(searchValue == null || searchValue.trim().length() == 0) {
			return null;
		}
		try {
			return URLEncoder.encode(searchValue, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
}
