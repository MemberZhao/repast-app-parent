package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Collect;
import com.aaa.lee.app.domain.OmsOrder;
import com.aaa.lee.app.domain.PmsProduct;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;


public interface CollectMapper<Internal> extends Mapper<Collect> {
    /**
     * 判断商品的当前状态
     */
    int selectProductStatusById(Long productId);

    /**
     * 根据memberId查询该用户的所有收藏单品
     * @param memberId
     * @return
     */
    List<PmsProduct> selectAllCollectProductByMemberId(Long memberId);

    /**
     * 添加 收藏订单
     * @param collect
     * @return
     */
    int insertCollectOrderByMemberId(Collect collect);
    int insertCollectProductByMemberId(Collect collect);
    /**
     * 根据memberId查询该用户的所有收藏订单
     * @param memberId
     * @return
     */
    List<OmsOrder> selectAllCollectOrderByMemberId(Long memberId);

    /**
     * 查询该用户的所有收藏总数
     */

    Map<String, Object> selectAllCollectCountByMember(Long memberId);

    /**
     * 取消收藏单品
     */
    Integer deleteCollectProductByMemberId(Collect collect);
    /**
     * 取消收藏订单
     */
    Integer deleteCollectOrderByMemberId(Collect collect);

    /**
     * 查询该用户是否收藏该商品
     */
    Collect selectIfCollectProduct(Collect collect);
    /**
     * 查询该用户是否收藏该订单
     */
    Collect selectIfCollectOrder(Collect collect);

}