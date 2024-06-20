package com.atguigu.gulimall.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * spu信息介绍
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class SpuInfoDescDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long spuId;

	private String decript;


}
