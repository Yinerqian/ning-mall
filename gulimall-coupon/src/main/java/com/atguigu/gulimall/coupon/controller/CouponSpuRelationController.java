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
import com.atguigu.gulimall.coupon.dto.CouponSpuRelationDTO;
import com.atguigu.gulimall.coupon.excel.CouponSpuRelationExcel;
import com.atguigu.gulimall.coupon.service.CouponSpuRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 优惠券与产品关联
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("coupon/couponspurelation")
public class CouponSpuRelationController {
    @Autowired
    private CouponSpuRelationService couponSpuRelationService;

    @GetMapping("page")
    //@RequiresPermissions("coupon:couponspurelation:page")
    public Result<PageData<CouponSpuRelationDTO>> page(@RequestParam Map<String, Object> params){
        PageData<CouponSpuRelationDTO> page = couponSpuRelationService.page(params);

        return new Result<PageData<CouponSpuRelationDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("coupon:couponspurelation:info")
    public Result<CouponSpuRelationDTO> get(@PathVariable("id") Long id){
        CouponSpuRelationDTO data = couponSpuRelationService.get(id);

        return new Result<CouponSpuRelationDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("coupon:couponspurelation:save")
    public Result save(@RequestBody CouponSpuRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        couponSpuRelationService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("coupon:couponspurelation:update")
    public Result update(@RequestBody CouponSpuRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        couponSpuRelationService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("coupon:couponspurelation:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        couponSpuRelationService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("coupon:couponspurelation:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<CouponSpuRelationDTO> list = couponSpuRelationService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "优惠券与产品关联", list, CouponSpuRelationExcel.class);
    }

}
