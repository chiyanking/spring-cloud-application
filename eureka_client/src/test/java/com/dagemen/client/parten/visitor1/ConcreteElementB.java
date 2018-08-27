package com.dagemen.client.parten.visitor1;

public class ConcreteElementB implements  Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
