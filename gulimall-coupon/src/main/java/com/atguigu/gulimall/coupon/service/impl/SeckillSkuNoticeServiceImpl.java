package com.atguigu.gulimall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.coupon.dao.SeckillSkuNoticeDao;
import com.atguigu.gulimall.coupon.dto.SeckillSkuNoticeDTO;
import com.atguigu.gulimall.coupon.entity.SeckillSkuNoticeEntity;
import com.atguigu.gulimall.coupon.service.SeckillSkuNoticeService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class SeckillSkuNoticeServiceImpl extends CrudServiceImpl<SeckillSkuNoticeDao, SeckillSkuNoticeEntity, SeckillSkuNoticeDTO> implements SeckillSkuNoticeService {

    @Override
    public QueryWrapper<SeckillSkuNoticeEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SeckillSkuNoticeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}