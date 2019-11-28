package com.aaa.lee.app.service;


import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.CouponHistory;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.mapper.CouponMapper;
import com.aaa.lee.app.utils.DateUtil;
import com.aaa.lee.app.vo.MemberAllCouponVO;
import com.aaa.lee.app.vo.UsableCouponVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.app.staticstatus.StaticProperties.*;

@Service
public class CouponService {

    @Autowired
    private CouponMapper couponMapper;

    /**
     * 查询领券中心用户所有的可见优惠券信息
     * @return
     **/
    public List<UsableCouponVO> getAllUsableCoupons(Long memberLevel){
        return couponMapper.getAllUsableCoupons(memberLevel);
    }

    /**
     * 查询用户所有优惠券
     * @return
     **/
    public List<MemberAllCouponVO> getAllCouponsByMemberId(Long id){
        return couponMapper.getAllCouponsByMemberId(id);

    }

    /**
     * 获取用户所有可用优惠券
     * @return
     **/
    public List<MemberAllCouponVO> getUsableCouponsByMemberId(Long id){
        return couponMapper.getUsableCouponsByMemberId(id);
    }

    /**
     * 获取用户所有不可用优惠券
     * @return
     **/
    public List<MemberAllCouponVO> getDisableCouponsByMemberId(Long id){
        return couponMapper.getDisableCouponsByMemberId(id);
    }

    /**
     * 获取用户在当前店铺所有可用优惠券
     * @return
     **/
    public List<MemberAllCouponVO> getUsableCouponsByMemberIdAndShopId(Member m, Long shopId){
        if(null != shopId || "".equals(shopId)){
            m.setShopId(shopId);
            return couponMapper.getUsableCouponsByMemberIdAndShopId(m);
        }
        return null;
    }

    /**
     * 优惠券领取事务
     * @return
     **/
    @Transactional
    public boolean receiveCouponAffair(Long shopId, Long couponId,String endTime, Member m) throws RuntimeException{
            Long receiveHistoryId = receiveCoupon(shopId, couponId, m);
            if (null != receiveHistoryId){
                boolean b = setAutoInvalid(receiveHistoryId, endTime);
                return b;
            }
        return false;
    }

    /**
     * 优惠券使用事务
     **/
    @Transactional
    public boolean useCouponAffair(Long couponHistoryId) throws RuntimeException{
        if (removeAutoInvalid(couponHistoryId)){
            int i = useConponByCouponHistoryId(couponHistoryId);
            if (i > 0){
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * 检查优惠券状态是否可领取
     **/
    public Long checkCouponStatusFromAllCouponList(Long couponId, Long memberId) {
        Map<String, Long> m = new HashMap<String, Long>(2);
        m.put(COUPONID,couponId);
        m.put(MEMBERID, memberId);
        return couponMapper.checkCouponStatusFromAllCouponList(m);
    }

    /**
     * 检查优惠券状态是否可用
     **/
    public int checkCouponStatusFromMemberListByCouponHistoryId(Long id, Double amount){
        Map<String, Object> m = new HashMap<String, Object>(2);
        m.put(RECEIVEHISTORYID, id);
        m.put(AMOUNT, amount);
        return couponMapper.checkCouponStatusFromMemberListByCouponHistoryId(m);
    }

    /**
     * 获取优惠券失效时间
     **/
    public String getCouponEndTimeByCouponId(Long id) {
        return couponMapper.getCouponEndTimeByCouponId(id);
    }

    /**
     * 领取优惠券
     **/
    public Long receiveCoupon(Long shopId, Long couponId, Member m){
        CouponHistory couponHistory = new CouponHistory();
        couponHistory.setCouponId(couponId);
        couponHistory.setShopId(shopId);
        couponHistory.setMemberId(m.getId());
        couponHistory.setMemberNickname(m.getNickname());
        couponHistory.setUseStatus(USABLE);

        couponHistory.setCreateTime(DateUtil.formatDate(new Date()));
        if (0 < couponMapper.collectCoupons(couponHistory)){
            return couponHistory.getId();
        }
        return null;
    }

    /**
     * 使用优惠券
     **/
    public int useConponByCouponHistoryId(Long id){
        return couponMapper.useConponByCouponHistoryId(id);
    }

    /**
     * 设置优惠券自动失效
     **/
    public boolean setAutoInvalid(Long receiveHistoryId, String endTime){
        Map<String, String> map = new HashMap<String, String>(4);
        map.put(EVENTNAME,AUTOINVALID+receiveHistoryId.toString());
        map.put(ENDTIME,endTime);
        map.put(USESTATUS,EXPIRED.toString());
        map.put(RECEIVEHISTORYID,receiveHistoryId.toString());
        return !couponMapper.setAutoInvalid(map);
    }

    /**
     * 移除优惠券自动失效
     **/
    public boolean removeAutoInvalid(Long receiveHistoryId) throws RuntimeException{
        Map<String, String> m = new HashMap<String, String>(1);
        m.put(EVENTNAME,AUTOINVALID+receiveHistoryId.toString());
        try {
            return !couponMapper.removeAutoInvalid(m);
        } catch (Exception e){
            e.printStackTrace();

            throw new RuntimeException("优惠券已过期");
        }
    }




}
