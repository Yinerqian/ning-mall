package com.atguigu.gulimall.member.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * 会员登录记录
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class MemberLoginLogExcel {
    @ExcelProperty(value = "id")
    private Long id;
    @ExcelProperty(value = "member_id")
    private Long memberId;
    @ExcelProperty(value = "创建时间")
    private Date createTime;
    @ExcelProperty(value = "ip")
    private String ip;
    @ExcelProperty(value = "city")
    private String city;
    @ExcelProperty(value = "登录类型[1-web，2-app]")
    private Integer loginType;

}