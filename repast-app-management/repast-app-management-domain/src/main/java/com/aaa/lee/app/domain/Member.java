package com.aaa.lee.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "ums_member")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shopId;

    private Long memberLevelId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 帐号启用状态:0->禁用；1->启用
     */
    private Integer status;

    /**
     * 注册时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 头像
     */
    private String icon;

    /**
     * 性别：0->未知；1->男；2->女
     */
    private Integer gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 所做城市
     */
    private String city;

    /**
     * 职业
     */
    private String job;

    /**
     * 个性签名
     */
    private String personalizedSignature;

    /**
     * 用户来源
     */
    private Integer sourceType;

    /**
     * 积分
     */
    private Integer integration;

    /**
     * 成长值
     */
    private Integer growth;

    /**
     * 剩余抽奖次数
     */

    private Integer luckeyCount;

    /**
     * 历史积分数量
     */

    private Integer historyIntegration;

    private Long parentId;

    /**
     * 微信返回的open_id
     */
    private String openId;

    /**
     * 微信返回的session_key
     */
    private String sessionKey;

    /**
     * 登录验证token
     */
    private String token;

}