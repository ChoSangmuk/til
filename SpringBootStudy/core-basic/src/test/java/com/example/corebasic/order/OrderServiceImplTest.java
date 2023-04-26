package com.example.corebasic.order;

import com.example.corebasic.discount.FixDiscountPolicy;
import com.example.corebasic.member.Grade;
import com.example.corebasic.member.Member;
import com.example.corebasic.member.MemberRepository;
import com.example.corebasic.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {
    @Test
    @DisplayName("생성자 주입 권장, 순수 자바 테스트")
    void createOrder() {
        // given
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "userA", Grade.VIP));
        /*
         OrderServiceImpl 을 수정자 주입으로 변경하고 테스트하는 경우, 실행은 되지만 Null Point Exception 발생
         OrderServiceImpl orderService = new OrderServiceImpl(); // IDE 경고(error) 없음

         OrderServiceImpl 을 생성자 주입으로 변경하면 IDE 는 바로 경고를 표시하며 실행 시, 컴파일 오류를 발생시킴
         OrderServiceImpl orderService = new OrderServiceImpl(); // IDE 경고(error) 표시
        */
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());

        // when
        Order order = orderService.createOrder(1L, "itemA", 20000);

        // then
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}