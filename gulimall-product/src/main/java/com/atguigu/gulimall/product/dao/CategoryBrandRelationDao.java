package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.common.dao.BaseDao;
import com.atguigu.gulimall.product.entity.CategoryBrandRelationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌分类关联
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseDao<CategoryBrandRelationEntity> {
	
}