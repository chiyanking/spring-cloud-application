package com.dagemen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class MiyaController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    RestTemplate restTemplate;
    @Resource
    HiService hiService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String callHome(String name) {
        logger.info("calling trace service-hi  ");
        return hiService.sayHiFromClientOne(name);
    }

    @RequestMapping("/hi")
    public String info(String name) {
        logger.info("calling trace service-hi ");
        return restTemplate.getForObject("http://SERVICE-HI/hello?name=" + name, String.class);
    }

}
