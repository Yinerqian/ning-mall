package com.atguigu.gulimall.member.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class UndoLogExcel {
    @ExcelProperty(value = "")
    private Long id;
    @ExcelProperty(value = "")
    private Long branchId;
    @ExcelProperty(value = "")
    private String xid;
    @ExcelProperty(value = "")
    private String context;
    @ExcelProperty(value = "")
    private byte[] rollbackInfo;
    @ExcelProperty(value = "")
    private Integer logStatus;
    @ExcelProperty(value = "")
    private Date logCreated;
    @ExcelProperty(value = "")
    private Date logModified;
    @ExcelProperty(value = "")
    private String ext;

}