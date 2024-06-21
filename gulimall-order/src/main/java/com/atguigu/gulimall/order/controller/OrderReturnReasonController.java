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
import com.atguigu.gulimall.order.dto.OrderReturnReasonDTO;
import com.atguigu.gulimall.order.excel.OrderReturnReasonExcel;
import com.atguigu.gulimall.order.service.OrderReturnReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 退货原因
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("order/orderreturnreason")
public class OrderReturnReasonController {
    @Autowired
    private OrderReturnReasonService orderReturnReasonService;

    @GetMapping("page")
    //@RequiresPermissions("order:orderreturnreason:page")
    public Result<PageData<OrderReturnReasonDTO>> page(@RequestParam Map<String, Object> params){
        PageData<OrderReturnReasonDTO> page = orderReturnReasonService.page(params);

        return new Result<PageData<OrderReturnReasonDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("order:orderreturnreason:info")
    public Result<OrderReturnReasonDTO> get(@PathVariable("id") Long id){
        OrderReturnReasonDTO data = orderReturnReasonService.get(id);

        return new Result<OrderReturnReasonDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("order:orderreturnreason:save")
    public Result save(@RequestBody OrderReturnReasonDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        orderReturnReasonService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("order:orderreturnreason:update")
    public Result update(@RequestBody OrderReturnReasonDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        orderReturnReasonService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("order:orderreturnreason:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        orderReturnReasonService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("order:orderreturnreason:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<OrderReturnReasonDTO> list = orderReturnReasonService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "退货原因", list, OrderReturnReasonExcel.class);
    }

}
