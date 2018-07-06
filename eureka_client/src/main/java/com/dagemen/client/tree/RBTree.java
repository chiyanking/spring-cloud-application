package com.dagemen.client.tree;


public class RBTree<T extends Comparable<T>> {


    boolean color; //颜色
    T key; //关键字(键值)
    RBTree left; //左子节点
    RBTree right; //右子节点
    RBTree parent; //父节点

    public RBTree(T key, boolean color, RBTree parent, RBTree left, RBTree right) {
        this.key = key;
        this.color = color;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public String toString() {
        return "" + key + (this.color == true ? "R" : "B");
    }

    RBTree add(RBTree node) {

        return null;
    }

    RBTree remove(RBTree node) {

        return null;
    }
}
