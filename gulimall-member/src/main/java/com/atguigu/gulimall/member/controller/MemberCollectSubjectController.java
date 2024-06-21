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
import com.atguigu.gulimall.member.dto.MemberCollectSubjectDTO;
import com.atguigu.gulimall.member.excel.MemberCollectSubjectExcel;
import com.atguigu.gulimall.member.service.MemberCollectSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 会员收藏的专题活动
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("member/membercollectsubject")
public class MemberCollectSubjectController {
    @Autowired
    private MemberCollectSubjectService memberCollectSubjectService;

    @GetMapping("page")
    //@RequiresPermissions("member:membercollectsubject:page")
    public Result<PageData<MemberCollectSubjectDTO>> page(@RequestParam Map<String, Object> params){
        PageData<MemberCollectSubjectDTO> page = memberCollectSubjectService.page(params);

        return new Result<PageData<MemberCollectSubjectDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("member:membercollectsubject:info")
    public Result<MemberCollectSubjectDTO> get(@PathVariable("id") Long id){
        MemberCollectSubjectDTO data = memberCollectSubjectService.get(id);

        return new Result<MemberCollectSubjectDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("member:membercollectsubject:save")
    public Result save(@RequestBody MemberCollectSubjectDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        memberCollectSubjectService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("member:membercollectsubject:update")
    public Result update(@RequestBody MemberCollectSubjectDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        memberCollectSubjectService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("member:membercollectsubject:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        memberCollectSubjectService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("member:membercollectsubject:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<MemberCollectSubjectDTO> list = memberCollectSubjectService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "会员收藏的专题活动", list, MemberCollectSubjectExcel.class);
    }

}
