package com.atguigu.gulimall.ware.controller;

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
import com.atguigu.gulimall.ware.dto.PurchaseDTO;
import com.atguigu.gulimall.ware.excel.PurchaseExcel;
import com.atguigu.gulimall.ware.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 采购信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("ware/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("page")
    //@RequiresPermissions("ware:purchase:page")
    public Result<PageData<PurchaseDTO>> page(@RequestParam Map<String, Object> params){
        PageData<PurchaseDTO> page = purchaseService.page(params);

        return new Result<PageData<PurchaseDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("ware:purchase:info")
    public Result<PurchaseDTO> get(@PathVariable("id") Long id){
        PurchaseDTO data = purchaseService.get(id);

        return new Result<PurchaseDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("ware:purchase:save")
    public Result save(@RequestBody PurchaseDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        purchaseService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("ware:purchase:update")
    public Result update(@RequestBody PurchaseDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        purchaseService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("ware:purchase:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        purchaseService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("ware:purchase:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<PurchaseDTO> list = purchaseService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "采购信息", list, PurchaseExcel.class);
    }

}
