package com.atguigu.gulimall.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 订单退货申请
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class OrderReturnApplyDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long orderId;

	private Long skuId;

	private String orderSn;

	private Date createTime;

	private String memberUsername;

	private BigDecimal returnAmount;

	private String returnName;

	private String returnPhone;

	private Integer status;

	private Date handleTime;

	private String skuImg;

	private String skuName;

	private String skuBrand;

	private String skuAttrsVals;

	private Integer skuCount;

	private BigDecimal skuPrice;

	private BigDecimal skuRealPrice;

	private String reason;

	private String description述;

	private String descPics;

	private String handleNote;

	private String handleMan;

	private String receiveMan;

	private Date receiveTime;

	private String receiveNote;

	private String receivePhone;

	private String companyAddress;


}
