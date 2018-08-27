package com.dagemen.client.parten.visitor1;

public class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElenentA element) {
        System.out.println(" concreteVisitor visit element A ");
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println(" concreteVisitor visit element B ");
    }

    @Override
    public void visit(ConcreteElementC element) {
        System.out.println(" concreteVisitor visit element C ");
    }
}
