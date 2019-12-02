package com.aaa.lee.app.controller;


import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CollectController extends BaseController {

@Autowired
private CollectService collectService;


    /**
     * 单品收藏
     * @param collect
     * @return
     */
    @PostMapping("/toCollect")
    public ResultData toCollect(@RequestParam("productId") Long productId, @RequestParam("token") String token){
        return collectService.toCollect(productId,token);
    }

    /**
     * 订单收藏
     * @param collect
     * @return
     */
    @PostMapping("/toCollectOrder")
    public ResultData toCollectOrder(@RequestParam("orderId") Long orderId, @RequestParam("token") String token){
        return collectService.toCollectOrder(orderId,token);
    }

    /**
     * 查询当前用户的所有单品收藏
     * @return
     */
    @GetMapping("/selectAllCollectProduct")
    public ResultData selectAllCollectProduct(@RequestParam("token") String token){
        return collectService.selectAllCollectProduct(token);
    }

    /**
     * 查询当前用户的所有的订单收藏
     * @param token
     * @return
     */
    @GetMapping("/selectAllCollectOrder")
    public ResultData selectAllCollectOrder(@RequestParam("token") String token){
        return collectService.selectAllCollectOrder(token);
    }
    /**
     * 查询该用户的所有收藏总数
     * @param token
     * @return
     */
    @GetMapping("/selectAllCollect")
     public ResultData selectAllCollect(@RequestParam("token") String token){
        return collectService.selectAllCollect(token);
    }
}
