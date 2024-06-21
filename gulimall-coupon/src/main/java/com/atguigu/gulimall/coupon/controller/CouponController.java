package com.atguigu.gulimall.coupon.controller;

import cn.hutool.core.util.NumberUtil;
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
import com.atguigu.gulimall.coupon.dto.CouponDTO;
import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.atguigu.gulimall.coupon.excel.CouponExcel;
import com.atguigu.gulimall.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * 优惠券信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @GetMapping("getCouponByMember")
    public Result getCouponByMember(@RequestParam String couponName) {
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName(couponName);
        couponEntity.setAmount(NumberUtil.toBigDecimal(99));

        return new Result<CouponEntity>().ok(couponEntity);
    }

    @GetMapping("page")
    //@RequiresPermissions("coupon:coupon:page")
    public Result<PageData<CouponDTO>> page(@RequestParam Map<String, Object> params){
        PageData<CouponDTO> page = couponService.page(params);

        return new Result<PageData<CouponDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("coupon:coupon:info")
    public Result<CouponDTO> get(@PathVariable("id") Long id){
        CouponDTO data = couponService.get(id);

        return new Result<CouponDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("coupon:coupon:save")
    public Result save(@RequestBody CouponDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        couponService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("coupon:coupon:update")
    public Result update(@RequestBody CouponDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        couponService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("coupon:coupon:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        couponService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("coupon:coupon:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<CouponDTO> list = couponService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "优惠券信息", list, CouponExcel.class);
    }

}
