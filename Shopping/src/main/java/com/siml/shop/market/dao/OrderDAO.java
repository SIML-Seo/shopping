package com.siml.shop.market.dao;

import java.util.List;

import com.siml.shop.market.dto.OrderDTO;

public interface OrderDAO {
	/**
	 * 주문현황에서 유저의 주문 경력을 반환해주는 메소드
	 * @param userId
	 * @return
	 */
	public List<OrderDTO> orderList(String userId);
	/**
	 * 주문 성공시 주문 DB에 정보를 입력하는 메소드
	 * @param dto
	 */
	public void insertOrder(OrderDTO dto);
	/**
	 * 해당 유저가 가진 포인트를 확인하는 메소드
	 * @param userId
	 * @return
	 */
	public int pointCheck(String userId);
	/**
	 * 보유 포인트에서 총 주문금액에 해당하는 가격만큼 포인트를 변경하는 메소드
	 * @param userId
	 * @param point
	 */
	public void changePoint(String userId, int point);
	/**
	 * 주문이 성공적으로 이루어졌을 경우 보유 책 DB리스트에서 주문된 책의 상태를 변경시키는 메소드
	 * @param status
	 * @param seq
	 */
	public void updateBookStatus(String status, int seq);
	/**
	 * 주문을 취소, 반품할 경우 주문 상황을 변경하는 메소드
	 * @param status
	 * @param orderNum
	 */
	public void updateOrderStatus(String status, String orderNum);
}
