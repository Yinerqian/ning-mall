package com.atguigu.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.product.dao.BrandDao;
import com.atguigu.gulimall.product.dto.BrandDTO;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 品牌
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class BrandServiceImpl extends CrudServiceImpl<BrandDao, BrandEntity, BrandDTO> implements BrandService {

    @Resource
    private BrandDao brandDao;

    @Override
    public QueryWrapper<BrandEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        String keyword = (String)params.get("keyword");

        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id)
                .like(StrUtil.isNotBlank(keyword), "name", keyword);

        return wrapper;
    }


    @Override
    public BrandEntity findBrandById(Long id) {
        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(id != null, "brand_id", id);
        return baseDao.selectOne(wrapper);
    }

    @Override
    public void updateBrandById(BrandEntity brandEntity) {
        brandDao.updateBrand(brandEntity);
    }

    public void saveBrand(BrandEntity brandEntity){
        brandEntity.setShowStatus(brandEntity.getShowStatus() == null ? 1 : brandEntity.getShowStatus());
        brandEntity.setSort(brandEntity.getSort() == null ? 1 : brandEntity.getSort());
        brandDao.saveBrand(brandEntity);
    }

    public void deleteBrandById(String id) {
        brandDao.deleteBrandById(id);
    }
}