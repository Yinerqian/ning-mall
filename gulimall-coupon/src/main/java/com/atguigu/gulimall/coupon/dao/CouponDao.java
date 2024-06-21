package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.common.dao.BaseDao;
import com.atguigu.gulimall.coupon.entity.CouponEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Mapper
public interface CouponDao extends BaseDao<CouponEntity> {
	
}