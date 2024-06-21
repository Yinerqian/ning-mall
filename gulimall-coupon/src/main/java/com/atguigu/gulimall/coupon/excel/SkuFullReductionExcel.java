package com.atguigu.gulimall.coupon.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品满减信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class SkuFullReductionExcel {
    @ExcelProperty(value = "id")
    private Long id;
    @ExcelProperty(value = "spu_id")
    private Long skuId;
    @ExcelProperty(value = "满多少")
    private BigDecimal fullPrice;
    @ExcelProperty(value = "减多少")
    private BigDecimal reducePrice;
    @ExcelProperty(value = "是否参与其他优惠")
    private Integer addOther;

}