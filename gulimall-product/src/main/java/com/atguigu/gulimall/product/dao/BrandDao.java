package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.common.dao.BaseDao;
import com.atguigu.gulimall.product.entity.BrandEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 品牌
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Mapper
public interface BrandDao extends BaseDao<BrandEntity> {

    void updateBrand(@RequestParam("brandEntity") BrandEntity brand);

    void saveBrand(@RequestParam("brandEntity") BrandEntity brand);

    void deleteBrandById(String id);
}