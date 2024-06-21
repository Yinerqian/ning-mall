package com.atguigu.gulimall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.coupon.dao.CouponHistoryDao;
import com.atguigu.gulimall.coupon.dto.CouponHistoryDTO;
import com.atguigu.gulimall.coupon.entity.CouponHistoryEntity;
import com.atguigu.gulimall.coupon.service.CouponHistoryService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 优惠券领取历史记录
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class CouponHistoryServiceImpl extends CrudServiceImpl<CouponHistoryDao, CouponHistoryEntity, CouponHistoryDTO> implements CouponHistoryService {

    @Override
    public QueryWrapper<CouponHistoryEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CouponHistoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}