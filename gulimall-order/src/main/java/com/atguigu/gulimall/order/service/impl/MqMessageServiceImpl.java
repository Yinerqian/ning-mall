package com.atguigu.gulimall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.order.dao.MqMessageDao;
import com.atguigu.gulimall.order.dto.MqMessageDTO;
import com.atguigu.gulimall.order.entity.MqMessageEntity;
import com.atguigu.gulimall.order.service.MqMessageService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class MqMessageServiceImpl extends CrudServiceImpl<MqMessageDao, MqMessageEntity, MqMessageDTO> implements MqMessageService {

    @Override
    public QueryWrapper<MqMessageEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<MqMessageEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}