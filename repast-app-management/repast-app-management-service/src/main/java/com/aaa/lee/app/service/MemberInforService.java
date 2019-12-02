package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class MemberInforService extends BaseService<Member> {
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public Mapper<Member> getMapper() {
        return memberMapper;
    }

    /**
     * 通过id查询用户信息
     * @param memberId
     * @return
     */
    public Member getMemberInforMemberId(Long memberId){
         return memberMapper.getMemberInforMemberId(memberId);
    }


    /**
     * 通过token查询用户信息
     * @param token
     * @return
     */
    public Member getMemberInforToken(String token){
        if (null == token || "".equals(token)){
            return null;
        } else {
            List<Member> memberInfortoken = memberMapper.getMemberInforToken(token);
            if (memberInfortoken.size()>0){
                return memberInfortoken.get(0);
            }
            return null;
        }
    }

    /**
     * 通过id修改用户信息
     * @param memberId
     * @return
     */
    public int updateMemberInfoMemberId(Member member){
      return memberMapper.updateMemberInfoMemberId(member);
    }
}
