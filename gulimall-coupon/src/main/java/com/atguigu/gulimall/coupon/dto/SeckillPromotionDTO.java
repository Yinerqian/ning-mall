package com.atguigu.gulimall.coupon.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 秒杀活动
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class SeckillPromotionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private String title;

	private Date startTime;

	private Date endTime;

	private Integer status;

	private Date createTime;

	private Long userId;


}
