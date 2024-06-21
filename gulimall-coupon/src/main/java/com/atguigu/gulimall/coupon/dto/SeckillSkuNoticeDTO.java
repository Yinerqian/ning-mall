package com.atguigu.gulimall.coupon.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 秒杀商品通知订阅
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class SeckillSkuNoticeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long memberId;

	private Long skuId;

	private Long sessionId;

	private Date subcribeTime;

	private Date sendTime;

	private Integer noticeType;


}
