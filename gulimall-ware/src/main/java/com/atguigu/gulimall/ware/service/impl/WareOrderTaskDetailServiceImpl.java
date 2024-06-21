package com.atguigu.gulimall.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.ware.dao.WareOrderTaskDetailDao;
import com.atguigu.gulimall.ware.dto.WareOrderTaskDetailDTO;
import com.atguigu.gulimall.ware.entity.WareOrderTaskDetailEntity;
import com.atguigu.gulimall.ware.service.WareOrderTaskDetailService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class WareOrderTaskDetailServiceImpl extends CrudServiceImpl<WareOrderTaskDetailDao, WareOrderTaskDetailEntity, WareOrderTaskDetailDTO> implements WareOrderTaskDetailService {

    @Override
    public QueryWrapper<WareOrderTaskDetailEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<WareOrderTaskDetailEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}