package com.siml.shop.market.dao;

import java.util.List;

import com.siml.shop.market.dto.CartDTO;

public interface CartDAO {
    public List<CartDTO> cartMoney();
    /**
     * 장바구니에 해당하는 책을 넣는 메소드
     * @param dto
     */
    public void insert(CartDTO dto);
    /**
     * 장바구니 리스트를 확인하는 메소드
     * @param userId
     * @return
     */
    public List<CartDTO> cartList(String userId);
    /**
     * 장바구니에 있는 책 1권을 장바구니에서 삭제하는 메소드
     * @param seq
     */
    public void delete(int seq);
    /**
     * 장바구니를 비우는 메소드
     * @param userId
     */
    public void deleteAll(String userId);
    /**
     * 장바구니에 있는 책들의 주문금액 합계를 반환하는 메소드
     * @param userId
     * @return
     */
    public int sumMoney(String userId);
   /* public void modifyCart(CartDTO dto);
    public void update(int seq);
    public int countCart(String userId, int bookNum);
    public void updateCart(CartDTO dto);*/
}
