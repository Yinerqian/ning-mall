package com.atguigu.gulimall.coupon.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 优惠券信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class CouponDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Integer couponType;

	private String couponImg;

	private String couponName;

	private Integer num;

	private BigDecimal amount;

	private Integer perLimit;

	private BigDecimal minPoint;

	private Date startTime;

	private Date endTime;

	private Integer useType;

	private String note;

	private Integer publishCount;

	private Integer useCount;

	private Integer receiveCount;

	private Date enableStartTime;

	private Date enableEndTime;

	private String code;

	private Integer memberLevel;

	private Integer publish;


}
