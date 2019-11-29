package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.service.MemberInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberInfoController {
    @Autowired
    private MemberInforService memberInforService;
    /**
     * 通过id查询用户信息
     * @param memberId
     * @return
     */
    @GetMapping("/getMemberId")
     public Member getMemberById (@RequestParam("memberId") Long memberId){
        return memberInforService.getMemberInforMemberId(memberId);


    }

    /**
     * 根据id修改用户信息
     * @param memberId
     * @return
     */
    @PostMapping ("/updateMemberId")
    public int updateMemberById(@RequestBody Member member){

        System.out.println(member);
        return memberInforService.updateMemberInfoMemberId(member);
    }

}
