package com.aaa.lee.app.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;


/**
 * 优惠券领取，使用历史表实体类
 **/
@Table(name = "sms_coupon_history")
@Data
@Accessors(chain = true)
public class CouponHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "coupon_code")
    private String couponCode;

    /**
     * 领取人昵称
     */
    @Column(name = "member_nickname")
    private String memberNickname;

    /**
     * 获取类型：0->后台赠送；1->主动获取
     */
    @Column(name = "get_type")
    private int getType;

    /**
     * 获取时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 使用状态：0->未使用；1->已使用；2->已过期
     */
    @Column(name = "use_status")
    private int useStatus;

    /**
     * 使用时间
     */
    @Column(name = "use_time")
    private String useTime;

    /**
     * 订单编号
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 订单号码
     */
    @Column(name = "order_sn")
    private String orderSn;


}
