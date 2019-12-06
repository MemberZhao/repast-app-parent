package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "收藏信息",tags = "用户收藏接口")
public class CollectController extends BaseController {
    @Autowired
    private IRepastService repastService;
    /**
     * 点击单品收藏
     * @param collect
     * @return
     */
    @PostMapping("/toCollect")
    @ApiOperation(value = "收藏单品", notes = "执行收藏单品操作")
    public ResultData collectProduct(Long productId, String token) {
       return repastService.toCollect(productId, token);
    }

    /**
     * 点击订单收藏
     * @param collect
     * @return
     */
    @PostMapping("/toCollectOrder")
    @ApiOperation(value = "收藏订单", notes = "执行收藏订单操作")
    public ResultData toCollectOrder(Long orderId, String token) {
       return repastService.toCollectOrder(orderId,token);
    }
    /**
     * 查询用户所有单品的收藏
     * @param
     * @return
     */
    @GetMapping("/selectAllCollectProduct")
    @ApiOperation(value = "查询所有收藏单品", notes = "查询所有的单品的收藏")
    public ResultData selectAllCollectProduct(String token) {
      return repastService.selectAllCollectProduct(token);
    }
    /**
     * 查询用户所有订单的收藏
     * @param
     * @return
     */
    @GetMapping("/selectAllCollectOrder")
    @ApiOperation(value = "查询所有收藏订单", notes = "查询该用户所有的收藏订单")
    public ResultData selectAllCollectOrder(String token) {
        return repastService.selectAllCollectOrder(token);
    }



    /**
     * 查询用户所有的收藏总数
     * @param
     * @return
     */
    @GetMapping("/selectAllCollect")
    @ApiOperation(value = "用户收藏总数", notes = "执行查询该用户的所有收藏总数")
    public ResultData selectAllCollect(String token) {
       return repastService.selectAllCollect(token);
  }


}