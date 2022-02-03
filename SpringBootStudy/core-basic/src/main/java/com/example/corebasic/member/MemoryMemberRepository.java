package com.example.corebasic.member;

import java.util.*;

// MemberRepository 역할을 Memory 를 이용하여 구현
public class MemoryMemberRepository implements MemberRepository {
    /*
     Key - Value 형태로 데이터를 저장하기 위해 HashMap 을 사용
     실무에서는 동시성 문제가 발생함으로 ConcurrentHashMap 사용을 권장
    */
    private static final Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}