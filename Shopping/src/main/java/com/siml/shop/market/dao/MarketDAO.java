package com.siml.shop.market.dao;

import java.util.List;

import com.siml.shop.market.dto.NaverBookDTO;

public interface MarketDAO {
	/**
	 * 특정 회원이 사이트에 판매한 책의 정보
	 * @param dto
	 */
	public void sellBook(NaverBookDTO dto);
	
	/**
	 * 특정 회원이 사이트에서 구매한 책의 정보
	 * @param dto
	 */
	public void buyBook(NaverBookDTO dto);
	
	/**
	 * 판매리스트 최좌측에 표시할 리스트 개수
	 * @return
	 */
	public int countBook();
	
	/**
	 * 판매리스트 나열
	 * @return
	 */
	public List<NaverBookDTO> bookList();
	
	/**
	 * 판매리스트에서 책 제목을 클릭하여 표시할 해당 책의 상세 정보
	 * @param num = 회원이 판매시 등록된 시퀀스 값
	 * @return
	 */
	public NaverBookDTO bookInfo(int seq);

	/**
	 * 메인화면에 보여줄 최근 판매된 책 6개를 표시하기 위한 메소드
	 * @return
	 */
	public List<NaverBookDTO> bookLink();

	/**
	 * 한글 초성을 조건으로 상품을 검색하기 위한 메소드
	 * @param cho
	 * @return
	 */
	public List<NaverBookDTO> bookQuery(String cho);
}
