package com.dagemen.client.parten.iterator;

public interface Container<T> {
    void add(T obj);

    void remove(T obj);

    Iterator iterator();
}
