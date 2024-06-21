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
import com.atguigu.gulimall.order.dto.OrderSettingDTO;
import com.atguigu.gulimall.order.excel.OrderSettingExcel;
import com.atguigu.gulimall.order.service.OrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 订单配置信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("order/ordersetting")
public class OrderSettingController {
    @Autowired
    private OrderSettingService orderSettingService;

    @GetMapping("page")
    //@RequiresPermissions("order:ordersetting:page")
    public Result<PageData<OrderSettingDTO>> page(@RequestParam Map<String, Object> params){
        PageData<OrderSettingDTO> page = orderSettingService.page(params);

        return new Result<PageData<OrderSettingDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("order:ordersetting:info")
    public Result<OrderSettingDTO> get(@PathVariable("id") Long id){
        OrderSettingDTO data = orderSettingService.get(id);

        return new Result<OrderSettingDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("order:ordersetting:save")
    public Result save(@RequestBody OrderSettingDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        orderSettingService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("order:ordersetting:update")
    public Result update(@RequestBody OrderSettingDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        orderSettingService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("order:ordersetting:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        orderSettingService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("order:ordersetting:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<OrderSettingDTO> list = orderSettingService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "订单配置信息", list, OrderSettingExcel.class);
    }

}
