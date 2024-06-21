package com.atguigu.gulimall.coupon.dto;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class UndoLogDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long branchId;

	private String xid;

	private String context;

	private T rollbackInfo;

	private Integer logStatus;

	private Date logCreated;

	private Date logModified;

	private String ext;


}
