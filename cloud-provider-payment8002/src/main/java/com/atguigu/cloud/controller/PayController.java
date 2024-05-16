package com.atguigu.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 张益策
 * @version 1.0
 */
@Tag(name = "支付微服务模块", description = "支付CRUD")
@RestController
@Slf4j
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    @Operation(summary = "新增", description = "新增支付流水方法，json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值" + i);
    }

    @DeleteMapping("/pay/del/{id}")
    @Operation(summary = "删除", description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        int i = payService.delete(id);
        return ResultData.success(i);


    }

    @PutMapping("/pay/update")
    @Operation(summary = "修改", description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO, pay);
        int update = payService.update(pay);
        return ResultData.success("成功插入记录，返回值" + update);
    }

    @GetMapping("/pay/get/{id}")
    @Operation(summary = "按照ID查询流水", description = "按照ID查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {

        if (id == -4) throw new RuntimeException("id不能为负数");

        Pay byId = payService.getById(id);
        return ResultData.success(byId);
    }

    @GetMapping("/pay/getall")
    public ResultData<List<Pay>> getAll() {

        List<Pay> all = payService.getAll();
        return ResultData.success(all);
    }
    @Value("${server.port}")
    private String port ;
    @GetMapping("/pay/getInfo")
    public String getInfoByConsul(@Value("${atguigu.info}") String atguiguInfo){
        return "atguiguInfo"+atguiguInfo+"\t"+"port"+port;
    }
}
