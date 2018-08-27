package com.dagemen.client.parten.visitor1;

public class ConcreteElenentA implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
