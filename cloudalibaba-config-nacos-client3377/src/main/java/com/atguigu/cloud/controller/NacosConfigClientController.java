package com.atguigu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张益策
 * @version 1.0
 */
@RefreshScope
@RestController
public class NacosConfigClientController {
    @Value("${config.info}")
    String ConfigInfo;
    @GetMapping("config/info")
    public String GetClientInfo(){
        return ConfigInfo;
    }



}
