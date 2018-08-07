package com.dagemen.client.parten.bridge2;

public class BigBrushPenRefinedAbstraction extends BrushPenAbstraction {
    @Override
    public void operationDraw() {
        System.out.println("Big and " + imp.paint() + " drawing!");
    }
}
