package com.example.corebasic.member;

public class MemberServiceImpl implements MemberService {
    //초기 설계에서는 MemberRepository 인터페이스의 구현체인 MemoryMemberRepository 를 직접 생성하여 사용
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public void join(Member member) {
        // 다형성에 의해서 MemberRepository 구현체(MemoryMemberRepository)의 save 가 호출됨
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}