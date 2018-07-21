package com.dagemen.client.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringIntern {


    @Test
    public void testIntern() {
        /**
         * 首先设置 持久代最大和最小内存占用(限定为10M)
         * VM args: -XX:PermSize=10M -XX:MaxPremSize=10M
         */

        List<String> list  = new ArrayList<String>();

        // 无限循环 使用 list 对其引用保证 不被GC  intern 方法保证其加入到常量池中
        int i = 0;
        while (true) {
            String intern = String.valueOf(i++).intern();
            System.out.println(intern);
            // 此处永久执行，最多就是将整个 int 范围转化成字符串并放入常量池
            list.add(intern);
        }
    }
}
