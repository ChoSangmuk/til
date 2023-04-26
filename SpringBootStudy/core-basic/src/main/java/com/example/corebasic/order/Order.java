package com.example.corebasic.order;

import lombok.Getter;
import lombok.Setter;

@Getter
// Lombok @Getter 로 Getter 메소드 대체
@Setter
// Lombok @Setter 로 Setter 메소드 대체
public class Order {
    private Long memberId; // 주문 회원 id
    private String itemName; // item 이름
    private int itemPrice; // item 금액
    private int discountPrice; // 할인 금액

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    // 계산된 결과
    public int calculatePrice() {
        return itemPrice - discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}