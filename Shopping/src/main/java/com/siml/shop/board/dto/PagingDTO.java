package com.siml.shop.board.dto;

public class PagingDTO {
	private int page;
	private int perPageNum;
	
	private String searchOption;
	private String searchValue;
	
	public PagingDTO() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	@Override
	public String toString() {
		return "PagingDTO [page=" + page + ", perPageNum=" + perPageNum + ", searchOption=" + searchOption
				+ ", searchValue=" + searchValue + "]";
	}

	/**
	 * 해당 페이지 시작 게시글의 번호를 반환, mapper에 전달
	 * @return
	 */
	public int getPageStart() {
		int firstArticleNum = (this.page -1) * perPageNum;
		return firstArticleNum; 
	}
}
