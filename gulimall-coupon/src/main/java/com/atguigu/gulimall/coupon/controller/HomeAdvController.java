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
import com.atguigu.gulimall.coupon.dto.HomeAdvDTO;
import com.atguigu.gulimall.coupon.excel.HomeAdvExcel;
import com.atguigu.gulimall.coupon.service.HomeAdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 首页轮播广告
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("coupon/homeadv")
public class HomeAdvController {
    @Autowired
    private HomeAdvService homeAdvService;

    @GetMapping("page")
    //@RequiresPermissions("coupon:homeadv:page")
    public Result<PageData<HomeAdvDTO>> page(@RequestParam Map<String, Object> params){
        PageData<HomeAdvDTO> page = homeAdvService.page(params);

        return new Result<PageData<HomeAdvDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("coupon:homeadv:info")
    public Result<HomeAdvDTO> get(@PathVariable("id") Long id){
        HomeAdvDTO data = homeAdvService.get(id);

        return new Result<HomeAdvDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("coupon:homeadv:save")
    public Result save(@RequestBody HomeAdvDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        homeAdvService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("coupon:homeadv:update")
    public Result update(@RequestBody HomeAdvDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        homeAdvService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("coupon:homeadv:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        homeAdvService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("coupon:homeadv:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<HomeAdvDTO> list = homeAdvService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "首页轮播广告", list, HomeAdvExcel.class);
    }

}
