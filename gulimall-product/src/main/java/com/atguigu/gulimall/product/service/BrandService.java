package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.common.service.CrudService;
import com.atguigu.gulimall.product.dao.BrandDao;
import com.atguigu.gulimall.product.dto.BrandDTO;
import com.atguigu.gulimall.product.entity.BrandEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * 品牌
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
public interface BrandService extends CrudService<BrandEntity, BrandDTO> {

    BrandEntity findBrandById(Long id);

    void updateBrandById(BrandEntity brandEntity);

}