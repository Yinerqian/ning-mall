package com.atguigu.gulimall.member.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 会员
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class MemberDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long levelId;

	private String username;

	private String password;

	private String nickname;

	private String mobile;

	private String email;

	private String header;

	private Integer gender;

	private Date birth;

	private String city;

	private String job;

	private String sign;

	private Integer sourceType;

	private Integer integration;

	private Integer growth;

	private Integer status;

	private Date createTime;

	private String socialUid;

	private String accessToken;

	private String expiresIn;


}
