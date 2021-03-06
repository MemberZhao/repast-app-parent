package com.aaa.lee.app.fallback;

import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.*;
import com.aaa.lee.app.service.IRepastService;
import com.aaa.lee.app.vo.MemberCommentVo;
import com.aaa.lee.app.vo.ShopInfoVo;
import com.aaa.lee.app.vo.UsableCouponVO;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:41
 * @Description
 **/
@Component
public class RepastFallBackFactory implements FallbackFactory<IRepastService> {

    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService() {
            @Override
            public String doLogin(Member member) {
                System.out.println("测试登录熔断数据");
                return null;
            }

            @Override
            public String newUser(Member member) {
                return null;
            }

            @Override
            public List<MemberReceiveAddress> getMemberReceiveAddress(String token) {
                System.out.println("测试查询收获地址列表熔断数据");
                return null;
            }

            @Override
            public boolean delSite(@RequestParam("id")Long id, @RequestParam("token") String token) {
                System.out.println("测试删除收货地址熔断数据");
                return false;
            }

            @Override
            public boolean updateSite(MemberReceiveAddress memberReceiveAddress,String token) {
                System.out.println("测试修改收货地址熔断数据");
                return false;
            }

            @Override
            public boolean insertSite(MemberReceiveAddress memberReceiveAddress,String token) {
                System.out.println("测试增加收货地址熔断数据");
                return false;
            }

            @Override
            public ShopInfoVo getShopById(Long shopId) {
                System.out.println("测试店铺信息熔断数据");
                return null;
            }

            @Override
            public List<ProductCat> getCategoryByShopId(Long shopId) {
                System.out.println("测试商品类目熔断数据");
                return null;
            }

            @Override
            public List<Product> getProductByShopId(Long shopId) {
                return null;
            }

            @Override
            public List<Member> getMemberBalance() {
                System.out.println("测试会员余额熔断数据");
                return null;
            }

            @Override
            public ResultData<List<UsableCouponVO>> getAllUsableCoupons(String token) {
                return null;
            }

            @Override
            public ResultData<List> getAllCouponsByMemberId(String token) {
                return null;
            }

            @Override
            public ResultData<List> getUsableCouponsByMemberId(String token) {
                return null;
            }

            @Override
            public ResultData<List> getUsableCouponsByMemberIdAndShopId(Long shopId, String token) {
                return null;
            }

            @Override
            public ResultData<List> getDisableCouponsByMemberId(String token) {
                return null;
            }

            @Override
            public ResultData receiveCouponAffair(Long couponId, String token) {
                return null;
            }

            @Override
            public ResultData useCouponAffair(Long couponHistoryId, String token, Double amount) {
                return null;
            }

            @Override
            public ResultData toCollect(Long productId, String token) {
                return null;
            }

            @Override
            public ResultData toCollectOrder(Long orderId, String token) {
                return null;
            }

            @Override
            public ResultData selectAllCollectProduct(String token) {
                return null;
            }

            @Override
            public ResultData selectAllCollectOrder(String token) {
                return null;
            }

            @Override
            public ResultData selectAllCollect(String token) {
                return null;
            }
            @Override
            public Member getMemberById(Long memberId) {
                return null;
            }

            @Override
            public int updateMemberById(Member member) {
                return 0;
            }

            @Override
            public List<MemberCommentVo> getMemberComment(String token) {
                System.out.println("测试评价列表熔断数据");

                return null;
            }

            @Override
            public Boolean deleteComment(Long id,String token) {
                System.out.println("测试删除评价列表熔断数据");
                return false;
            }

            @Override
            public Boolean insertComment(MemberComment comment, String token) {
                System.out.println("测试添加评价信息熔断数据");
                return false;
            }

            @Override
            public Boolean insertComplain(MemberComplain complain,String token) {
                System.out.println("测试添加用户意见信息熔断数据");
                return false;
            }

            @Override
            public String uploadHead(MultipartFile file,String token) {

                return null;
            }

            @Override
            public String upload(MultipartFile[] file,String token) {

                return null;
            }

        };
        return repastService;
    }
}
