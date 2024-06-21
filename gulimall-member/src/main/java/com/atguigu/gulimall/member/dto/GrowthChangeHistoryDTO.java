package com.atguigu.gulimall.member.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 成长值变化历史记录
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class GrowthChangeHistoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long memberId;

	private Date createTime;

	private Integer changeCount;

	private String note;

	private Integer sourceType;


}
