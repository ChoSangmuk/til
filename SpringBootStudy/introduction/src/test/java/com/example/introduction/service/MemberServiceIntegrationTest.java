package com.example.introduction.service;

import com.example.introduction.domain.Member;
import com.example.introduction.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
// 스프링 컨테이너와 테스트를 함께 실행, 스프링 컨테이너가 테스트에 필요한 의존성을 생성 및 주입
@Transactional
/*
 테스트는 반복 가능하며 각 테스트는 개별적으로 실행이 가능해야함(MemberServiceTest afterEach 의 역할)
 실제 DB 연결이 된 이후 부터는 각 테스트 진행 시, 트랜잭션을 시작하고 완료 후 롤백하게끔 설정
 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않음
*/
class MemberServiceIntegrationTest {

    /*
     스프링이 필요없던 MemberServiceTest에서의 방식으로, 테스트 내부에서 필요한 객체를 직접 생성해서 사용

     MemberService memberService;
     MemoryMemberRepository memoryMemberRepository;

     @BeforeEach
     void beforeEach() {
         memoryMemberRepository = new MemoryMemberRepository();
         memberService = new MemberService(memoryMemberRepository);
     }

     스프링 컨테이너로부터 의존성을 주입받아 사용할 예정임으로 DI(Field, Setter, Constructor Injection)를 사용할 수 있게끔 변경
     보통의 경우 Constructor Injection을 권장하지만 테스트 코드는 다른 곳에서 사용될 일이 없기 때문에 편하게 만드는 것을 권장(Field Injection 선택)
    */
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository; // SpringConfig 에서 설정한 MemberRepository 구현체가 주입될 예정임으로 인터페이스로 선언

    /*
     메모리 저장소(MemoryMemberRepository)를 사용하는 경우, 테스트하는 동안 저장소를 일관성 있게 유지하는 역할
     -> @Transactional 로 대체 가능함으로 해당 코드 필요없음

     @AfterEach
     void afterEach() { memoryMemberRepository.clearStore(); }
    */

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("Spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member result = memberService.findOne(saveId).get();
        assertThat(result.getName()).isEqualTo(member.getName());
    }

    @Test
    void join_fail() {
        // given
        Member member = new Member();
        member.setName("Spring");
        memberService.join(member);

        // when
        IllegalStateException result = assertThrows(IllegalStateException.class, () -> memberService.join(member));

        // then
        assertThat(result.getMessage()).isEqualTo("name already exists");
    }

    @Test
    void findMembers() {
        // given
        Member member1 = new Member();
        member1.setName("Spring1");
        memberService.join(member1);
        Member member2 = new Member();
        member2.setName("Spring2");
        memberService.join(member2);

        // when
        List<Member> result = memberService.findMembers();

        // then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findOneByName() {
        // given
        Member member1 = new Member();
        member1.setName("Spring1");
        memberService.join(member1);
        Member member2 = new Member();
        member2.setName("Spring2");
        memberService.join(member2);

        // when
        Member result = memberService.findOne("Spring1").get();

        // then
        assertThat(result.getId()).isEqualTo(member1.getId());
    }

    @Test
    void findOneById() {
        // given
        Member member1 = new Member();
        member1.setName("Spring1");
        memberService.join(member1);
        Member member2 = new Member();
        member2.setName("Spring2");
        memberService.join(member2);

        // when
        Member result = memberService.findOne(member1.getId()).get();

        // then
        assertThat(result.getId()).isEqualTo(member1.getId());
    }
}