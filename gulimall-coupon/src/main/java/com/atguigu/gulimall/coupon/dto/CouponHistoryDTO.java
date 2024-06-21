package com.atguigu.gulimall.coupon.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 优惠券领取历史记录
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class CouponHistoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long couponId;

	private Long memberId;

	private String memberNickName;

	private Integer getType;

	private Date createTime;

	private Integer useType;

	private Date useTime;

	private Long orderId;

	private Long orderSn;


}
