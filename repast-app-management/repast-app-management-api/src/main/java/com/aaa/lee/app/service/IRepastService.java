package com.aaa.lee.app.service;

import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.*;
import com.aaa.lee.app.fallback.RepastFallBackFactory;
import com.aaa.lee.app.vo.MemberCommentVo;
import com.aaa.lee.app.vo.ShopInfoVo;
import com.aaa.lee.app.vo.UsableCouponVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
     * 执行登录
     * @param member
     * @return
     */
    @PostMapping("/login")
    String doLogin(@RequestBody Member member);

    /**
     * 接收用户信息
     * @param member
     * @return
     */
    @PostMapping("/userMessage")
    String newUser(@RequestBody Member member);

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
     * 获取用户所有的可见优惠券信息
     * @return
     **/
    @GetMapping("/getUsableCoupons")
    ResultData<List<UsableCouponVO>> getAllUsableCoupons(@RequestParam("token") String token);

    /**
     * 获取用户所有优惠券
     * @return
     **/
    @GetMapping("/getAllCouponsByMemberId")
    ResultData<List> getAllCouponsByMemberId(@RequestParam("token") String token);

    /**
     * 获取用户所有可用优惠券
     * @return
     **/
    @GetMapping("/getUsableCouponsByMemberId")
    ResultData<List> getUsableCouponsByMemberId(@RequestParam("token") String token);

    /**
     * 获取用户当前店铺所有可用优惠券
     * @return
     **/
    @GetMapping("/getUsableCouponsByMemberIdAndShopId")
    ResultData<List> getUsableCouponsByMemberIdAndShopId(@RequestParam("shopId") Long shopId, @RequestParam("token") String token);

    /**
     * 获取用户所有不可用优惠券
     * @return
     **/
    @GetMapping("/getDisableCouponsByMemberId")
    ResultData<List> getDisableCouponsByMemberId(@RequestParam("token") String token);

    /**
     * 领取优惠券
     * @return
     **/
    @GetMapping("/receiveCouponAffair")
    ResultData receiveCouponAffair(@RequestParam("couponId") Long couponId, @RequestParam("token") String token);

    /**
     * 使用优惠券
     * @return
     **/
    @GetMapping("/useCouponAffair")
    ResultData useCouponAffair(@RequestParam("couponHistoryId") Long couponHistoryId, @RequestParam("token") String token, @RequestParam("amount") Double amount);

    /**
     * 单品收藏
     * @param collect
     * @return
     */
    @PostMapping("/toCollect")
    ResultData toCollect(@RequestParam("productId") Long productId, @RequestParam("token") String token);

    /**
     * 订单收藏
     * @param collect
     * @return
     */
    @PostMapping("/toCollectOrder")
    ResultData toCollectOrder(@RequestParam("orderId") Long orderId, @RequestParam("token") String token);

    /**
     * 查询当前用户的所有单品收藏
     * @return
     */
    @GetMapping("/selectAllCollectProduct")
    ResultData selectAllCollectProduct(@RequestParam("token") String token);

    /**
     * 查询当前用户的所有的订单收藏
     * @param token
     * @return
     */
    @GetMapping("/selectAllCollectOrder")
    ResultData selectAllCollectOrder(@RequestParam("token")String token);
    /**
     * 查询该用户的所有收藏总数
     * @param token
     * @return
     */
    @GetMapping("/selectAllCollect")
    ResultData selectAllCollect(@RequestParam("token") String token);
    /**
     * 通过id 查询用户信息
     * @param member
     * @return
     */
    @GetMapping("/getMemberId")
    Member getMemberById (@RequestParam("memberId") Long memberId);

    /**
     * 根据id修改用户信息
     * @param memberId
     * @return
     */
    @PostMapping("/updateMemberId")
    int updateMemberById(@RequestBody Member member);

    /**
     * @description
     * 通过主键获取评价信息列表
     * @param token
     * @return
     *
     */
    @GetMapping("/comment")
    List<MemberCommentVo> getMemberComment(@RequestParam("token") String token);

    /**
     * 通过主键删除我的评论信息
     * @param id
     * @return
     */
    @GetMapping("/delComment")
    Boolean deleteComment(@RequestParam("id") Long id,@RequestParam("token") String token);

    /**
     * 添加评论信息
     * @param comment
     * @param token
     * @return
     */
    @PostMapping("/addComment")
    Boolean insertComment(@RequestBody MemberComment comment, @RequestParam("token") String token);

    /**
     * 添加用户意见信息
     * @param complain
     * @return
     */
    @PostMapping("/addComplain")
    Boolean insertComplain(@RequestBody MemberComplain complain,@RequestParam("token") String token);

    /**
     * 单添加图片
     * @param file
     * @return
     */

    @PostMapping(value = "/uploadHead",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadHead(@RequestPart MultipartFile file);

    /***
     * 多张图片上传
     * @param file
     * @return
     */

    @PostMapping(value = "/upload",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart(value = "file") MultipartFile[]  file);

}
