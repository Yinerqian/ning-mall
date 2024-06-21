package com.atguigu.gulimall.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 退货原因
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class OrderReturnReasonDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private Integer sort;

	private Integer status;

	private Date createTime;


}
