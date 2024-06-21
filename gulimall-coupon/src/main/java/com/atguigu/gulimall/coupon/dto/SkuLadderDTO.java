package com.atguigu.gulimall.coupon.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 商品阶梯价格
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class SkuLadderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long skuId;

	private Integer fullCount;

	private BigDecimal discount;

	private BigDecimal price;

	private Integer addOther;


}
