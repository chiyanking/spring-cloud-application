package com.dagemen.ribbon.upload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/upload")
    public String upload(MultipartFile uploadFile) throws InterruptedException, IOException {
        if (uploadFile == null) {
            System.out.println("文件为空");
        }
        System.out.println(String.format("%s 大小 %s", uploadFile.getOriginalFilename(), uploadFile.getBytes().length));
        logger.debug("文件名,{} 大小 {}", uploadFile.getOriginalFilename(), uploadFile.getBytes().length);
        return "success";
    }

}
