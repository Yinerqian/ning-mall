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
import com.atguigu.gulimall.coupon.dto.SeckillPromotionDTO;
import com.atguigu.gulimall.coupon.excel.SeckillPromotionExcel;
import com.atguigu.gulimall.coupon.service.SeckillPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 秒杀活动
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("coupon/seckillpromotion")
public class SeckillPromotionController {
    @Autowired
    private SeckillPromotionService seckillPromotionService;

    @GetMapping("page")
    //@RequiresPermissions("coupon:seckillpromotion:page")
    public Result<PageData<SeckillPromotionDTO>> page(@RequestParam Map<String, Object> params){
        PageData<SeckillPromotionDTO> page = seckillPromotionService.page(params);

        return new Result<PageData<SeckillPromotionDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("coupon:seckillpromotion:info")
    public Result<SeckillPromotionDTO> get(@PathVariable("id") Long id){
        SeckillPromotionDTO data = seckillPromotionService.get(id);

        return new Result<SeckillPromotionDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("coupon:seckillpromotion:save")
    public Result save(@RequestBody SeckillPromotionDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        seckillPromotionService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("coupon:seckillpromotion:update")
    public Result update(@RequestBody SeckillPromotionDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        seckillPromotionService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("coupon:seckillpromotion:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        seckillPromotionService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("coupon:seckillpromotion:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<SeckillPromotionDTO> list = seckillPromotionService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "秒杀活动", list, SeckillPromotionExcel.class);
    }

}
