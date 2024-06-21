package com.atguigu.gulimall.coupon.controller;

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
import com.atguigu.gulimall.coupon.dto.CouponHistoryDTO;
import com.atguigu.gulimall.coupon.excel.CouponHistoryExcel;
import com.atguigu.gulimall.coupon.service.CouponHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 优惠券领取历史记录
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("coupon/couponhistory")
public class CouponHistoryController {
    @Autowired
    private CouponHistoryService couponHistoryService;

    @GetMapping("page")
    //@RequiresPermissions("coupon:couponhistory:page")
    public Result<PageData<CouponHistoryDTO>> page(@RequestParam Map<String, Object> params){
        PageData<CouponHistoryDTO> page = couponHistoryService.page(params);

        return new Result<PageData<CouponHistoryDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("coupon:couponhistory:info")
    public Result<CouponHistoryDTO> get(@PathVariable("id") Long id){
        CouponHistoryDTO data = couponHistoryService.get(id);

        return new Result<CouponHistoryDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("coupon:couponhistory:save")
    public Result save(@RequestBody CouponHistoryDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        couponHistoryService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("coupon:couponhistory:update")
    public Result update(@RequestBody CouponHistoryDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        couponHistoryService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("coupon:couponhistory:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        couponHistoryService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("coupon:couponhistory:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<CouponHistoryDTO> list = couponHistoryService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "优惠券领取历史记录", list, CouponHistoryExcel.class);
    }

}
