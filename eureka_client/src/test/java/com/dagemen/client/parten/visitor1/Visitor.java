package com.dagemen.client.parten.visitor1;

public interface Visitor {
    void visit(ConcreteElenentA element);
    void visit(ConcreteElementB element);
    void visit(ConcreteElementC element);
}
