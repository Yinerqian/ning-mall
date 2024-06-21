package com.atguigu.gulimall.member.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 会员收藏的商品
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class MemberCollectSpuDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long memberId;

	private Long spuId;

	private String spuName;

	private String spuImg;

	private Date createTime;


}
