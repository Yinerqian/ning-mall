package com.atguigu.gulimall.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * sku信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class SkuInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long skuId;

	private Long spuId;

	private String skuName;

	private String skuDesc;

	private Long catalogId;

	private Long brandId;

	private String skuDefaultImg;

	private String skuTitle;

	private String skuSubtitle;

	private BigDecimal price;

	private Long saleCount;


}
