package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.service.CouponService;
import com.aaa.lee.app.service.MemberInforService;
import com.aaa.lee.app.service.MemberService;
import com.aaa.lee.app.service.RedisService;
import com.aaa.lee.app.vo.MemberAllCouponVO;
import com.aaa.lee.app.vo.UsableCouponVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.aaa.lee.app.staticstatus.StaticProperties.*;

@RestController
public class CouponController extends BaseController {

    @Autowired
    private MemberInforService memberInforService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private MemberService memberService;

    /**
     * 获取领券中心用户所有的可见优惠券信息
     * @return
     **/
    @GetMapping("/getUsableCoupons")
    public ResultData<List<UsableCouponVO>> getAllUsableCoupons(@RequestParam("openId") String openId){

        Member m = memberInforService.getMemberInforOpenId(openId);
        if (null != m){
            List<UsableCouponVO> allUsableCoupons = couponService.getAllUsableCoupons(m.getMemberLevelId());
            if (allUsableCoupons.size()>0){
               return super.success(allUsableCoupons);
            }
           return super.success("暂无可领取优惠券");
        }
       return super.failed();
    }

    /**
     * 获取用户所有优惠券
     * @return
     **/
    @GetMapping("/getAllCouponsByMemberId")
    public ResultData<List> getAllCouponsByMemberId(@RequestParam("openId") String openId){

        Member m = memberInforService.getMemberInforOpenId(openId);
        if (null != m){
            List<MemberAllCouponVO> allCouponsByMemberId = couponService.getAllCouponsByMemberId(m.getId());
            if (allCouponsByMemberId.size()>0){
                return super.success(allCouponsByMemberId);
            }
            return super.success("用户暂无优惠券");
        }
        return super.failed();
    }

    /**
     * 获取用户所有可用优惠券
     * @return
     **/
    @GetMapping("/getUsableCouponsByMemberId")
    ResultData<List> getUsableCouponsByMemberId(@RequestParam("openId") String openId){

        Member m = memberInforService.getMemberInforOpenId(openId);
        if (null != m){
            List<MemberAllCouponVO> usableCouponsByMemberId = couponService.getUsableCouponsByMemberId(m.getId());
            if (usableCouponsByMemberId.size()>0){
                return super.success(usableCouponsByMemberId);
            }
            return super.success("用户暂无可用优惠券");
        }
        return super.failed();
    }

    /**
     * 获取用户所有不可用优惠券
     * @return
     **/
    @GetMapping("/getDisableCouponsByMemberId")
    public ResultData<List> getDisableCouponsByMemberId(@RequestParam("openId") String openId){

        Member m = memberInforService.getMemberInforOpenId(openId);
        if (null != m){
            List<MemberAllCouponVO> disableCouponsByMemberId = couponService.getDisableCouponsByMemberId(m.getId());
            if (disableCouponsByMemberId.size()>0){
                return super.success(disableCouponsByMemberId);
            }
            return super.success("用户暂无可用优惠券");
        }
        return super.failed();
    }

    /**
     * 获取用户在当前店铺所有可用优惠券
     * @return
     **/
    @GetMapping("/getUsableCouponsByMemberIdAndShopId")
    public ResultData<List> getUsableCouponsByMemberIdAndShopId(@RequestParam("shopId") Long shopId, @RequestParam("openId") String openId){

        Member m = memberInforService.getMemberInforOpenId(openId);
        if (null != m){
            List<MemberAllCouponVO> usableCouponsByMemberIdAndShopId = couponService.getUsableCouponsByMemberIdAndShopId(m, shopId);
            if (null == usableCouponsByMemberIdAndShopId){
                return super.success("无法获取商铺信息");
            }
            if (usableCouponsByMemberIdAndShopId.size()>0){
                return super.success(usableCouponsByMemberIdAndShopId);
            }
            return super.success("用户暂无可用优惠券");
        }
        return super.failed();
    }

    /**
     * 领取优惠券
     * @return
     **/
    @GetMapping("/receiveCouponAffair")
    public ResultData receiveCouponAffair(@RequestParam("couponId") Long couponId, @RequestParam("openId") String openId){

        Member m = memberInforService.getMemberInforOpenId(openId);
        if (null != m){
            Long l = couponService.checkCouponStatusFromAllCouponList(couponId, m.getId());
            if (null != l || "".equals(l)){
                String endTime = couponService.getCouponEndTimeByCouponId(couponId);
                if(null != endTime || !"".equals(endTime)){
                    try {
                        couponService.receiveCouponAffair(l, couponId, endTime, m);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return super.success("操作失败");
                    }
                }
                return super.success("添加成功");
            }
            return super.success("优惠券已过期或已领取到达上限");
        }
        return super.failed();
    }

    /**
     * 使用优惠券
     * @return
     **/
    @GetMapping("/useCouponAffair")
    public ResultData useCouponAffair(@RequestParam("couponHistoryId") Long couponHistoryId, @RequestParam("openId") String openId, @RequestParam("amount") Double amount){

        Member m = memberInforService.getMemberInforOpenId(openId);
        if (null != m){
            int i = couponService.checkCouponStatusFromMemberListByCouponHistoryId(couponHistoryId, amount);
            if (i > 0) {
                if (couponService.useCouponAffair(couponHistoryId)){
                    return super.success("OK");
                }
                return super.success("操作失败");
            }
            return super.success("优惠券不可用");
        }
        return super.failed();
    }
}

