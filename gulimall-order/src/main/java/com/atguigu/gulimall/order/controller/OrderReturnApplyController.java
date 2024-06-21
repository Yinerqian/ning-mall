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
import com.atguigu.gulimall.order.dto.OrderReturnApplyDTO;
import com.atguigu.gulimall.order.excel.OrderReturnApplyExcel;
import com.atguigu.gulimall.order.service.OrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 订单退货申请
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("order/orderreturnapply")
public class OrderReturnApplyController {
    @Autowired
    private OrderReturnApplyService orderReturnApplyService;

    @GetMapping("page")
    //@RequiresPermissions("order:orderreturnapply:page")
    public Result<PageData<OrderReturnApplyDTO>> page(@RequestParam Map<String, Object> params){
        PageData<OrderReturnApplyDTO> page = orderReturnApplyService.page(params);

        return new Result<PageData<OrderReturnApplyDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("order:orderreturnapply:info")
    public Result<OrderReturnApplyDTO> get(@PathVariable("id") Long id){
        OrderReturnApplyDTO data = orderReturnApplyService.get(id);

        return new Result<OrderReturnApplyDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("order:orderreturnapply:save")
    public Result save(@RequestBody OrderReturnApplyDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        orderReturnApplyService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("order:orderreturnapply:update")
    public Result update(@RequestBody OrderReturnApplyDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        orderReturnApplyService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("order:orderreturnapply:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        orderReturnApplyService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("order:orderreturnapply:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<OrderReturnApplyDTO> list = orderReturnApplyService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "订单退货申请", list, OrderReturnApplyExcel.class);
    }

}
