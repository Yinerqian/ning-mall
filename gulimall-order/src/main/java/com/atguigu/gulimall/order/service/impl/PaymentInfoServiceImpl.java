package com.atguigu.gulimall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.order.dao.PaymentInfoDao;
import com.atguigu.gulimall.order.dto.PaymentInfoDTO;
import com.atguigu.gulimall.order.entity.PaymentInfoEntity;
import com.atguigu.gulimall.order.service.PaymentInfoService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 支付信息表
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class PaymentInfoServiceImpl extends CrudServiceImpl<PaymentInfoDao, PaymentInfoEntity, PaymentInfoDTO> implements PaymentInfoService {

    @Override
    public QueryWrapper<PaymentInfoEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PaymentInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}