package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.common.dao.BaseDao;
import com.atguigu.gulimall.order.entity.PaymentInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Mapper
public interface PaymentInfoDao extends BaseDao<PaymentInfoEntity> {
	
}