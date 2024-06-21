package com.atguigu.gulimall.ware.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class PurchaseExcel {
    @ExcelProperty(value = "")
    private Long id;
    @ExcelProperty(value = "")
    private Long assigneeId;
    @ExcelProperty(value = "")
    private String assigneeName;
    @ExcelProperty(value = "")
    private String phone;
    @ExcelProperty(value = "")
    private Integer priority;
    @ExcelProperty(value = "")
    private Integer status;
    @ExcelProperty(value = "")
    private Long wareId;
    @ExcelProperty(value = "")
    private BigDecimal amount;
    @ExcelProperty(value = "")
    private Date createTime;
    @ExcelProperty(value = "")
    private Date updateTime;

}