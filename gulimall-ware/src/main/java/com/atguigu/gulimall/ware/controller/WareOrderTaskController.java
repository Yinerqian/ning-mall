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
import com.atguigu.gulimall.ware.dto.WareOrderTaskDTO;
import com.atguigu.gulimall.ware.excel.WareOrderTaskExcel;
import com.atguigu.gulimall.ware.service.WareOrderTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 库存工作单
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("ware/wareordertask")
public class WareOrderTaskController {
    @Autowired
    private WareOrderTaskService wareOrderTaskService;

    @GetMapping("page")
    //@RequiresPermissions("ware:wareordertask:page")
    public Result<PageData<WareOrderTaskDTO>> page(@RequestParam Map<String, Object> params){
        PageData<WareOrderTaskDTO> page = wareOrderTaskService.page(params);

        return new Result<PageData<WareOrderTaskDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("ware:wareordertask:info")
    public Result<WareOrderTaskDTO> get(@PathVariable("id") Long id){
        WareOrderTaskDTO data = wareOrderTaskService.get(id);

        return new Result<WareOrderTaskDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("ware:wareordertask:save")
    public Result save(@RequestBody WareOrderTaskDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        wareOrderTaskService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("ware:wareordertask:update")
    public Result update(@RequestBody WareOrderTaskDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        wareOrderTaskService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("ware:wareordertask:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        wareOrderTaskService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("ware:wareordertask:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<WareOrderTaskDTO> list = wareOrderTaskService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "库存工作单", list, WareOrderTaskExcel.class);
    }

}
