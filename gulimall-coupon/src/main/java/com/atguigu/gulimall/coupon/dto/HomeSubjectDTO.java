package com.atguigu.gulimall.coupon.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class HomeSubjectDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String title;

	private String subTitle;

	private Integer status;

	private String url;

	private Integer sort;

	private String img;


}
