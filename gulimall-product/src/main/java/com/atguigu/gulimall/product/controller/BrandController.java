package com.atguigu.gulimall.product.controller;

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
import com.atguigu.gulimall.product.dto.BrandDTO;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.excel.BrandExcel;
import com.atguigu.gulimall.product.service.BrandService;
import com.atguigu.gulimall.product.service.impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 品牌
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("${url.prefix}/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandServiceImpl brandServiceImpl;

    @GetMapping("page")
    public Result<PageData<BrandDTO>> page(@RequestParam Map<String, Object> params){
        PageData<BrandDTO> page = brandService.page(params);

        return new Result<PageData<BrandDTO>>().ok(page);
    }

    @GetMapping("findBrandById")
    public Result<BrandEntity> get(@RequestParam("id") Long id){
        BrandEntity brandEntity = brandService.findBrandById(id);

        return new Result<BrandEntity>().ok(brandEntity);
    }

    //效验数据
    @PostMapping("saveBrand")
    @LogOperation("保存")
    public Result saveBrand(@RequestBody BrandEntity brandEntity){
        brandServiceImpl.saveBrand(brandEntity);
        return new Result();
    }

    @PutMapping("updateBrandById")
    @LogOperation("修改")
    public Result updateBrandById(@RequestBody BrandEntity brandEntity){
        brandService.updateBrandById(brandEntity);
        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        brandService.delete(ids);

        return new Result();
    }

    @DeleteMapping("deleteBrandById")
    @LogOperation("删除")
    public Result deleteBrandById(@RequestParam("id") String id){
        brandServiceImpl.deleteBrandById(id);
        return new Result();
    }

}
