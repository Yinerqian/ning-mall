package com.atguigu.gulimall.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * sku销售属性&值
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class SkuSaleAttrValueDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long skuId;

	private Long attrId;

	private String attrName;

	private String attrValue;

	private Integer attrSort;


}
