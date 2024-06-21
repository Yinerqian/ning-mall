package com.atguigu.gulimall.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.member.dao.MemberStatisticsInfoDao;
import com.atguigu.gulimall.member.dto.MemberStatisticsInfoDTO;
import com.atguigu.gulimall.member.entity.MemberStatisticsInfoEntity;
import com.atguigu.gulimall.member.service.MemberStatisticsInfoService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 会员统计信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class MemberStatisticsInfoServiceImpl extends CrudServiceImpl<MemberStatisticsInfoDao, MemberStatisticsInfoEntity, MemberStatisticsInfoDTO> implements MemberStatisticsInfoService {

    @Override
    public QueryWrapper<MemberStatisticsInfoEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<MemberStatisticsInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}