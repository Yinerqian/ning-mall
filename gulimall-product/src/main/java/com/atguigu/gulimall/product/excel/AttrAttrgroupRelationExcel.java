package com.atguigu.gulimall.product.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * 属性&属性分组关联
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
public class AttrAttrgroupRelationExcel {
    @ExcelProperty(value = "id")
    private Long id;
    @ExcelProperty(value = "属性id")
    private Long attrId;
    @ExcelProperty(value = "属性分组id")
    private Long attrGroupId;
    @ExcelProperty(value = "属性组内排序")
    private Integer attrSort;

}