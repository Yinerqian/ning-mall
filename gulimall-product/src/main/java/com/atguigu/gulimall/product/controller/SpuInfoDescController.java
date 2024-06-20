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
import com.atguigu.gulimall.product.dto.SpuInfoDescDTO;
import com.atguigu.gulimall.product.excel.SpuInfoDescExcel;
import com.atguigu.gulimall.product.service.SpuInfoDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * spu信息介绍
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("product/spuinfodesc")
public class SpuInfoDescController {
    @Autowired
    private SpuInfoDescService spuInfoDescService;

    @GetMapping("page")
    //@RequiresPermissions("product:spuinfodesc:page")
    public Result<PageData<SpuInfoDescDTO>> page(@RequestParam Map<String, Object> params){
        PageData<SpuInfoDescDTO> page = spuInfoDescService.page(params);

        return new Result<PageData<SpuInfoDescDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("product:spuinfodesc:info")
    public Result<SpuInfoDescDTO> get(@PathVariable("id") Long id){
        SpuInfoDescDTO data = spuInfoDescService.get(id);

        return new Result<SpuInfoDescDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("product:spuinfodesc:save")
    public Result save(@RequestBody SpuInfoDescDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        spuInfoDescService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("product:spuinfodesc:update")
    public Result update(@RequestBody SpuInfoDescDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        spuInfoDescService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("product:spuinfodesc:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        spuInfoDescService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("product:spuinfodesc:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<SpuInfoDescDTO> list = spuInfoDescService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "spu信息介绍", list, SpuInfoDescExcel.class);
    }

}
