package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.common.dao.BaseDao;
import com.atguigu.gulimall.coupon.entity.MemberPriceEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Mapper
public interface MemberPriceDao extends BaseDao<MemberPriceEntity> {
	
}