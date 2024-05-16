package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 张益策
 * @version 1.0
 */
@RestController

public class OderController {
//    public static final String Payment_URL="http://localhost:8001";
    public static final String Payment_URL="http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(Payment_URL + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getOrder(@PathVariable("id") Integer id){
        return restTemplate.getForObject(Payment_URL + "/pay/get/{id}", ResultData.class,id);
    }

    @GetMapping(value = "/consumer/pay/getInfo")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(Payment_URL + "/pay/getInfo", String.class);
    }


}
