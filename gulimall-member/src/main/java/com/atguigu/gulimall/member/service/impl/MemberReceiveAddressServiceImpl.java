package com.atguigu.gulimall.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.gulimall.common.service.impl.CrudServiceImpl;
import com.atguigu.gulimall.member.dao.MemberReceiveAddressDao;
import com.atguigu.gulimall.member.dto.MemberReceiveAddressDTO;
import com.atguigu.gulimall.member.entity.MemberReceiveAddressEntity;
import com.atguigu.gulimall.member.service.MemberReceiveAddressService;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 会员收货地址
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Service
public class MemberReceiveAddressServiceImpl extends CrudServiceImpl<MemberReceiveAddressDao, MemberReceiveAddressEntity, MemberReceiveAddressDTO> implements MemberReceiveAddressService {

    @Override
    public QueryWrapper<MemberReceiveAddressEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<MemberReceiveAddressEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }


}