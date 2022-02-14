package com.example.corebasic.member;

public class MemberServiceImpl implements MemberService {
    /*
     초기 설계에서는 MemberRepository 인터페이스의 구현체인 MemoryMemberRepository 를 직접 생성하여 사용
     private final MemberRepository memberRepository = new MemoryMemberRepository();

     MemberServiceImpl 에서 MemberRepository 의 구현체가 아닌 인터페이스에만 의존하게끔 변경 -> DIP 원칙 준수
     생성지를 통해 MemberRepository 구현체(의존성)를 받아와서(주입) 사용함 -> 생성자를 통한 의존성 주입
    */
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // MemberServiceImpl 는 어떤 구현체를 사용하게 될지 알고있을 필요 없이 본인의 역할만 수행하면됨

    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}