package com.atguigu.gulimall.ware.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 商品库存
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class WareSkuDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long skuId;

	private Long wareId;

	private Integer stock;

	private String skuName;

	private Integer stockLocked;


}
