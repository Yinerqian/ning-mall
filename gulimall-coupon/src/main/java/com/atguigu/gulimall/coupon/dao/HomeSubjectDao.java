package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.common.dao.BaseDao;
import com.atguigu.gulimall.coupon.entity.HomeSubjectEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Mapper
public interface HomeSubjectDao extends BaseDao<HomeSubjectEntity> {
	
}