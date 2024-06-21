package com.atguigu.gulimall.ware.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 库存工作单
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class WareOrderTaskDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long orderId;

	private String orderSn;

	private String consignee;

	private String consigneeTel;

	private String deliveryAddress;

	private String orderComment;

	private Integer paymentWay;

	private Integer taskStatus;

	private String orderBody;

	private String trackingNo;

	private Date createTime;

	private Long wareId;

	private String taskComment;


}
