package com.atguigu.gulimall.order.controller;

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
import com.atguigu.gulimall.order.dto.MqMessageDTO;
import com.atguigu.gulimall.order.excel.MqMessageExcel;
import com.atguigu.gulimall.order.service.MqMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@RestController
@RequestMapping("order/mqmessage")
public class MqMessageController {
    @Autowired
    private MqMessageService mqMessageService;

    @GetMapping("page")
    //@RequiresPermissions("order:mqmessage:page")
    public Result<PageData<MqMessageDTO>> page(@RequestParam Map<String, Object> params){
        PageData<MqMessageDTO> page = mqMessageService.page(params);

        return new Result<PageData<MqMessageDTO>>().ok(page);
    }

    @GetMapping("{id}")
    //@RequiresPermissions("order:mqmessage:info")
    public Result<MqMessageDTO> get(@PathVariable("id") Long id){
        MqMessageDTO data = mqMessageService.get(id);

        return new Result<MqMessageDTO>().ok(data);
    }

    @PostMapping
    @LogOperation("保存")
    //@RequiresPermissions("order:mqmessage:save")
    public Result save(@RequestBody MqMessageDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        mqMessageService.save(dto);

        return new Result();
    }

    @PutMapping
    @LogOperation("修改")
    //@RequiresPermissions("order:mqmessage:update")
    public Result update(@RequestBody MqMessageDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        mqMessageService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @LogOperation("删除")
    //@RequiresPermissions("order:mqmessage:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        mqMessageService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @LogOperation("导出")
    //@RequiresPermissions("order:mqmessage:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<MqMessageDTO> list = mqMessageService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "", list, MqMessageExcel.class);
    }

}
