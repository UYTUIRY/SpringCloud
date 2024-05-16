package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignSentinelApi;
import com.atguigu.cloud.config.RestTemplateConfig;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 张益策
 * @version 1.0
 */
@RestController
public class OrderNacosController {

    @Resource
    RestTemplate restTemplate;
//    static final String Server_URL = "localhost:nacos-payment-provider";
    @Value("${service-url.nacos-user-service}")
    String Server_URL;
    public static final String Payment_URL="http://nacos-payment-provider";

    @GetMapping("/consumer/pay/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        String reslut = restTemplate.getForObject(Server_URL+"/pay/nacos/"+id, String.class);
        return reslut+"我是order的调用者";
    }

    @Resource
    private PayFeignSentinelApi payFeignSentinelApi;

    @GetMapping(value = "/consumer/pay/nacos/get/{orderNo}")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo)
    {
        return payFeignSentinelApi.getPayByOrderNo(orderNo);
    }
}
