package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.MemberComment;
import com.aaa.lee.app.vo.CommentProVo;
import com.aaa.lee.app.vo.MemberCommentVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MemberCommentMapper extends Mapper<MemberComment> {

    /**
     * 通过会员id查询评价信息
     * @param memberId
     * @return
     */
    List<MemberCommentVo> selectMemberComment(Long memberId);

    /**
     * 通过订单id，查询与订单有关的商品id,名称，属性名
     * @param orderId
     * @return
     */
    List<CommentProVo> selectProComment(Long orderId);

    /**
     * 通过token查询当前用户信息
     * @param token
     * @return
     */
    Member getMemberByToken(String token);
}