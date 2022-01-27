package com.example.introduction.service;

import com.example.introduction.domain.Member;
import com.example.introduction.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
/*
 MemberRepository 와 Member 도메인을 활용하여 실제 비즈니스 로직을 구현하는 레이어
 컴포넌트 스캔 방식과 자바 스프링 빈 설정을 비교하기위해 @Service 사용 후 삭제
 @Service

 @Transactional 어노테이션을 사용하게 되면 스프링이 해당 클래스의 메소드를 실행할 때 트랜잭션을 시작
 메소드가 정상 종료되면 트랜잭션을 커밋, 런타임 예외가 발생하면 롤백
*/
public class MemberService {

    /*
     최초 설계에서는 MemberService 안에서 직접 MemoryMemberRepository를 생성하여 사용
     private final MemberRepository memberRepository = new MemoryMemberRepository();

     But 테스트 진행 시, serviceTest에서 서로 다른 MemoryMemberRepository를 사용하는 것이 문제가 되었고,
     이를 해결하기 위해 객체를 직접 생성하는 것이 아니라 MemberService 생성자에서 MemberRepository를 주입받게끔 변경
    */
    private final MemberRepository memberRepository;

    /*
     MemberRepository를 외부에서 주입받아 사용하게끔 변경
     컴포넌트 스캔 방식과 자바 스프링 빈 설정을 비교하기위해 @Autowired 사용 후 삭제
    */
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        // MemberRepository 프록시 여부 확인
        System.out.println("memberRepository : " + memberRepository.getClass());
    }

    /**
     * 회원 가입
     *
     * @param member
     * @return member에 할당된 Id를 반환(임의 설계)
     * @Transactional 은 클래스 단위뿐만 아니라 특정 메소드에만 사용할 수도 있음
     */
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member); // member 저장
        return member.getId(); // 시스템으로부터 전달받은 member.id를 반환
    }

    /**
     * 중복 회원 검증
     *
     * @param member
     * @throws IllegalStateException - member의 name값이 이미 존재하는 경우 발생하는 Exception
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) // Optional<Member>를 반환
                .ifPresent(m -> { // Optional의 값이 존재한다면(null이 아니라면) Exception 발생
                    throw new IllegalStateException("name already exists");
                });
    }

    /**
     * 전체 회원 조회
     * 서비스 레이어는 조금 더 비즈니스에 가까운 네이밍을 사용하는 것이 바랍직함
     *
     * @return List<Member> 저장된 모든 Member 정보
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String name) {
        return memberRepository.findByName(name);
    }

    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }

}
