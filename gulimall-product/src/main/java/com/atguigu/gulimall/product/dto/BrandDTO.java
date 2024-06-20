package com.atguigu.gulimall.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 品牌
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class BrandDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long brandId;

	private String name;

	private String logo;

	private String descript;

	private Integer showStatus;

	private String firstLetter;

	private Integer sort;


}
