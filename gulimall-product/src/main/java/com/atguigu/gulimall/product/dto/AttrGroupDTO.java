package com.atguigu.gulimall.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 属性分组
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class AttrGroupDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long attrGroupId;

	private String attrGroupName;

	private Integer sort;

	private String descript;

	private String icon;

	private Long catelogId;


}
