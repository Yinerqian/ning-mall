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
public class WareOrderTaskDetailDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long skuId;

	private String skuName;

	private Integer skuNum;

	private Long taskId;

	private Long wareId;

	private Integer lockStatus;


}
