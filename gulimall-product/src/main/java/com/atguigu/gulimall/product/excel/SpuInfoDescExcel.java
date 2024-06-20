package com.atguigu.gulimall.product.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * spu信息介绍
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class SpuInfoDescExcel {
    @ExcelProperty(value = "商品id")
    private Long spuId;
    @ExcelProperty(value = "商品介绍")
    private String decript;

}