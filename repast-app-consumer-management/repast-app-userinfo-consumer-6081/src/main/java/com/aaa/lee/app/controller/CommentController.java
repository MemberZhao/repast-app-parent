package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.MemberComment;
import com.aaa.lee.app.service.IRepastService;
import com.aaa.lee.app.vo.MemberCommentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Whc
 * @Date 2019/11/28 14:22
 * @Description
 **/

@RestController
@Api(value = "评价信息", tags = "评价信息接口")
public class CommentController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * 通过会员id获取评价信息
     * @return
     */
    @GetMapping("/comment")
    @ApiOperation(value = "查询评价信息", notes = "获取会员评价信息列表")
    public ResultData getMemberComment(String token){
        System.out.println("消费者评价"+token);
        List<MemberCommentVo> memberComment = repastService.getMemberComment(token);
        if(memberComment.size() > 0){
            return querySuccess("查询成功",memberComment);
        }else{
            return queryFailed("查询失败");
        }
    }

    /**
     * 通过主键删除评价信息
     * @param id
     * @return
     */
    @GetMapping("/delComment")
    @ApiOperation(value = "删除评价信息", notes = "删除评价信息")
    public ResultData deleteComment(Long id, String token){
        if(repastService.deleteComment(id,token)){
            return delSuccess("删除成功");
        }else{
            return delFailed("删除失败");
        }
    }

    /**
     * 添加用户评价信息
     * @param comment
     * @return
     */
    @PostMapping("/addComment")
    @ApiOperation(value = "添加评价信息", notes = "添加评价信息功能")
    public ResultData insertComment(MemberComment comment, String token){
        if(repastService.insertComment(comment,token)){
            return addSuccess("添加成功");
        }else{
            return addFailed("添加失败");
        }
    }



}
