package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.common.dao.BaseDao;
import com.atguigu.gulimall.product.entity.CommentReplayEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Mapper
public interface CommentReplayDao extends BaseDao<CommentReplayEntity> {
	
}