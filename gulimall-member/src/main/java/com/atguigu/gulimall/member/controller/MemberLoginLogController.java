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
import com.atguigu.gulimall.member.dto.MemberLoginLogDTO;
import com.atguigu.gulimall.member.excel.MemberLoginLogExcel;
import com.atguigu.gulimall.member.service.MemberLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 会员登录记录
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("member/memberloginlog")
public class MemberLoginLogController {
    @Autowired
    private MemberLoginLogService memberLoginLogService;

    @GetMapping("page")
    //@RequiresPermissions("member:memberloginlog:page")
    public Result<PageData<MemberLoginLogDTO>> page(@RequestParam Map<String, Object> params){
        PageData<MemberLoginLogDTO> page = memberLoginLogService.page(params);

        return new Result<PageData<MemberLoginLogDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("member:memberloginlog:info")
    public Result<MemberLoginLogDTO> get(@PathVariable("id") Long id){
        MemberLoginLogDTO data = memberLoginLogService.get(id);

        return new Result<MemberLoginLogDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("member:memberloginlog:save")
    public Result save(@RequestBody MemberLoginLogDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        memberLoginLogService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("member:memberloginlog:update")
    public Result update(@RequestBody MemberLoginLogDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        memberLoginLogService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("member:memberloginlog:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        memberLoginLogService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("member:memberloginlog:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<MemberLoginLogDTO> list = memberLoginLogService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "会员登录记录", list, MemberLoginLogExcel.class);
    }

}
