package com.atguigu.gulimall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.order.dao.OrderSettingDao;
import com.atguigu.gulimall.order.dto.OrderSettingDTO;
import com.atguigu.gulimall.order.entity.OrderSettingEntity;
import com.atguigu.gulimall.order.service.OrderSettingService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 订单配置信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class OrderSettingServiceImpl extends CrudServiceImpl<OrderSettingDao, OrderSettingEntity, OrderSettingDTO> implements OrderSettingService {

    @Override
    public QueryWrapper<OrderSettingEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<OrderSettingEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}