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
import com.atguigu.gulimall.order.dto.OrderItemDTO;
import com.atguigu.gulimall.order.excel.OrderItemExcel;
import com.atguigu.gulimall.order.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 订单项信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("order/orderitem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("page")
    //@RequiresPermissions("order:orderitem:page")
    public Result<PageData<OrderItemDTO>> page(@RequestParam Map<String, Object> params){
        PageData<OrderItemDTO> page = orderItemService.page(params);

        return new Result<PageData<OrderItemDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("order:orderitem:info")
    public Result<OrderItemDTO> get(@PathVariable("id") Long id){
        OrderItemDTO data = orderItemService.get(id);

        return new Result<OrderItemDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("order:orderitem:save")
    public Result save(@RequestBody OrderItemDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        orderItemService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("order:orderitem:update")
    public Result update(@RequestBody OrderItemDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        orderItemService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("order:orderitem:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        orderItemService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("order:orderitem:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<OrderItemDTO> list = orderItemService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "订单项信息", list, OrderItemExcel.class);
    }

}
