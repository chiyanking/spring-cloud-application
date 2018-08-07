package com.dagemen.client.parten.iterator;

import java.util.List;

public class ConcreteIterator<T> implements Iterator<T> {


    private List<T> arraylist;

    private int cursor;


    public ConcreteIterator(List<T> arrayList) {
        this.arraylist = arrayList;
    }

    @Override
    public T first() {
        cursor = 0;
        return arraylist.get(cursor);
    }

    @Override
    public T next() {
        return arraylist.get(cursor++);
    }

    @Override
    public boolean hasNext() {
        return !(cursor == arraylist.size());
    }

    @Override
    public T currentItem() {
        return arraylist.get(cursor);
    }
}
