package com.atguigu.gulimall.order.controller;

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
import com.atguigu.gulimall.order.dto.OrderOperateHistoryDTO;
import com.atguigu.gulimall.order.excel.OrderOperateHistoryExcel;
import com.atguigu.gulimall.order.service.OrderOperateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 订单操作历史记录
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("order/orderoperatehistory")
public class OrderOperateHistoryController {
    @Autowired
    private OrderOperateHistoryService orderOperateHistoryService;

    @GetMapping("page")
    //@RequiresPermissions("order:orderoperatehistory:page")
    public Result<PageData<OrderOperateHistoryDTO>> page(@RequestParam Map<String, Object> params){
        PageData<OrderOperateHistoryDTO> page = orderOperateHistoryService.page(params);

        return new Result<PageData<OrderOperateHistoryDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("order:orderoperatehistory:info")
    public Result<OrderOperateHistoryDTO> get(@PathVariable("id") Long id){
        OrderOperateHistoryDTO data = orderOperateHistoryService.get(id);

        return new Result<OrderOperateHistoryDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("order:orderoperatehistory:save")
    public Result save(@RequestBody OrderOperateHistoryDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        orderOperateHistoryService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("order:orderoperatehistory:update")
    public Result update(@RequestBody OrderOperateHistoryDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        orderOperateHistoryService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("order:orderoperatehistory:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        orderOperateHistoryService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("order:orderoperatehistory:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<OrderOperateHistoryDTO> list = orderOperateHistoryService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "订单操作历史记录", list, OrderOperateHistoryExcel.class);
    }

}
