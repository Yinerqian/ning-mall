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
import com.atguigu.gulimall.member.dto.MemberStatisticsInfoDTO;
import com.atguigu.gulimall.member.excel.MemberStatisticsInfoExcel;
import com.atguigu.gulimall.member.service.MemberStatisticsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 会员统计信息
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("member/memberstatisticsinfo")
public class MemberStatisticsInfoController {
    @Autowired
    private MemberStatisticsInfoService memberStatisticsInfoService;

    @GetMapping("page")
    //@RequiresPermissions("member:memberstatisticsinfo:page")
    public Result<PageData<MemberStatisticsInfoDTO>> page(@RequestParam Map<String, Object> params){
        PageData<MemberStatisticsInfoDTO> page = memberStatisticsInfoService.page(params);

        return new Result<PageData<MemberStatisticsInfoDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("member:memberstatisticsinfo:info")
    public Result<MemberStatisticsInfoDTO> get(@PathVariable("id") Long id){
        MemberStatisticsInfoDTO data = memberStatisticsInfoService.get(id);

        return new Result<MemberStatisticsInfoDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("member:memberstatisticsinfo:save")
    public Result save(@RequestBody MemberStatisticsInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        memberStatisticsInfoService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("member:memberstatisticsinfo:update")
    public Result update(@RequestBody MemberStatisticsInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        memberStatisticsInfoService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("member:memberstatisticsinfo:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        memberStatisticsInfoService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("member:memberstatisticsinfo:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<MemberStatisticsInfoDTO> list = memberStatisticsInfoService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "会员统计信息", list, MemberStatisticsInfoExcel.class);
    }

}
