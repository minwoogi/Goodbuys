package com.tu.goodsbuy.member;

public interface MemberRepsitory {

    void save(Member member);

    Member findById(Long memberId);
}
