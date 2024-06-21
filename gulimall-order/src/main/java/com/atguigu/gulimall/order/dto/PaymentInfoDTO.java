package com.atguigu.gulimall.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 支付信息表
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class PaymentInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private String orderSn;

	private Long orderId;

	private String alipayTradeNo;

	private BigDecimal totalAmount;

	private String subject;

	private String paymentStatus;

	private Date createTime;

	private Date confirmTime;

	private String callbackContent;

	private Date callbackTime;


}
