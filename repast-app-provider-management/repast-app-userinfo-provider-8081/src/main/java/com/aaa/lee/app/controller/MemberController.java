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

    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     * @param [member]
     * @date 2019/11/21
     * @return java.lang.Boolean
     * @throws 
    **/
    @PostMapping("/login")
    public Boolean doLogin(@RequestBody Member member) {
        return memberService.doLogin(member, redisService);
    }
    /**
     * @author Memer Zhao
     * @date 2019/11/22 9:16 
     * @description 
     * @param 
     * @return 
     **/
    @GetMapping("/getMemberBalance")
    public List<Member> getMemberBalance(){
        return memberService.getMemberBalance(redisService);
    }
    /**
     * @author Memer Zhao
     * @date 2019/11/22 9:28
     * @description
     * @param
     * @return
     **/
    @GetMapping("/updateMemberBalance")
    public Boolean payForMemberBalance(int money){

        return  memberService.updateMemberBalance(money,redisService);
    }
}
