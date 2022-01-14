package com.example.introduction.repository;

import com.example.introduction.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
 MemoryMemberRepository에 대한 검증이 필요하며 단순하게는 Main 메소드를 작성하거나 서비스를 작동시켜 수기로 테스트를 진행할 수 있음
 그러나 이러한 방식은 반복 및 동시 실행이 어려우며 시간도 오래 걸리는데, 이를 위해 등장한 것이 JUnit 프레임 워크
 Test 하위에 소스를 작성하며, 관례적으로 테스트하고자 하는 클래스명+Test를 붙여 명명

 테스트 코드를 먼저 작성한 후 요구사항을 구현하는 TDD 방법론이라고 함
*/
class MemoryMemberRepositoryTest {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    /*
     각각의 테스트는 상호 독립적이면서 순서 등 의존 관계가 있어서는 안됨. But 한번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남을 수 있음
     @AfterEach를 사용하면 각 테스트가 종료될 때 마다 해당 메소드를 실행하여 @Test 간의 독립성을 보장할 수 있음
    */
    void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    /*
     @Test 어노테이션을 사용한 메소드는 독립적으로 실행 가능한 단위 테스트이며, 해당 메소드 안에서 작성한 클래스를 검증(실제로 이용해봄)
     given - when - then를 분리하여 테스트 코드를 작성
    */
    void save() {
        // given - Member 객체을 임의로 생성하고 name을 설정
        Member member = new Member();
        member.setName("Spring");

        // when - save를 통해 member 객체를 저장. 이떄, 원본 객체(member)에 id가 생성
        memoryMemberRepository.save(member);

        // then - findById에 member의 id를 입력하면 member와 일치하는 값을 가진 객체가 반환되어야함
        // findById의 반환 타입은 Optional이며, get을 통해 반환된 객체를 사용할 수 있음(좋은 방법은 아님)
        Member result = memoryMemberRepository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findByName() {
        // given - 정확한 테스트 진행을 위해 서로 다른 Member 객체를 2개 생성하고 save 해둠
        Member member1 = new Member();
        member1.setName("Spring1");
        memoryMemberRepository.save(member1);
        Member member2 = new Member();
        member2.setName("Spring2");
        memoryMemberRepository.save(member2);

        // when - member1의 name인 Spring1로 Member를 조회
        Member result = memoryMemberRepository.findByName("Spring1").get();

        // then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member();
        member1.setName("Spring1");
        memoryMemberRepository.save(member1);
        Member member2 = new Member();
        member2.setName("Spring2");
        memoryMemberRepository.save(member2);

        // when
        List<Member> result = memoryMemberRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
    }
}