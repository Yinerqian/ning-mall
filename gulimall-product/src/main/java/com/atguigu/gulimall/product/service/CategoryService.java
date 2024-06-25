package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.common.service.CrudService;
import com.atguigu.gulimall.product.dto.CategoryDTO;
import com.atguigu.gulimall.product.entity.CategoryEntity;

import java.util.List;

/**
 * 商品三级分类
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
public interface CategoryService extends CrudService<CategoryEntity, CategoryDTO> {

    List<CategoryEntity> listCategoryTree();

}