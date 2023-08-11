package com.tu.goodsbuy.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepsitory memberRepsitory = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepsitory.save(member);


    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepsitory.findById(memberId);
    }
}
