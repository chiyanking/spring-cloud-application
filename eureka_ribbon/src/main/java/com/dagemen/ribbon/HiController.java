package com.dagemen.ribbon;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableDiscoveryClient
public class HiController {


    @Resource
    HiService hiService;
    @RequestMapping(value = "/hi")
    public String hello(@RequestParam String name){
        return hiService.hiService(name);
    }

}
