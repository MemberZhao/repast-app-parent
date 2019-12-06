package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.MemberReceiveAddress;
import com.aaa.lee.app.service.MemberReceiveAddressService;
import com.aaa.lee.app.service.MemberService;
import com.aaa.lee.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 10:38
 * @Description
 **/
@RestController
public class MemberReceiveAddressController {

    @Autowired
    private MemberReceiveAddressService memberReceiveAddressService;
    @Autowired
    private RedisService redisService;
    /**
     * @author Seven Lee
     * @description
     *      通用会员id获取会员收获地址列表
     * @param
     * @date 2019/11/21
     * @return java.util.List<com.aaa.lee.app.domain.MemberReceiveAddress>
     * @throws
     **/
    @PostMapping("/receive")
    public List<MemberReceiveAddress> getMemberReceiveAddress(@RequestParam("token") String token) {
        return memberReceiveAddressService.getMemberReceiveAddress(token);
    }

    /**
     * 修改会员表的收货地址
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/updateSite")
    public boolean updateSite(@RequestBody MemberReceiveAddress memberReceiveAddress , String token){
        return  memberReceiveAddressService.upSite(memberReceiveAddress,token);
    }

    /**
     * 添加收货地址
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/insertSite")
    public boolean insertSite(@RequestBody MemberReceiveAddress memberReceiveAddress,String token){
        return memberReceiveAddressService.insertSite(memberReceiveAddress,token);
    }
    /**
     * 根据id删除收货地址
     * @param id
     * @return
     */
    @PostMapping("/delSite")
    public boolean delSite(@RequestParam("id")Long id, String token){
        return memberReceiveAddressService.delSite(id,token);
    }
}
