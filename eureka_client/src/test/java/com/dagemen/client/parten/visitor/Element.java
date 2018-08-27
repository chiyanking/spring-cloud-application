package com.dagemen.client.parten.visitor;

public interface Element {
    //接受一个抽象访问者访问
    void accept(Visitor visitor);
}
