package com.aaa.lee.app.fallback;

import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.MemberReceiveAddress;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.ProductCat;
import com.aaa.lee.app.service.IRepastService;
import com.aaa.lee.app.vo.ShopInfoVo;
import com.aaa.lee.app.vo.UsableCouponVO;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

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
            public Boolean doLogin(Member member) {
                System.out.println("测试登录熔断数据");
                return null;
            }

            @Override
            public List<MemberReceiveAddress> getMemberReceiveAddress() {
                System.out.println("测试收获地址列表熔断数据");
                return null;
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
            public ResultData<List<UsableCouponVO>> getAllUsableCoupons(String openId) {
                return null;
            }

            @Override
            public ResultData<List> getAllCouponsByMemberId(String openId) {
                return null;
            }

            @Override
            public ResultData<List> getUsableCouponsByMemberId(String openId) {
                return null;
            }

            @Override
            public ResultData<List> getUsableCouponsByMemberIdAndShopId(Long shopId, String openId) {
                return null;
            }

            @Override
            public ResultData<List> getDisableCouponsByMemberId(String openId) {
                return null;
            }

            @Override
            public ResultData receiveCouponAffair(Long couponId, String openId) {
                return null;
            }

            @Override
            public ResultData useCouponAffair(Long couponHistoryId, String openId, Double amount) {
                return null;
            }

            @Override
            public ResultData toCollect(Long productId, String openId) {
                return null;
            }

            @Override
            public ResultData toCollectOrder(Long orderId, String openId) {
                return null;
            }

            @Override
            public ResultData selectAllCollectProduct(String openId) {
                return null;
            }

            @Override
            public ResultData selectAllCollectOrder(String openId) {
                return null;
            }

            @Override
            public ResultData selectAllCollect(String openId) {
                return null;
            }
        };
        return repastService;
    }
}
