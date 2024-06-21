package com.atguigu.gulimall.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class MqMessageDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private String messageId;

	private String content;

	private String toExchane;

	private String routingKey;

	private String classType;

	private Integer messageStatus;

	private Date createTime;

	private Date updateTime;


}
