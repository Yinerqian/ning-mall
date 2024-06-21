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
import com.atguigu.gulimall.coupon.dto.SeckillSkuNoticeDTO;
import com.atguigu.gulimall.coupon.excel.SeckillSkuNoticeExcel;
import com.atguigu.gulimall.coupon.service.SeckillSkuNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 秒杀商品通知订阅
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("coupon/seckillskunotice")
public class SeckillSkuNoticeController {
    @Autowired
    private SeckillSkuNoticeService seckillSkuNoticeService;

    @GetMapping("page")
    //@RequiresPermissions("coupon:seckillskunotice:page")
    public Result<PageData<SeckillSkuNoticeDTO>> page(@RequestParam Map<String, Object> params){
        PageData<SeckillSkuNoticeDTO> page = seckillSkuNoticeService.page(params);

        return new Result<PageData<SeckillSkuNoticeDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("coupon:seckillskunotice:info")
    public Result<SeckillSkuNoticeDTO> get(@PathVariable("id") Long id){
        SeckillSkuNoticeDTO data = seckillSkuNoticeService.get(id);

        return new Result<SeckillSkuNoticeDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("coupon:seckillskunotice:save")
    public Result save(@RequestBody SeckillSkuNoticeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        seckillSkuNoticeService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("coupon:seckillskunotice:update")
    public Result update(@RequestBody SeckillSkuNoticeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        seckillSkuNoticeService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("coupon:seckillskunotice:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        seckillSkuNoticeService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("coupon:seckillskunotice:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<SeckillSkuNoticeDTO> list = seckillSkuNoticeService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "秒杀商品通知订阅", list, SeckillSkuNoticeExcel.class);
    }

}
