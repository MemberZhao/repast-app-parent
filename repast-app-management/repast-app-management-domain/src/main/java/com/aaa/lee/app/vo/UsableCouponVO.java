package com.aaa.lee.app.vo;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class UsableCouponVO {

    private Long id;

    private String name;

    /**
     * 使用平台：0->全部；1->移动；2->PC
     */
    private int platform;

    /**
     * 金额
     */
    private double amount;

    /**
     * 生效时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 失效时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 使用类型：0->全场通用；1->指定分类；2->指定商品
     */
    @Column(name = "use_type")
    private int useType;

    /**
     * 产品分类名称
     */
    @Column(name = "product_category_name")
    private String productCategoryName;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商铺名称
     */
    @Column(name = "shop_name")
    private String shopName;

}
