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
import com.atguigu.gulimall.order.dto.PaymentInfoDTO;
import com.atguigu.gulimall.order.excel.PaymentInfoExcel;
import com.atguigu.gulimall.order.service.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 支付信息表
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("order/paymentinfo")
public class PaymentInfoController {
    @Autowired
    private PaymentInfoService paymentInfoService;

    @GetMapping("page")
    //@RequiresPermissions("order:paymentinfo:page")
    public Result<PageData<PaymentInfoDTO>> page(@RequestParam Map<String, Object> params){
        PageData<PaymentInfoDTO> page = paymentInfoService.page(params);

        return new Result<PageData<PaymentInfoDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("order:paymentinfo:info")
    public Result<PaymentInfoDTO> get(@PathVariable("id") Long id){
        PaymentInfoDTO data = paymentInfoService.get(id);

        return new Result<PaymentInfoDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("order:paymentinfo:save")
    public Result save(@RequestBody PaymentInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        paymentInfoService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("order:paymentinfo:update")
    public Result update(@RequestBody PaymentInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        paymentInfoService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("order:paymentinfo:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        paymentInfoService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("order:paymentinfo:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<PaymentInfoDTO> list = paymentInfoService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "支付信息表", list, PaymentInfoExcel.class);
    }

}
