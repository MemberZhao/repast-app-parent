package com.aaa.lee.app.service;

import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.MemberReceiveAddress;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.ProductCat;
import com.aaa.lee.app.fallback.RepastFallBackFactory;
import com.aaa.lee.app.vo.ShopInfoVo;
import com.aaa.lee.app.vo.UsableCouponVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:40
 * @Description
 *      当使用feign进行传参的时候，如果是对象,包装类型,实体类...必须要使用@RequestBody，并且这个@RequestBody只能在该方法中出现一次
 *          ResultData selectUsersCondition(@RequestBody User user, @RequestBody UserInfo userInfo);---->错误
 *      当传递的参数是简单类型(String, Integer....8种基本类型+String)，必须要使用@RequestParam("")，这个@RequestPara注解可以出现多个
 *          ResultData selectUsersCondition(@RquestPara("username") String username, @RequestParam("age") Integer age);---->正确
 *
 **/
@FeignClient(value = "userinfo-interface-provider", fallbackFactory = RepastFallBackFactory.class)
public interface IRepastService {

    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     * @param [member]
     * @date 2019/11/21
     * @return java.lang.Boolean
     * @throws 
    **/
    @PostMapping("/login")
    Boolean doLogin(@RequestBody Member member);

    /**
     * @author Seven Lee
     * @description
     *      根据会员id获取会员收获地址列表
     * @param []
     * @date 2019/11/21
     * @return java.util.List<com.aaa.lee.app.domain.MemberReceiveAddress>
     * @throws 
    **/
    @GetMapping("/receive")
    List<MemberReceiveAddress> getMemberReceiveAddress();

    /**
     * @author Seven Lee
     * @description
     *      通过主键查询店铺信息
     * @param [shopId]
     * @date 2019/11/21
     * @return java.lang.String
     * @throws 
    **/
    @GetMapping("/getById")
    ShopInfoVo getShopById(@RequestParam("shopId") Long shopId);

    /**
     * @author Seven Lee
     * @description
     *      通过店铺主键查询商品类目列表
     * @param [shopId]
     * @date 2019/11/21
     * @return com.aaa.lee.app.base.ResultData
     * @throws 
    **/
    @GetMapping("/getCatByShopId")
    List<ProductCat> getCategoryByShopId(Long shopId);

    /**
     * @author Seven Lee
     * @description
     *      通过店铺主键查询商品列表
     * @param [shopId]
     * @date 2019/11/21
     * @return java.util.List<com.aaa.lee.app.domain.Product>
     * @throws 
    **/
    @GetMapping("/getProductByShopId")
    List<Product> getProductByShopId(Long shopId);

    /**
     * @author Memer Zhao
     * @date 2019/11/22 9:15
     * @description
     *      获取会员余额
     * @param
     * @return
     **/
    @GetMapping("/getMemberBalance")
    List<Member> getMemberBalance();
    /**
     * @author Memer Zhao
     * @date 2019/11/23 14:34
     * @description
     * @param
     * @return
     **/
    @PostMapping
    Boolean payForMemeberBalance(@RequestParam int money);

    /**
     * 获取用户所有的可见优惠券信息
     * @return
     **/
    @PostMapping("/getUsableCoupons")
    ResultData<List<UsableCouponVO>> getAllUsableCoupons(@RequestParam("openId") String openId);

    /**
     * 获取用户所有优惠券
     * @return
     **/
    @PostMapping("/getAllCouponsByMemberId")
    ResultData<List> getAllCouponsByMemberId(@RequestParam("openId") String openId);

    /**
     * 获取用户所有可用优惠券
     * @return
     **/
    @PostMapping("/getUsableCouponsByMemberId")
    ResultData<List> getUsableCouponsByMemberId(@RequestParam("openId") String openId);

    /**
     * 获取用户当前店铺所有可用优惠券
     * @return
     **/
    @PostMapping("/getUsableCouponsByMemberIdAndShopId")
    ResultData<List> getUsableCouponsByMemberIdAndShopId(@RequestParam("shopId") Long shopId, @RequestParam("openId") String openId);

    /**
     * 领取优惠券
     * @return
     **/
    @PostMapping("/receiveCouponAffair")
    ResultData receiveCouponAffair(@RequestParam("couponId") Long couponId, @RequestParam("openId") String openId);

    /**
     * 使用优惠券
     * @return
     **/
    @PostMapping("/useCouponAffair")
    ResultData useCouponAffair(@RequestParam("couponHistoryId") Long couponHistoryId, @RequestParam("openId") String openId, @RequestParam("amount") String amount);

}
