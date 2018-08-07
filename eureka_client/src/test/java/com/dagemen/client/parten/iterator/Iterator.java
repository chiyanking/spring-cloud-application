package com.dagemen.client.parten.iterator;

public interface Iterator<T> {
    T first();

    T next();

    boolean hasNext();

    T currentItem();
}
