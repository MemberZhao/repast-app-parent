package com.aaa.lee.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pms_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MemberComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * #店家ID
     */
    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 订单ID
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 订单为单一商品时，该字段有值
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * #评论者昵称
     */
    @Column(name = "member_nick_name")
    private String memberNickName;

    /**
     * #商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 评价星数：0->5
     */
    private Integer star;

    /**
     * 评价的ip
     */
    @Column(name = "member_ip")
    private String memberIp;

    /**
     * 
     *   #评论发表时的时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * #该商品为堂食或外卖
     */
    @Column(name = "show_status")
    private Integer showStatus;

    /**
     * 购买时的商品属性
     */
    @Column(name = "product_attribute")
    private String productAttribute;

    /**
     * #共几条评价数量
     */
    @Column(name = "collect_count")
    private Integer collectCount;

    @Column(name = "read_count")
    private Integer readCount;

    /**
     * 上传图片地址，以逗号隔开
     */
    private String pics;

    /**
     * 评论用户头像
     */
    @Column(name = "member_icon")
    private String memberIcon;

    /**
     * #该评论回复的数量
     */
    @Column(name = "replay_count")
    private Integer replayCount;

    private String content;


}