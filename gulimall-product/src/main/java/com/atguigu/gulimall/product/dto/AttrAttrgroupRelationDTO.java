package com.atguigu.gulimall.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 属性&属性分组关联
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class AttrAttrgroupRelationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long attrId;

	private Long attrGroupId;

	private Integer attrSort;


}
