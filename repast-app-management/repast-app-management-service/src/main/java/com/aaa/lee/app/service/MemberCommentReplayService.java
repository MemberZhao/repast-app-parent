package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.MemberCommentReplay;
import com.aaa.lee.app.mapper.MemberCommentReplayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author Whc
 * @Date 2019/12/02 09:43
 * @Description
 **/
@Service
public class MemberCommentReplayService extends BaseService<MemberCommentReplay> {

    @Autowired
    private MemberCommentReplayMapper memberCommentReplayMapper;

    @Override
    public Mapper<MemberCommentReplay> getMapper() {
        return memberCommentReplayMapper;
    }

    /**
     *通过评价主键查询改评价的油油信息回复
     * @return
     */
    public List<MemberCommentReplay> getCommentReplay(Long commentId){
        List<MemberCommentReplay> commentReplays = memberCommentReplayMapper.selectCommentReplay(commentId);
        if(null !=commentReplays && "".equals(commentReplays)){
            System.out.println("回复内容有"+commentReplays);
            return commentReplays;

        }else{
            return null;
        }

    }
    //TODO
}
