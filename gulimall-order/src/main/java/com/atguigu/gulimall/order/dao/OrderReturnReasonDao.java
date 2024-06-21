package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.common.dao.BaseDao;
import com.atguigu.gulimall.order.entity.OrderReturnReasonEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退货原因
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Mapper
public interface OrderReturnReasonDao extends BaseDao<OrderReturnReasonEntity> {
	
}