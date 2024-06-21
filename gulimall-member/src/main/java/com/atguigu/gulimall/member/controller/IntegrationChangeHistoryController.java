package com.atguigu.gulimall.member.controller;

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
import com.atguigu.gulimall.member.dto.IntegrationChangeHistoryDTO;
import com.atguigu.gulimall.member.excel.IntegrationChangeHistoryExcel;
import com.atguigu.gulimall.member.service.IntegrationChangeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 积分变化历史记录
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("member/integrationchangehistory")
public class IntegrationChangeHistoryController {
    @Autowired
    private IntegrationChangeHistoryService integrationChangeHistoryService;

    @GetMapping("page")
    //@RequiresPermissions("member:integrationchangehistory:page")
    public Result<PageData<IntegrationChangeHistoryDTO>> page(@RequestParam Map<String, Object> params){
        PageData<IntegrationChangeHistoryDTO> page = integrationChangeHistoryService.page(params);

        return new Result<PageData<IntegrationChangeHistoryDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("member:integrationchangehistory:info")
    public Result<IntegrationChangeHistoryDTO> get(@PathVariable("id") Long id){
        IntegrationChangeHistoryDTO data = integrationChangeHistoryService.get(id);

        return new Result<IntegrationChangeHistoryDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("member:integrationchangehistory:save")
    public Result save(@RequestBody IntegrationChangeHistoryDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        integrationChangeHistoryService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("member:integrationchangehistory:update")
    public Result update(@RequestBody IntegrationChangeHistoryDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        integrationChangeHistoryService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("member:integrationchangehistory:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        integrationChangeHistoryService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("member:integrationchangehistory:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<IntegrationChangeHistoryDTO> list = integrationChangeHistoryService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "积分变化历史记录", list, IntegrationChangeHistoryExcel.class);
    }

}
