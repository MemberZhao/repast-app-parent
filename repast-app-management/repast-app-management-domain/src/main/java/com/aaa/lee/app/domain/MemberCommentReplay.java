package com.aaa.lee.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pms_comment_replay")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MemberCommentReplay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * #评论信息的id
     */
    @Column(name = "comment_id")
    private Long commentId;

    /**
     * #评论者的昵称
     */
    @Column(name = "member_nick_name")
    private String memberNickName;

    @Column(name = "member_icon")
    private String memberIcon;

    /**
     * #评论回复者的内容
     */
    private String content;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 评论人员类型；0->会员；1->管理员；2->商家
     */
    private Integer type;

}