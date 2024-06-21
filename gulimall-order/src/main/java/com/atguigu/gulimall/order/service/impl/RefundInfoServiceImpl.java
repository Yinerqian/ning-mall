package com.atguigu.gulimall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.order.dao.RefundInfoDao;
import com.atguigu.gulimall.order.dto.RefundInfoDTO;
import com.atguigu.gulimall.order.entity.RefundInfoEntity;
import com.atguigu.gulimall.order.service.RefundInfoService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 退款信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class RefundInfoServiceImpl extends CrudServiceImpl<RefundInfoDao, RefundInfoEntity, RefundInfoDTO> implements RefundInfoService {

    @Override
    public QueryWrapper<RefundInfoEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<RefundInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}