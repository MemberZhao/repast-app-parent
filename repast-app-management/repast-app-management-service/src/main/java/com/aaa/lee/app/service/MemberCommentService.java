package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.MemberComment;
import com.aaa.lee.app.domain.MemberCommentReplay;
import com.aaa.lee.app.mapper.MemberCommentMapper;
import com.aaa.lee.app.mapper.MemberCommentReplayMapper;
import com.aaa.lee.app.vo.CommentProVo;
import com.aaa.lee.app.vo.MemberCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author Whc
 * @Date 2019/11/23 19:05
 * @Description
 **/

@Service
public class MemberCommentService extends BaseService<MemberComment> {

    @Autowired
    private MemberCommentMapper memberCommentMapper;

    @Autowired
    private MemberCommentReplayMapper memberCommentReplayMapper;

    @Override
    public Mapper<MemberComment> getMapper() {

        return memberCommentMapper;
    }

    /**
     * 通过主键查询评价信息（包装类型
     * @param token
     * @param token
     * @return
     */
    public List<MemberCommentVo> getMemberComment(String token){
        if(null != token || !"".equals(token)){
            Member memberByToken = memberCommentMapper.getMemberByToken(token);
            System.out.println("commentservice进入了");
            List<MemberCommentVo> memberCommentVos = memberCommentMapper.selectMemberComment(memberByToken.getId());
            System.out.println("该用户的陪你国家为为"+memberCommentVos.toString());
            if(memberCommentVos.size() > 0){
                System.out.println("查询shshshshshh");
                for (MemberCommentVo mcm : memberCommentVos) {
                    Long orderId = mcm.getOrderId();
                    Long commentId = mcm.getId();
                    Long productId = mcm.getProductId();
                    // 通过订单id查询该商品的所属的商品信息
                    List<CommentProVo> commentProVos = memberCommentMapper.selectProComment(orderId);
                    // 判断该评价信息中商品id是否为空
                    System.out.println("商品id为"+productId);
                    if(null == productId){
                        System.out.println("该订单为多个商品");
                        // 如果为空，则把商品信息存放到该订单所属的评价里
                        mcm.setMemberCommentVos(commentProVos);
                    }else{
                        // 如果不为空，继续执行；
                        continue;
                    }
                    // 通过评价id查询该评价的回复信息
                    List<MemberCommentReplay> memberCommentReplays = memberCommentReplayMapper.selectCommentReplay(commentId);

                    // 把回复信息存放到评价里
                    mcm.setCommentReplays(memberCommentReplays);
                }
                System.out.println("该订单的内容有"+memberCommentVos);
                return memberCommentVos;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    /**
     * 通过主键删除信息
     * @param id
     * @return
     */
    public Boolean deleteComment(Long id,String token){
        if(null != token || !"".equals(token)){
            int i = memberCommentMapper.updateCommentStatus(id);
            if(i > 0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * 添加评论信息
     * @param comment
     * @return
     */
    public Boolean addComment(MemberComment comment, String token) {
        if (null != token || !"".equals(token)) {
            Member member = memberCommentMapper.getMemberByToken(token);
            comment.setMemberNickName(member.getNickname());
            comment.setMemberIcon(member.getIcon());
            Long orderId = comment.getOrderId();
            System.out.println("id为" + orderId);
            // 通过订单id查询该商品的所属的商品信息
            List<CommentProVo> commentProVos = memberCommentMapper.selectProComment(orderId);
            System.out.println("订单查询" + commentProVos.toString());
            if (commentProVos.size() == 1) {
                // 如果该订单中为单个商品,则添加到评价表中
                for (CommentProVo commentProVo : commentProVos) {
                    Long orderId1 = comment.getOrderId();
                    Long productId = commentProVo.getProductId();
                    String productName = commentProVo.getProductName();
                    String name = commentProVo.getName();
                    comment.setOrderId(orderId1);
                    comment.setProductId(productId);
                    comment.setProductName(productName);
                    comment.setProductAttribute(name);
                }
                System.out.println("添加的值为" + comment);
            }
            //获取当前时间
            Date date = new Date();
            String formatDate = null;
            //HH表示24小时制；
            DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            formatDate = dFormat.format(date);
            SimpleDateFormat lsdStrFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date strD = null;
            try {
                strD = lsdStrFormat.parse(formatDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // 把当前时间添加到数据库
            comment.setCreateTime(strD);
            comment.setShowStatus(0);
            int insert = memberCommentMapper.insert(comment);
            if (insert > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
