package com.atguigu.cloud.apis;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 张益策
 * @version 1.0
 */
@FeignClient(value = "nacos-payment-provider",fallback =  PayFeignSentinelApiFallBack.class)
public interface PayFeignSentinelApi {
    @GetMapping("/pay/nacos/get/{orderNo}")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}
