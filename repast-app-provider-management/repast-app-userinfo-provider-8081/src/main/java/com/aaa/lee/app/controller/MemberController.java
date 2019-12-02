package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.service.MemberService;
import com.aaa.lee.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 9:36
 * @Description
 **/
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private RedisService redisService;
    @PostMapping("/userMessage")
    public  String newUser(@RequestBody Member member)throws Exception{
        return memberService.newUser(member);
    }

    /**
     * 执行登录
     * @param member
     * @return
     */
    @PostMapping("/login")
    public String doLogin(@RequestBody Member member) throws Exception {
        return memberService.doLogin(member);
    }

}
