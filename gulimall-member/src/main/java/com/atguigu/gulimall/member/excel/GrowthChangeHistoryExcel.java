package com.atguigu.gulimall.member.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * 成长值变化历史记录
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class GrowthChangeHistoryExcel {
    @ExcelProperty(value = "id")
    private Long id;
    @ExcelProperty(value = "member_id")
    private Long memberId;
    @ExcelProperty(value = "create_time")
    private Date createTime;
    @ExcelProperty(value = "改变的值（正负计数）")
    private Integer changeCount;
    @ExcelProperty(value = "备注")
    private String note;
    @ExcelProperty(value = "积分来源[0-购物，1-管理员修改]")
    private Integer sourceType;

}