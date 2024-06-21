package com.atguigu.gulimall.coupon.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 专题商品
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class HomeSubjectSpuDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private Long subjectId;

	private Long spuId;

	private Integer sort;


}
