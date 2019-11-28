package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Coupon;
import com.aaa.lee.app.domain.CouponHistory;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.vo.MemberAllCouponVO;
import com.aaa.lee.app.vo.UsableCouponVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface CouponMapper extends Mapper<Coupon> {

    Long checkCouponStatusFromAllCouponList(Map m);

    int checkCouponStatusFromMemberListByCouponHistoryId(Map m);

    int useConponByCouponHistoryId(Long id);

    String getCouponEndTimeByCouponId(Long couponId);

    int collectCoupons(CouponHistory couponHistory);

    List<UsableCouponVO> getAllUsableCoupons(Long memberLevel);

    List<MemberAllCouponVO> getAllCouponsByMemberId(Long id);

    List<MemberAllCouponVO> getUsableCouponsByMemberId(Long id);

    List<MemberAllCouponVO> getDisableCouponsByMemberId(Long id);

    List<MemberAllCouponVO> getUsableCouponsByMemberIdAndShopId(Member m);

    boolean setAutoInvalid(Map<String, String> m);

    boolean removeAutoInvalid(Map<String, String> m);

}
