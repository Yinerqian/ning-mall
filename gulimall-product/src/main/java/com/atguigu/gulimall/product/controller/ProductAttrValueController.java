package com.atguigu.gulimall.product.controller;

import com.atguigu.gulimall.common.annotation.LogOperation;
import com.atguigu.gulimall.common.constant.Constant;
import com.atguigu.gulimall.common.page.PageData;
import com.atguigu.gulimall.common.utils.ExcelUtils;
import com.atguigu.gulimall.common.utils.Result;
import com.atguigu.gulimall.common.validator.AssertUtils;
import com.atguigu.gulimall.common.validator.ValidatorUtils;
import com.atguigu.gulimall.common.validator.group.AddGroup;
import com.atguigu.gulimall.common.validator.group.DefaultGroup;
import com.atguigu.gulimall.common.validator.group.UpdateGroup;
import com.atguigu.gulimall.product.dto.ProductAttrValueDTO;
import com.atguigu.gulimall.product.excel.ProductAttrValueExcel;
import com.atguigu.gulimall.product.service.ProductAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * spu属性值
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("product/productattrvalue")
public class ProductAttrValueController {
    @Autowired
    private ProductAttrValueService productAttrValueService;

    @GetMapping("page")
    //@RequiresPermissions("product:productattrvalue:page")
    public Result<PageData<ProductAttrValueDTO>> page(@RequestParam Map<String, Object> params){
        PageData<ProductAttrValueDTO> page = productAttrValueService.page(params);

        return new Result<PageData<ProductAttrValueDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("product:productattrvalue:info")
    public Result<ProductAttrValueDTO> get(@PathVariable("id") Long id){
        ProductAttrValueDTO data = productAttrValueService.get(id);

        return new Result<ProductAttrValueDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("product:productattrvalue:save")
    public Result save(@RequestBody ProductAttrValueDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        productAttrValueService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("product:productattrvalue:update")
    public Result update(@RequestBody ProductAttrValueDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        productAttrValueService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("product:productattrvalue:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        productAttrValueService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("product:productattrvalue:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<ProductAttrValueDTO> list = productAttrValueService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "spu属性值", list, ProductAttrValueExcel.class);
    }

}
