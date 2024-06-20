package com.atguigu.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.product.dao.SpuCommentDao;
import com.atguigu.gulimall.product.dto.SpuCommentDTO;
import com.atguigu.gulimall.product.entity.SpuCommentEntity;
import com.atguigu.gulimall.product.service.SpuCommentService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 商品评价
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class SpuCommentServiceImpl extends CrudServiceImpl<SpuCommentDao, SpuCommentEntity, SpuCommentDTO> implements SpuCommentService {

    @Override
    public QueryWrapper<SpuCommentEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SpuCommentEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}