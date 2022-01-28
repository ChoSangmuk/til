package com.example.corebasic.member;

public interface MemberRepository {

    /**
     * 회원 데이터 저장
     *
     * @param member 회원 정보
     */
    void save(Member member);

    /**
     * 회원 id로 회원을 찾는 기능
     *
     * @param memberId 찾고자하는 회원의 id
     * @return 조회된 회원 정보
     */
    Member findById(Long memberId);
}
