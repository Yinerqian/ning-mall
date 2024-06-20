package com.atguigu.gulimall.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * spu信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class SpuInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private String spuName;

	private String spuDescription;

	private Long catalogId;

	private Long brandId;

	private BigDecimal weight;

	private Integer publishStatus;

	private Date createTime;

	private Date updateTime;


}
