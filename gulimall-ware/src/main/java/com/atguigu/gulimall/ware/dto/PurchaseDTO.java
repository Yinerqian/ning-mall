package com.atguigu.gulimall.ware.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 采购信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class PurchaseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long assigneeId;

	private String assigneeName;

	private String phone;

	private Integer priority;

	private Integer status;

	private Long wareId;

	private BigDecimal amount;

	private Date createTime;

	private Date updateTime;


}
