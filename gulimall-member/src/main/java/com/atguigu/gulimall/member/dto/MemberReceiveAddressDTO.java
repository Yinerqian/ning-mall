package com.atguigu.gulimall.member.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 会员收货地址
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class MemberReceiveAddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long memberId;

	private String name;

	private String phone;

	private String postCode;

	private String province;

	private String city;

	private String region;

	private String detailAddress;

	private String areacode;

	private Integer defaultStatus;


}
