package com.atguigu.gulimall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.coupon.dao.HomeAdvDao;
import com.atguigu.gulimall.coupon.dto.HomeAdvDTO;
import com.atguigu.gulimall.coupon.entity.HomeAdvEntity;
import com.atguigu.gulimall.coupon.service.HomeAdvService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 首页轮播广告
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class HomeAdvServiceImpl extends CrudServiceImpl<HomeAdvDao, HomeAdvEntity, HomeAdvDTO> implements HomeAdvService {

    @Override
    public QueryWrapper<HomeAdvEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<HomeAdvEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}