package com.atguigu.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.Date;

/**
 * 
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
@TableName("undo_log")
public class UndoLogEntity {

    /**
     * 
     */
	private Long id;
    /**
     * 
     */
	private Long branchId;
    /**
     * 
     */
	private String xid;
    /**
     * 
     */
	private String context;
    /**
     * 
     */
	private byte[] rollbackInfo;
    /**
     * 
     */
	private Integer logStatus;
    /**
     * 
     */
	private Date logCreated;
    /**
     * 
     */
	private Date logModified;
    /**
     * 
     */
	private String ext;
}