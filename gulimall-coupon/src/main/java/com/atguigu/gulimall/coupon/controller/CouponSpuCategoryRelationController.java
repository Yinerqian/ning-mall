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
import com.atguigu.gulimall.coupon.dto.CouponSpuCategoryRelationDTO;
import com.atguigu.gulimall.coupon.excel.CouponSpuCategoryRelationExcel;
import com.atguigu.gulimall.coupon.service.CouponSpuCategoryRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 优惠券分类关联
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("coupon/couponspucategoryrelation")
public class CouponSpuCategoryRelationController {
    @Autowired
    private CouponSpuCategoryRelationService couponSpuCategoryRelationService;

    @GetMapping("page")
    //@RequiresPermissions("coupon:couponspucategoryrelation:page")
    public Result<PageData<CouponSpuCategoryRelationDTO>> page(@RequestParam Map<String, Object> params){
        PageData<CouponSpuCategoryRelationDTO> page = couponSpuCategoryRelationService.page(params);

        return new Result<PageData<CouponSpuCategoryRelationDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("coupon:couponspucategoryrelation:info")
    public Result<CouponSpuCategoryRelationDTO> get(@PathVariable("id") Long id){
        CouponSpuCategoryRelationDTO data = couponSpuCategoryRelationService.get(id);

        return new Result<CouponSpuCategoryRelationDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("coupon:couponspucategoryrelation:save")
    public Result save(@RequestBody CouponSpuCategoryRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        couponSpuCategoryRelationService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("coupon:couponspucategoryrelation:update")
    public Result update(@RequestBody CouponSpuCategoryRelationDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        couponSpuCategoryRelationService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("coupon:couponspucategoryrelation:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        couponSpuCategoryRelationService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("coupon:couponspucategoryrelation:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<CouponSpuCategoryRelationDTO> list = couponSpuCategoryRelationService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "优惠券分类关联", list, CouponSpuCategoryRelationExcel.class);
    }

}
