package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * spu属性值
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
@TableName("pms_product_attr_value")
public class ProductAttrValueEntity {

    /**
     * id
     */
	private Long id;
    /**
     * 商品id
     */
	private Long spuId;
    /**
     * 属性id
     */
	private Long attrId;
    /**
     * 属性名
     */
	private String attrName;
    /**
     * 属性值
     */
	private String attrValue;
    /**
     * 顺序
     */
	private Integer attrSort;
    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】
     */
	private Integer quickShow;
}