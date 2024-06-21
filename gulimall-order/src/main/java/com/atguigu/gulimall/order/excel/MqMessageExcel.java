package com.atguigu.gulimall.order.excel;

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
public class MqMessageExcel {
    @ExcelProperty(value = "")
    private String messageId;
    @ExcelProperty(value = "")
    private String content;
    @ExcelProperty(value = "")
    private String toExchane;
    @ExcelProperty(value = "")
    private String routingKey;
    @ExcelProperty(value = "")
    private String classType;
    @ExcelProperty(value = "0-新建 1-已发送 2-错误抵达 3-已抵达")
    private Integer messageStatus;
    @ExcelProperty(value = "")
    private Date createTime;
    @ExcelProperty(value = "")
    private Date updateTime;

}