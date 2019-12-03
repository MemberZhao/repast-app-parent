package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.MemberComplain;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Whc
 * @Date 2019/11/28 20:20
 * @Description
 **/

@RestController
@Api(value = "意见反馈（投诉）信息", tags = "意见反馈信息接口")
public class ComplainController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * 添加意见(投诉)信息
     * @param complain
     * @return
     */
    @PostMapping("/addComplain")
    @ApiOperation(value = "添加用户意见信息", notes = "添加用户意见信息功能")
    public ResultData insertComplain(MemberComplain complain,String token){
        if(repastService.insertComplain(complain,token)){
            return addSuccess("提交成功");
        }else{
            return addFailed("提交失败");
        }
    }
}
