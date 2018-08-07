package com.dagemen.client.parten.iterator;

import java.util.List;

public class ConcreteContainer<T> implements Container<T> {

    private List<T> arraylist;

    public ConcreteContainer(List<T> arraylist) {
        this.arraylist = arraylist;
    }

    @Override
    public void add(T obj) {
        arraylist.add(obj);
    }

    @Override
    public void remove(T obj) {
        arraylist.remove(obj);
    }

    @Override
    public Iterator iterator() {
        return new DefaultIterator();
    }

    private class DefaultIterator implements Iterator {


        private int cursor;

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
}
