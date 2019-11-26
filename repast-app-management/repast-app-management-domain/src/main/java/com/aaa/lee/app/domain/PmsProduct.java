package com.aaa.lee.app.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "pms_product")
public class PmsProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 店铺ID
     */
    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 品牌ID
     */
    @Column(name = "brand_id")
    private Long brandId;

    /**
     * 产品类别ID
     */
    @Column(name = "product_category_id")
    private Long productCategoryId;

    /**
     * 产品属性类别ID
     */
    @Column(name = "product_attribute_category_id")
    private Long productAttributeCategoryId;

    private String name;

    private String pic;

    /**
     * 货号
     */
    @Column(name = "product_sn")
    private String productSn;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    /**
     * 上架状态：0->下架；1->上架
     */
    @Column(name = "publish_status")
    private Integer publishStatus;

    /**
     * 新品状态:0->不是新品；1->新品
     */
    @Column(name = "new_status")
    private Integer newStatus;

    /**
     * 推荐状态；0->不推荐；1->推荐
     */
    @Column(name = "recommand_status")
    private Integer recommandStatus;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 销量
     */
    private Integer sale;

    private BigDecimal price;

    /**
     * 促销价格
     */
    @Column(name = "promotion_price")
    private BigDecimal promotionPrice;

    /**
     * 赠送的积分
     */
    @Column(name = "gift_point")
    private Integer giftPoint;

    /**
     * 副标题
     */
    @Column(name = "sub_title")
    private String subTitle;

    /**
     * 市场价
     */
    @Column(name = "original_price")
    private BigDecimal originalPrice;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 库存预警值
     */
    @Column(name = "low_stock")
    private Integer lowStock;

    /**
     * 单位
     */
    private String unit;

    /**
     * 商品重量，默认为克
     */
    private BigDecimal weight;

    /**
     * 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
     */
    @Column(name = "service_ids")
    private String serviceIds;

    private String keywords;

    private String note;

    /**
     * 画册id
     */
    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "detail_title")
    private String detailTitle;

    /**
     * 促销开始时间
     */
    @Column(name = "promotion_start_time")
    private Date promotionStartTime;

    /**
     * 促销结束时间
     */
    @Column(name = "promotion_end_time")
    private Date promotionEndTime;

    /**
     * 活动限购数量
     */
    @Column(name = "promotion_per_limit")
    private Integer promotionPerLimit;

    /**
     * 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
     */
    @Column(name = "promotion_type")
    private Integer promotionType;

    /**
     * 品牌名称
     */
    @Column(name = "brand_name")
    private String brandName;

    /**
     * 商品分类名称
     */
    @Column(name = "product_category_name")
    private String productCategoryName;

    /**
     * 币种，0-> 人民币;  1-> 积分
     */
    private Byte currency;

    /**
     * 商品描述
     */
    private String description;

    @Column(name = "detail_desc")
    private String detailDesc;

    /**
     * 产品详情网页内容
     */
    @Column(name = "detail_html")
    private String detailHtml;

    /**
     * 移动端网页详情
     */
    @Column(name = "detail_mobile_html")
    private String detailMobileHtml;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取店铺ID
     *
     * @return shop_id - 店铺ID
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * 设置店铺ID
     *
     * @param shopId 店铺ID
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取品牌ID
     *
     * @return brand_id - 品牌ID
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * 设置品牌ID
     *
     * @param brandId 品牌ID
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取产品类别ID
     *
     * @return product_category_id - 产品类别ID
     */
    public Long getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * 设置产品类别ID
     *
     * @param productCategoryId 产品类别ID
     */
    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    /**
     * 获取产品属性类别ID
     *
     * @return product_attribute_category_id - 产品属性类别ID
     */
    public Long getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    /**
     * 设置产品属性类别ID
     *
     * @param productAttributeCategoryId 产品属性类别ID
     */
    public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return pic
     */
    public String getPic() {
        return pic;
    }

    /**
     * @param pic
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 获取货号
     *
     * @return product_sn - 货号
     */
    public String getProductSn() {
        return productSn;
    }

    /**
     * 设置货号
     *
     * @param productSn 货号
     */
    public void setProductSn(String productSn) {
        this.productSn = productSn == null ? null : productSn.trim();
    }

    /**
     * 获取删除状态：0->未删除；1->已删除
     *
     * @return delete_status - 删除状态：0->未删除；1->已删除
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置删除状态：0->未删除；1->已删除
     *
     * @param deleteStatus 删除状态：0->未删除；1->已删除
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 获取上架状态：0->下架；1->上架
     *
     * @return publish_status - 上架状态：0->下架；1->上架
     */
    public Integer getPublishStatus() {
        return publishStatus;
    }

    /**
     * 设置上架状态：0->下架；1->上架
     *
     * @param publishStatus 上架状态：0->下架；1->上架
     */
    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    /**
     * 获取新品状态:0->不是新品；1->新品
     *
     * @return new_status - 新品状态:0->不是新品；1->新品
     */
    public Integer getNewStatus() {
        return newStatus;
    }

    /**
     * 设置新品状态:0->不是新品；1->新品
     *
     * @param newStatus 新品状态:0->不是新品；1->新品
     */
    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    /**
     * 获取推荐状态；0->不推荐；1->推荐
     *
     * @return recommand_status - 推荐状态；0->不推荐；1->推荐
     */
    public Integer getRecommandStatus() {
        return recommandStatus;
    }

    /**
     * 设置推荐状态；0->不推荐；1->推荐
     *
     * @param recommandStatus 推荐状态；0->不推荐；1->推荐
     */
    public void setRecommandStatus(Integer recommandStatus) {
        this.recommandStatus = recommandStatus;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取销量
     *
     * @return sale - 销量
     */
    public Integer getSale() {
        return sale;
    }

    /**
     * 设置销量
     *
     * @param sale 销量
     */
    public void setSale(Integer sale) {
        this.sale = sale;
    }

    /**
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取促销价格
     *
     * @return promotion_price - 促销价格
     */
    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    /**
     * 设置促销价格
     *
     * @param promotionPrice 促销价格
     */
    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    /**
     * 获取赠送的积分
     *
     * @return gift_point - 赠送的积分
     */
    public Integer getGiftPoint() {
        return giftPoint;
    }

    /**
     * 设置赠送的积分
     *
     * @param giftPoint 赠送的积分
     */
    public void setGiftPoint(Integer giftPoint) {
        this.giftPoint = giftPoint;
    }

    /**
     * 获取副标题
     *
     * @return sub_title - 副标题
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * 设置副标题
     *
     * @param subTitle 副标题
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    /**
     * 获取市场价
     *
     * @return original_price - 市场价
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 设置市场价
     *
     * @param originalPrice 市场价
     */
    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取库存预警值
     *
     * @return low_stock - 库存预警值
     */
    public Integer getLowStock() {
        return lowStock;
    }

    /**
     * 设置库存预警值
     *
     * @param lowStock 库存预警值
     */
    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    /**
     * 获取单位
     *
     * @return unit - 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置单位
     *
     * @param unit 单位
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * 获取商品重量，默认为克
     *
     * @return weight - 商品重量，默认为克
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * 设置商品重量，默认为克
     *
     * @param weight 商品重量，默认为克
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * 获取以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
     *
     * @return service_ids - 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
     */
    public String getServiceIds() {
        return serviceIds;
    }

    /**
     * 设置以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
     *
     * @param serviceIds 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
     */
    public void setServiceIds(String serviceIds) {
        this.serviceIds = serviceIds == null ? null : serviceIds.trim();
    }

    /**
     * @return keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    /**
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * 获取画册id
     *
     * @return album_id - 画册id
     */
    public Long getAlbumId() {
        return albumId;
    }

    /**
     * 设置画册id
     *
     * @param albumId 画册id
     */
    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    /**
     * @return detail_title
     */
    public String getDetailTitle() {
        return detailTitle;
    }

    /**
     * @param detailTitle
     */
    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle == null ? null : detailTitle.trim();
    }

    /**
     * 获取促销开始时间
     *
     * @return promotion_start_time - 促销开始时间
     */
    public Date getPromotionStartTime() {
        return promotionStartTime;
    }

    /**
     * 设置促销开始时间
     *
     * @param promotionStartTime 促销开始时间
     */
    public void setPromotionStartTime(Date promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    /**
     * 获取促销结束时间
     *
     * @return promotion_end_time - 促销结束时间
     */
    public Date getPromotionEndTime() {
        return promotionEndTime;
    }

    /**
     * 设置促销结束时间
     *
     * @param promotionEndTime 促销结束时间
     */
    public void setPromotionEndTime(Date promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    /**
     * 获取活动限购数量
     *
     * @return promotion_per_limit - 活动限购数量
     */
    public Integer getPromotionPerLimit() {
        return promotionPerLimit;
    }

    /**
     * 设置活动限购数量
     *
     * @param promotionPerLimit 活动限购数量
     */
    public void setPromotionPerLimit(Integer promotionPerLimit) {
        this.promotionPerLimit = promotionPerLimit;
    }

    /**
     * 获取促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
     *
     * @return promotion_type - 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
     */
    public Integer getPromotionType() {
        return promotionType;
    }

    /**
     * 设置促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
     *
     * @param promotionType 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
     */
    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    /**
     * 获取品牌名称
     *
     * @return brand_name - 品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置品牌名称
     *
     * @param brandName 品牌名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 获取商品分类名称
     *
     * @return product_category_name - 商品分类名称
     */
    public String getProductCategoryName() {
        return productCategoryName;
    }

    /**
     * 设置商品分类名称
     *
     * @param productCategoryName 商品分类名称
     */
    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName == null ? null : productCategoryName.trim();
    }

    /**
     * 获取币种，0-> 人民币;  1-> 积分
     *
     * @return currency - 币种，0-> 人民币;  1-> 积分
     */
    public Byte getCurrency() {
        return currency;
    }

    /**
     * 设置币种，0-> 人民币;  1-> 积分
     *
     * @param currency 币种，0-> 人民币;  1-> 积分
     */
    public void setCurrency(Byte currency) {
        this.currency = currency;
    }

    /**
     * 获取商品描述
     *
     * @return description - 商品描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置商品描述
     *
     * @param description 商品描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return detail_desc
     */
    public String getDetailDesc() {
        return detailDesc;
    }

    /**
     * @param detailDesc
     */
    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc == null ? null : detailDesc.trim();
    }

    /**
     * 获取产品详情网页内容
     *
     * @return detail_html - 产品详情网页内容
     */
    public String getDetailHtml() {
        return detailHtml;
    }

    /**
     * 设置产品详情网页内容
     *
     * @param detailHtml 产品详情网页内容
     */
    public void setDetailHtml(String detailHtml) {
        this.detailHtml = detailHtml == null ? null : detailHtml.trim();
    }

    /**
     * 获取移动端网页详情
     *
     * @return detail_mobile_html - 移动端网页详情
     */
    public String getDetailMobileHtml() {
        return detailMobileHtml;
    }

    /**
     * 设置移动端网页详情
     *
     * @param detailMobileHtml 移动端网页详情
     */
    public void setDetailMobileHtml(String detailMobileHtml) {
        this.detailMobileHtml = detailMobileHtml == null ? null : detailMobileHtml.trim();
    }
}