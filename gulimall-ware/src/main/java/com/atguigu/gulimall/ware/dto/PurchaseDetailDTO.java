package com.atguigu.gulimall.ware.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class PurchaseDetailDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long purchaseId;

	private Long skuId;

	private Integer skuNum;

	private BigDecimal skuPrice;

	private Long wareId;

	private Integer status;


}
