package com.atguigu.gulimall.member.controller;

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
import com.atguigu.gulimall.member.dto.MemberCollectSpuDTO;
import com.atguigu.gulimall.member.excel.MemberCollectSpuExcel;
import com.atguigu.gulimall.member.service.MemberCollectSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 会员收藏的商品
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("member/membercollectspu")
public class MemberCollectSpuController {
    @Autowired
    private MemberCollectSpuService memberCollectSpuService;

    @GetMapping("page")
    //@RequiresPermissions("member:membercollectspu:page")
    public Result<PageData<MemberCollectSpuDTO>> page(@RequestParam Map<String, Object> params){
        PageData<MemberCollectSpuDTO> page = memberCollectSpuService.page(params);

        return new Result<PageData<MemberCollectSpuDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("member:membercollectspu:info")
    public Result<MemberCollectSpuDTO> get(@PathVariable("id") Long id){
        MemberCollectSpuDTO data = memberCollectSpuService.get(id);

        return new Result<MemberCollectSpuDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("member:membercollectspu:save")
    public Result save(@RequestBody MemberCollectSpuDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        memberCollectSpuService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("member:membercollectspu:update")
    public Result update(@RequestBody MemberCollectSpuDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        memberCollectSpuService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("member:membercollectspu:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        memberCollectSpuService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("member:membercollectspu:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<MemberCollectSpuDTO> list = memberCollectSpuService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "会员收藏的商品", list, MemberCollectSpuExcel.class);
    }

}
