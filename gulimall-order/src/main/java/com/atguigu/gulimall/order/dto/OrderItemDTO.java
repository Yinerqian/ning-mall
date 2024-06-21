package com.atguigu.gulimall.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 订单项信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class OrderItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long orderId;

	private String orderSn;

	private Long spuId;

	private String spuName;

	private String spuPic;

	private String spuBrand;

	private Long categoryId;

	private Long skuId;

	private String skuName;

	private String skuPic;

	private BigDecimal skuPrice;

	private Integer skuQuantity;

	private String skuAttrsVals;

	private BigDecimal promotionAmount;

	private BigDecimal couponAmount;

	private BigDecimal integrationAmount;

	private BigDecimal realAmount;

	private Integer giftIntegration;

	private Integer giftGrowth;


}
