package com.atguigu.gulimall.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.member.dao.UndoLogDao;
import com.atguigu.gulimall.member.dto.UndoLogDTO;
import com.atguigu.gulimall.member.entity.UndoLogEntity;
import com.atguigu.gulimall.member.service.UndoLogService;
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
public class UndoLogServiceImpl extends CrudServiceImpl<UndoLogDao, UndoLogEntity, UndoLogDTO> implements UndoLogService {

    @Override
    public QueryWrapper<UndoLogEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UndoLogEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}