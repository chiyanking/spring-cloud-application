package com.dagemen.client.parten.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Client {
    @Test
    public void testIterator() {
        List<Object> list = new ArrayList<Object>();
        list.add("Android");
        list.add("PHP");
        list.add("C Language");
        Container container = new ConcreteContainer(list);
        container.add("HardWare");
        Iterator iterator = container.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
