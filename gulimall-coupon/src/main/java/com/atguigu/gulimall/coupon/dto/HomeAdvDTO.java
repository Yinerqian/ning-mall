package com.atguigu.gulimall.coupon.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 首页轮播广告
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class HomeAdvDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String pic;

	private Date startTime;

	private Date endTime;

	private Integer status;

	private Integer clickCount;

	private String url;

	private String note;

	private Integer sort;

	private Long publisherId;

	private Long authId;


}
