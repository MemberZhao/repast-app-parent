package com.aaa.lee.app.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 优惠券和产品关系表实体类
 **/
@Table(name = "sms_coupon_product_relation")
@Data
@Accessors(chain = true)
public class CouponProductRelation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "product_id")
    private Long productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品编码
     */
    @Column(name = "product_sn")
    private String productSn;

}
