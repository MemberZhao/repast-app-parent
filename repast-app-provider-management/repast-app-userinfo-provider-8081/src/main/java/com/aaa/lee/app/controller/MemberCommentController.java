package com.aaa.lee.app.controller;


import com.aaa.lee.app.domain.MemberComment;
import com.aaa.lee.app.service.MemberCommentService;
import com.aaa.lee.app.service.MemberService;
import com.aaa.lee.app.vo.MemberCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author Whc
 * @Date 2019/11/23 18:57
 * @Description
 **/

@RestController
public class MemberCommentController {

    @Autowired
    private MemberCommentService memberCommentService;




    /**
     * 通过会员id查询评价信息
     * @return
     */
    @GetMapping("/comment")
    public List<MemberCommentVo> getMemberComment(@RequestParam("token") String token){
        List<MemberCommentVo> memberComment = memberCommentService.getMemberComment(token);
        return memberComment;
    }

    /**
     * 通过id删除评价信息
     * @param id
     * @return
     */
    @GetMapping("/delComment")
    public Boolean deleteComment(@RequestParam("id") Long id,@RequestParam("token") String token){
        if( memberCommentService.deleteComment(id,token)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 添加评价信息
     * @param comment
     * @return
     */
    @PostMapping("/addComment")
    public Boolean addComment(@RequestBody MemberComment comment, @RequestParam("token") String token){
        if( memberCommentService.addComment(comment, token)){
            return true;
        }else{
            return false;
        }

    }

}
