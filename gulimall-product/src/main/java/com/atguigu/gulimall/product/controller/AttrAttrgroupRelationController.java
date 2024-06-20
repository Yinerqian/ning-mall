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
import com.atguigu.gulimall.product.dto.AttrAttrgroupRelationDTO;
import com.atguigu.gulimall.product.excel.AttrAttrgroupRelationExcel;
import com.atguigu.gulimall.product.service.AttrAttrgroupRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 属性&属性分组关联
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("product/attrattrgrouprelation")
public class AttrAttrgroupRelationController {
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    @GetMapping("page")
    //@RequiresPermissions("product:attrattrgrouprelation:page")
    public Result<PageData<AttrAttrgroupRelationDTO>> page(@RequestParam Map<String, Object> params){
        PageData<AttrAttrgroupRelationDTO> page = attrAttrgroupRelationService.page(params);

        return new Result<PageData<AttrAttrgroupRelationDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("product:attrattrgrouprelation:info")
    public Result<AttrAttrgroupRelationDTO> get(@PathVariable("id") Long id){
        AttrAttrgroupRelationDTO data = attrAttrgroupRelationService.get(id);

        return new Result<AttrAttrgroupRelationDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("product:attrattrgrouprelation:save")
    public Result save(@RequestBody AttrAttrgroupRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        attrAttrgroupRelationService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("product:attrattrgrouprelation:update")
    public Result update(@RequestBody AttrAttrgroupRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        attrAttrgroupRelationService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("product:attrattrgrouprelation:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        attrAttrgroupRelationService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("product:attrattrgrouprelation:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<AttrAttrgroupRelationDTO> list = attrAttrgroupRelationService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "属性&属性分组关联", list, AttrAttrgroupRelationExcel.class);
    }

}
