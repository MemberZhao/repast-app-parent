package com.aaa.lee.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "ums_complain")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MemberComplain implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "member_nick_name")
    private String memberNickName;

    /**
     * 综合评分星级
     */
    private Integer star;

    /**
     * 问题类型
     */
    @Column(name = "question_type")
    private String questionType;

    /**
     * 内容描述
     */
    private String content;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 用户创建时间
     */
    @Column(name = "create_time")
    private Date createTime;


}