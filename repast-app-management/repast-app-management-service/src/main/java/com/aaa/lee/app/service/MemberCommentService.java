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
            List<MemberCommentVo> memberCommentVos = memberCommentMapper.selectMemberComment(memberByToken.getId());
            if(memberCommentVos.size() > 0){
                for (MemberCommentVo mcm : memberCommentVos) {
                    Long orderId = mcm.getOrderId();
                    Long commentId = mcm.getId();
                    List<CommentProVo> commentProVos = memberCommentMapper.selectProComment(orderId);
                    List<MemberCommentReplay> memberCommentReplays = memberCommentReplayMapper.selectCommentReplay(commentId);
                    mcm.setMemberCommentVos(commentProVos);
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
            int i = memberCommentMapper.deleteByPrimaryKey(id);
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
    public Boolean addComment(MemberComment comment, String token){
        if(null != token || !"".equals(token)){
            Member member = memberCommentMapper.getMemberByToken(token);
            comment.setMemberNickName(member.getNickname());
            comment.setMemberIcon(member.getIcon());
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
            comment.setCreateTime(strD);
            int insert = memberCommentMapper.insert(comment);
            if(insert >0){
                return  true;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }
}
