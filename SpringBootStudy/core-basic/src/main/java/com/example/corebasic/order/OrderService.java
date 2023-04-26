package com.example.corebasic.order;

public interface OrderService {
    /**
     * 주문 생성
     *
     * @param memberId  주문 회원 id
     * @param itemName  item 이름
     * @param itemPrice item 금액
     * @return Order 할인이 적용된 주문 정보
     */
    Order createOrder(Long memberId, String itemName, int itemPrice);
}