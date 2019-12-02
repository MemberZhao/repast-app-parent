package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.MemberReceiveAddress;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 8:51
 * @Description
 *      swagger2称之为前后端分离框架
 *      使用swagger2之后，不能再使用@RequestMapping了，必须要使用@GetMapping,@PostMapping
 *
 **/
@RestController
@Api(value = "用户信息", tags = "用户信息接口")
public class MemberController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * 登录
     * @param member
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录",notes = "执行登陆操作")
    public ResultData doLogin(Member member){
        String token = repastService.doLogin(member);
        return success("登录成功",token);
    }

    /**
     * 接收用户信息
     * @param member
     * @return
     */
    @PostMapping("/userMessage")
    @ApiOperation(value = "微信",notes = "接收微信认证的信息")
    public ResultData getMessage(Member member){
        System.out.println(member);
        String token = repastService.newUser(member);
        if (null != token && "".equals(token)){
            return success("存储成功",token);
        }
        return failed("储存失败");
    }

    /**
     * @author Seven Lee
     * @description
     *      获取会员收获地址列表
     * @param []
     * @date 2019/11/21
     * @return com.aaa.lee.app.base.ResultData
     * @throws 
    **/
    @GetMapping("/receive")
    @ApiOperation(value = "收获地址", notes = "获取会员收获地址列表")
    public ResultData getMemberReceiveAddress() {
        List<MemberReceiveAddress> receiveList = repastService.getMemberReceiveAddress();
        if(receiveList.size() > 0) {
            return success(receiveList);
        } else {
            return failed();
        }
    }
}
