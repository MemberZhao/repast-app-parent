package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.service.IRepastService;
import com.aaa.lee.app.vo.UsableCouponVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "优惠券模块", tags = "优惠券信息接口")
public class CouponController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * 获取领券中心用户所有的可见优惠券信息
     * @return
     **/
    @GetMapping("/getUsableCoupons")
    @ApiOperation(value = "获取领券中心用户所有的可见优惠券信息", notes = "获取领券中心用户所有的可见优惠券信息")
    public ResultData<List<UsableCouponVO>> getAllUsableCoupons(String token){
        return repastService.getAllUsableCoupons(token);
    }

   /**
     * 获取用户所有优惠券
     * @return
     **/
    @GetMapping("/getAllCouponsByMemberId")
    @ApiOperation(value = "获取用户所有优惠券", notes = "获取用户所有优惠券")
    public ResultData<List> getAllCouponsByMemberId(String token){
        return repastService.getAllCouponsByMemberId(token);
    }

    /**
     * 获取用户所有可用优惠券
     * @return
     **/
    @GetMapping("/getUsableCouponsByMemberId")
    @ApiOperation(value = "获取用户所有可用优惠券", notes = "获取用户所有可用优惠券")
    public ResultData<List> getUsableCouponsByMemberId( String token){
        return repastService.getUsableCouponsByMemberId(token);
    }

    /**
     * 获取用户所有不可用优惠券
     * @return
     **/
    @GetMapping("/getDisableCouponsByMemberId")
    @ApiOperation(value = "获取用户所有不可用优惠券", notes = "获取用户所有不可用优惠券")
    public ResultData<List> getDisableCouponsByMemberId( String token){
        return repastService.getDisableCouponsByMemberId(token);
    }

    /**
     * 获取用户当前店铺所有可用优惠券
     * @return
     **/
    @GetMapping("/getUsableCouponsByMemberIdAndShopId")
    @ApiOperation(value = "获取用户当前店铺所有可用优惠券", notes = "获取用户当前店铺所有可用优惠券")
    public ResultData<List> getUsableCouponsByMemberIdAndShopId(Long shopId, String token){
        return repastService.getUsableCouponsByMemberIdAndShopId(shopId, token);
    }

    /**
     * 领取优惠券
     * @return
     **/
    @GetMapping("/receiveCouponAffair")
    @ApiOperation(value = "领取优惠券", notes = "当前用户领取可领取优惠券")
    public ResultData receiveCouponAffair(Long couponId, String token){
        return repastService.receiveCouponAffair(couponId, token);
    }

    /**
     * 使用优惠券
     * @return
     **/
    @GetMapping("/useCouponAffair")
    @ApiOperation(value = "使用优惠券", notes = "使用当前用户可用优惠券")
    public ResultData useCouponAffair(Long couponHistoryId, String token, Double amount){
        return repastService.useCouponAffair(couponHistoryId, token, amount);
    }

}
