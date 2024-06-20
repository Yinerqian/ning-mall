package com.atguigu.gulimall.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 品牌分类关联
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class CategoryBrandRelationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long brandId;

	private Long catelogId;

	private String brandName;

	private String catelogName;


}
