package com.dagemen.client.collection;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class TreeSetTest {

    @Test
    public void testTreeset() {
        TreeMap<String, String> tree = new TreeMap();
        tree.put("aaa", "aaa");
        tree.put("bbb", "bbb");
        tree.put("aaa", "ccc");
        for (Map.Entry<String, String> entry : tree.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
