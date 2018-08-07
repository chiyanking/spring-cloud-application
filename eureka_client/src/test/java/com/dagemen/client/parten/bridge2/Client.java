package com.dagemen.client.parten.bridge2;

import org.junit.Test;

public class Client {
    @Test
    public void testBridge() {
        BrushPenAbstraction brushPen = new BigBrushPenRefinedAbstraction();
        ImplementorColor col = new OncreteImplementorRed();
        brushPen.setImplementor(col);
        brushPen.operationDraw();
    }
}
