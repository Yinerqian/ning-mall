package com.atguigu.gulimall.ware.dao;

import com.atguigu.gulimall.common.dao.BaseDao;
import com.atguigu.gulimall.ware.entity.WareSkuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Mapper
public interface WareSkuDao extends BaseDao<WareSkuEntity> {
	
}