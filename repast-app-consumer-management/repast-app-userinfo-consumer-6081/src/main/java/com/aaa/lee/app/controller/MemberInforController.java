package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户controller
 */

@RestController
@Api(value = "用户信息", tags = "用户信息接口")
public class MemberInforController extends BaseController {
    @Autowired
    private IRepastService repastService;

    /**
     * 通过id查询用户信息
     * @param memberId
     * @return
     */
    @GetMapping("/getMemberId")
    @ApiOperation(value = "用户信息", notes = "通过id查询用户信息")
    public ResultData getMemeberById(Long memberId){
        Member memberInfor = repastService.getMemberById(memberId);
        if (null != memberInfor){
            return success(memberInfor);}

        else {
            return failed();
        }


    }
    @PostMapping("/updateMemberId")
    @ApiOperation(value = "用户信息",notes = "通过id修改用户信息")
    public ResultData updateMemberById(@RequestBody Member member){
        int i = repastService.updateMemberById(member);

        if (i==1){
            return success();
        }else {
            return failed();
        }

    }
}
