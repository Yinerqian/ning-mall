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
import com.atguigu.gulimall.ware.dto.PurchaseDetailDTO;
import com.atguigu.gulimall.ware.excel.PurchaseDetailExcel;
import com.atguigu.gulimall.ware.service.PurchaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("ware/purchasedetail")
public class PurchaseDetailController {
    @Autowired
    private PurchaseDetailService purchaseDetailService;

    @GetMapping("page")
    //@RequiresPermissions("ware:purchasedetail:page")
    public Result<PageData<PurchaseDetailDTO>> page(@RequestParam Map<String, Object> params){
        PageData<PurchaseDetailDTO> page = purchaseDetailService.page(params);

        return new Result<PageData<PurchaseDetailDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("ware:purchasedetail:info")
    public Result<PurchaseDetailDTO> get(@PathVariable("id") Long id){
        PurchaseDetailDTO data = purchaseDetailService.get(id);

        return new Result<PurchaseDetailDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("ware:purchasedetail:save")
    public Result save(@RequestBody PurchaseDetailDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        purchaseDetailService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("ware:purchasedetail:update")
    public Result update(@RequestBody PurchaseDetailDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        purchaseDetailService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("ware:purchasedetail:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        purchaseDetailService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("ware:purchasedetail:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<PurchaseDetailDTO> list = purchaseDetailService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "", list, PurchaseDetailExcel.class);
    }

}
