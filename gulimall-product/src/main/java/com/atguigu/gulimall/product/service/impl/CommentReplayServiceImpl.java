package com.atguigu.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.product.dao.CommentReplayDao;
import com.atguigu.gulimall.product.dto.CommentReplayDTO;
import com.atguigu.gulimall.product.entity.CommentReplayEntity;
import com.atguigu.gulimall.product.service.CommentReplayService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class CommentReplayServiceImpl extends CrudServiceImpl<CommentReplayDao, CommentReplayEntity, CommentReplayDTO> implements CommentReplayService {

    @Override
    public QueryWrapper<CommentReplayEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CommentReplayEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}