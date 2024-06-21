package com.atguigu.gulimall.coupon.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 秒杀活动商品关联
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class SeckillSkuRelationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long promotionId;

	private Long promotionSessionId;

	private Long skuId;

	private BigDecimal seckillPrice;

	private Integer seckillCount;

	private Integer seckillLimit;

	private Integer seckillSort;


}
