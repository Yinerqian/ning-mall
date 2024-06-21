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
import com.atguigu.gulimall.ware.dto.UndoLogDTO;
import com.atguigu.gulimall.ware.excel.UndoLogExcel;
import com.atguigu.gulimall.ware.service.UndoLogService;
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
@RequestMapping("ware/undolog")
public class UndoLogController {
    @Autowired
    private UndoLogService undoLogService;

    @GetMapping("page")
    //@RequiresPermissions("ware:undolog:page")
    public Result<PageData<UndoLogDTO>> page(@RequestParam Map<String, Object> params){
        PageData<UndoLogDTO> page = undoLogService.page(params);

        return new Result<PageData<UndoLogDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("ware:undolog:info")
    public Result<UndoLogDTO> get(@PathVariable("id") Long id){
        UndoLogDTO data = undoLogService.get(id);

        return new Result<UndoLogDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("ware:undolog:save")
    public Result save(@RequestBody UndoLogDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        undoLogService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("ware:undolog:update")
    public Result update(@RequestBody UndoLogDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        undoLogService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("ware:undolog:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        undoLogService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("ware:undolog:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<UndoLogDTO> list = undoLogService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "", list, UndoLogExcel.class);
    }

}
