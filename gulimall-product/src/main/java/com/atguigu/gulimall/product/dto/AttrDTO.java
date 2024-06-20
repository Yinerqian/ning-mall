package com.atguigu.gulimall.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 商品属性
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class AttrDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long attrId;

	private String attrName;

	private Integer searchType;

	private Integer valueType;

	private String icon;

	private String valueSelect;

	private Integer attrType;

	private Long enable;

	private Long catelogId;

	private Integer showDesc;


}
