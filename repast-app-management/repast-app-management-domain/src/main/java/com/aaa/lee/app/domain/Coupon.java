package com.aaa.lee.app.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 优惠券表实体类
 **/
@Table(name = "sms_coupon")
@Data
@Accessors(chain = true)
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券
     */
    private int type;

    private String name;

    /**
     * 使用平台：0->全部；1->移动；2->PC
     */
    private int platform;

    /**
     * 数量
     */
    private int count;

    /**
     * 金额
     */
    private double amount;

    /**
     * 每人限领张数
     */
    @Column(name = "per_limit")
    private int perLimit;

    /**
     * 使用门槛；0表示无门槛
     */
    @Column(name = "min_point")
    private double minPoint;

    /**
     * 生效时间
     */
    @Column(name = "start_time")
    private String startTime;

    /**
     * 失效时间
     */
    @Column(name = "end_time")
    private String endTime;

    /**
     * 使用类型：0->全场通用；1->指定分类；2->指定商品
     */
    @Column(name = "use_type")
    private int useType;

    /**
     * 备注
     */
    private String note;

    /**
     * 发行数量
     */
    @Column(name = "publish_count")
    private int publishCount;

    /**
     * 已使用数量
     */
    @Column(name = "use_count")
    private int useCount;

    /**
     * 领取数量
     */
    @Column(name = "receive_count")
    private int receiveCount;

    /**
     * 可以领取的日期
     */
    @Column(name = "enable_time")
    private String enableTime;

    /**
     * 优惠码
     */
    private String code;

    @Column(name = "member_level_id")
    private Long memberLevelId;
}
