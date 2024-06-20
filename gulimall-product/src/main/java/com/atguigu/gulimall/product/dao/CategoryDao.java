package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.common.dao.BaseDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Mapper
public interface CategoryDao extends BaseDao<CategoryEntity> {
	
}