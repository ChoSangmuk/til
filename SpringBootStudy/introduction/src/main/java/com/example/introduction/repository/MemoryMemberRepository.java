package com.example.introduction.repository;

import com.example.introduction.domain.Member;

import java.util.*;

// MemberRepository 인터페이스의 구현체로, 메모리 상에서 Member 객체를 관리할 저장소
public class MemoryMemberRepository implements MemberRepository {

    /*
     Key - Value 형태로 데이터를 저장하기 위해 HashMap을 사용
     실무에서는 동시성 문제가 발생함으로 ConcurrentHashMap 사용을 권장
    */
    private static final Map<Long, Member> store = new HashMap<>();
    // 시스템에서 자동으로 생성되는 id를 부여하기 위해 sequence라는 변수 사용
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // HashMap.get의 결과가 null일 수 있음으로 Optional.ofNullable로 감싸서 반환
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // findByName 구현 시, 반복문을 사용하는 대신 Java 8에 추가된 Stream과 Lambda를 사용
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
