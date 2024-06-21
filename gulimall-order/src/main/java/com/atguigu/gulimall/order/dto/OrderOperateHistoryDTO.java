package com.atguigu.gulimall.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 订单操作历史记录
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class OrderOperateHistoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long orderId;

	private String operateMan;

	private Date createTime;

	private Integer orderStatus;

	private String note;


}
