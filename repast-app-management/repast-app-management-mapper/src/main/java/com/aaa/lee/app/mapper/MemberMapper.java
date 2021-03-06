package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Member;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MemberMapper extends Mapper<Member> {
    Member getMemberInforMemberId(Long memberId);

    List<Member> getMemberInforToken(String token);

    int updateMemberInfoMemberId(Member member);

}