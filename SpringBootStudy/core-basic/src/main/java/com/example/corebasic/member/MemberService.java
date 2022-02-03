package com.example.corebasic.member;

public interface MemberService {
    /**
     * 회원 가입
     *
     * @param member 저장하고자 하는 회원 정보
     */
    public void join(Member member);

    /**
     * 회원 조회
     *
     * @param memberId 회원의 id
     * @return 회원 id 조회 결과
     */
    public Member findMember(Long memberId);
}