package com.atguigu.gulimall.ware.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 仓库信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class WareInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String address;

	private String areacode;


}
