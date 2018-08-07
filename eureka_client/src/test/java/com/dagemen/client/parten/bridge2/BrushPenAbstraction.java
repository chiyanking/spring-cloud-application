package com.dagemen.client.parten.bridge2;

public abstract class BrushPenAbstraction {
    /**
     * 保留对颜色的引用
     */
    protected ImplementorColor imp;

    /**
     * 每种笔都有自己的实现
     */
    public abstract void operationDraw();

    public void setImplementor(ImplementorColor imp) {
        this.imp = imp;
    }
}
