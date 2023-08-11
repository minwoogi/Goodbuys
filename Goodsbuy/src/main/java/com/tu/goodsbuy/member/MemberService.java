package com.tu.goodsbuy.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
