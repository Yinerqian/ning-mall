package com.atguigu.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 优惠券与产品关联
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
@TableName("sms_coupon_spu_relation")
public class CouponSpuRelationEntity {

    /**
     * id
     */
	private Long id;
    /**
     * 优惠券id
     */
	private Long couponId;
    /**
     * spu_id
     */
	private Long spuId;
    /**
     * spu_name
     */
	private String spuName;
}