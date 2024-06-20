package com.atguigu.gulimall.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * spu图片
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class SpuImagesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long spuId;

	private String imgName;

	private String imgUrl;

	private Integer imgSort;

	private Integer defaultImg;


}
