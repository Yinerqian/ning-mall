package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.common.dao.BaseDao;
import com.atguigu.gulimall.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Mapper
public interface MemberDao extends BaseDao<MemberEntity> {
	
}