package com.atguigu.gulimall.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
@TableName("mq_message")
public class MqMessageEntity {

    /**
     * 
     */
	private String messageId;
    /**
     * 
     */
	private String content;
    /**
     * 
     */
	private String toExchane;
    /**
     * 
     */
	private String routingKey;
    /**
     * 
     */
	private String classType;
    /**
     * 0-新建 1-已发送 2-错误抵达 3-已抵达
     */
	private Integer messageStatus;
    /**
     * 
     */
	private Date createTime;
    /**
     * 
     */
	private Date updateTime;
}