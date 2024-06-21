package com.atguigu.gulimall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.order.dao.OrderReturnApplyDao;
import com.atguigu.gulimall.order.dto.OrderReturnApplyDTO;
import com.atguigu.gulimall.order.entity.OrderReturnApplyEntity;
import com.atguigu.gulimall.order.service.OrderReturnApplyService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 订单退货申请
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class OrderReturnApplyServiceImpl extends CrudServiceImpl<OrderReturnApplyDao, OrderReturnApplyEntity, OrderReturnApplyDTO> implements OrderReturnApplyService {

    @Override
    public QueryWrapper<OrderReturnApplyEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<OrderReturnApplyEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}