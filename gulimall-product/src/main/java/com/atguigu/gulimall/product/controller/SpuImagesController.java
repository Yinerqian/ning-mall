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
import com.atguigu.gulimall.product.dto.SpuImagesDTO;
import com.atguigu.gulimall.product.excel.SpuImagesExcel;
import com.atguigu.gulimall.product.service.SpuImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * spu图片
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("product/spuimages")
public class SpuImagesController {
    @Autowired
    private SpuImagesService spuImagesService;

    @GetMapping("page")
    //@RequiresPermissions("product:spuimages:page")
    public Result<PageData<SpuImagesDTO>> page(@RequestParam Map<String, Object> params){
        PageData<SpuImagesDTO> page = spuImagesService.page(params);

        return new Result<PageData<SpuImagesDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("product:spuimages:info")
    public Result<SpuImagesDTO> get(@PathVariable("id") Long id){
        SpuImagesDTO data = spuImagesService.get(id);

        return new Result<SpuImagesDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("product:spuimages:save")
    public Result save(@RequestBody SpuImagesDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        spuImagesService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("product:spuimages:update")
    public Result update(@RequestBody SpuImagesDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        spuImagesService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("product:spuimages:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        spuImagesService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("product:spuimages:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<SpuImagesDTO> list = spuImagesService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "spu图片", list, SpuImagesExcel.class);
    }

}
