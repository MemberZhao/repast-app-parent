package com.aaa.lee.app.controller;


import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.service.CollectService;
import com.aaa.lee.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CollectController extends BaseController {

@Autowired
private CollectService collectService;
@Autowired
private RedisService redisService;

    /**
     * 单品收藏
     * @param collect
     * @return
     */
    @PostMapping("/toCollect")
    public ResultData toCollect(@RequestParam("productId") Long productId, @RequestParam("openId") String openId){
        return collectService.toCollect(productId,openId,redisService);
    }

    /**
     * 订单收藏
     * @param collect
     * @return
     */
    @PostMapping("/toCollectOrder")
    public ResultData toCollectOrder(@RequestParam("orderId") Long orderId, @RequestParam("openId") String openId){
        return collectService.toCollectOrder(orderId,openId,redisService);
    }

    /**
     * 查询当前用户的所有单品收藏
     * @return
     */
    @GetMapping("/selectAllCollectProduct")
    public ResultData selectAllCollectProduct(@RequestParam("openId") String openId){
        return collectService.selectAllCollectProduct(openId,redisService);
    }

    /**
     * 查询当前用户的所有的订单收藏
     * @param openId
     * @return
     */
    @GetMapping("/selectAllCollectOrder")
    public ResultData selectAllCollectOrder(@RequestParam("openId") String openId){
        return collectService.selectAllCollectOrder(openId,redisService);
    }
    /**
     * 查询该用户的所有收藏总数
     * @param openId
     * @return
     */
    @GetMapping("/selectAllCollect")
     public ResultData selectAllCollect(@RequestParam("openId") String openId){
        return collectService.selectAllCollect(openId,redisService);
    }
}
