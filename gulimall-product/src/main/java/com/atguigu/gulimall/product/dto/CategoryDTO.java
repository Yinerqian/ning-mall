package com.atguigu.gulimall.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 商品三级分类
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long catId;

	private String name;

	private Long parentCid;

	private Integer catLevel;

	private Integer showStatus;

	private Integer sort;

	private String icon;

	private String productUnit;

	private Integer productCount;


}
