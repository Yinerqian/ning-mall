package com.atguigu.gulimall.coupon.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 优惠券与产品关联
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class CouponSpuRelationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long couponId;

	private Long spuId;

	private String spuName;


}
