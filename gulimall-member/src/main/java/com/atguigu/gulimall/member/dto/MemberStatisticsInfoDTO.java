package com.atguigu.gulimall.member.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 会员统计信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class MemberStatisticsInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long memberId;

	private BigDecimal consumeAmount;

	private BigDecimal couponAmount;

	private Integer orderCount;

	private Integer couponCount;

	private Integer commentCount;

	private Integer returnOrderCount;

	private Integer loginCount;

	private Integer attendCount;

	private Integer fansCount;

	private Integer collectProductCount;

	private Integer collectSubjectCount;

	private Integer collectCommentCount;

	private Integer inviteFriendCount;


}
