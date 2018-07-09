package com.dagemen.client.sort;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

public class RBTree<T extends Comparable> {
    public static boolean BLACK = true;
    public static boolean RED = true;

    private RBNode<T> mRoot;    // 根结点


    void insert(RBNode<T> node) {

        RBNode x = mRoot;
        RBNode y = null;

        while (x != null) {
            y = x;
            if (x.key.compareTo(node.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            mRoot = node;
        } else {
            if (y.key.compareTo(node.key) < 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        }
        node.color = RED;
        // 3. 将它重新修正为一颗二叉查找树
        insertFixUp(node);
    }

    private void insertFixUp(RBNode<T> node) {
        RBNode<T> parent, gparent;
        while (((parent = parentOf(node)) != null) && isRed(parent)) {
            gparent = parentOf(parent);
            if (gparent.left == parent) {
                RBNode<T> uncle = gparent.right;
                if ((uncle != null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                // Case 2条件：叔叔是黑色，且当前节点是右孩子
                if (parent.right == node) {
                    RBNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                // Case 3条件：叔叔是黑色，且当前节点是左孩子。
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {
                // Case 1条件：叔叔节点是红色
                RBNode<T> uncle = gparent.left;
                if ((uncle != null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                // Case 2条件：叔叔是黑色，且当前节点是左孩子
                if (parent.left == node) {
                    RBNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                // Case 3条件：叔叔是黑色，且当前节点是右孩子。
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        // 将根节点设为黑色
        setBlack(this.mRoot);

    }

    /*
     * 对红黑树的节点(y)进行右旋转
     *
     * 右旋示意图(对节点y进行左旋)：
     *            py                               py
     *           /                                /
     *          y                                x
     *         /  \      --(右旋)-.            /  \
     *        x   ry                          lx   y
     *       / \                                  / \
     *      lx  rx                               rx  ry
     *
     */
    private void rightRotate(RBNode<T> y) {

        // 设置x是当前节点的左孩子。
        RBNode<T> x = y.left;

        // 将 “x的右孩子” 设为 “y的左孩子”；
        // 如果"x的右孩子"不为空的话，将 “y” 设为 “x的右孩子的父亲”
        y.left = x.right;
        if (x.right != null)
            x.right.parent = y;

        // 将 “y的父亲” 设为 “x的父亲”
        x.parent = y.parent;

        if (y.parent == null) {
            this.mRoot = x;            // 如果 “y的父亲” 是空节点，则将x设为根节点
        } else {
            if (y == y.parent.right)
                y.parent.right = x;    // 如果 y是它父节点的右孩子，则将x设为“y的父节点的右孩子”
            else
                y.parent.left = x;    // (y是它父节点的左孩子) 将x设为“x的父节点的左孩子”
        }

        // 将 “y” 设为 “x的右孩子”
        x.right = y;

        // 将 “y的父节点” 设为 “x”
        y.parent = x;
    }

    /*
     * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                             px
     *     /                              /
     *    x                              y
     *   /  \      --(左旋)-.           / \
     *  lx   y                         x  ry
     *      / \                       / \
     *    ly   ry                    lx  ly
     *
     *
     */
    private void leftRotate(RBNode<T> x) {
        // 设置x的右孩子为y
        RBNode<T> y = x.right;

        // 将 “y的左孩子” 设为 “x的右孩子”；
        // 如果y的左孩子非空，将 “x” 设为 “y的左孩子的父亲”
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;

        // 将 “x的父亲” 设为 “y的父亲”
        y.parent = x.parent;

        if (x.parent == null) {
            this.mRoot = y;            // 如果 “x的父亲” 是空节点，则将y设为根节点
        } else {
            if (x.parent.left == x)
                x.parent.left = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
            else
                x.parent.right = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
        }

        // 将 “x” 设为 “y的左孩子”
        y.left = x;
        // 将 “x的父节点” 设为 “y”
        x.parent = y;
    }

    private void setRed(RBNode<T> node) {
        node.color = RED;
    }

    private void setBlack(RBNode<T> node) {
        node.color = BLACK;
    }

    private boolean isRed(RBNode<T> parent) {
        return RED == parent.color;
    }

    private RBNode<T> parentOf(RBNode<T> node) {
        return node.parent;
    }


    public static class RBNode<T extends Comparable> {
        Boolean color;//要么是红色要么是黑色
        T key;
        private RBNode left;//左侧节点
        private RBNode right;//右侧节点
        private RBNode parent;    // 父结点

        public RBNode(T key, Boolean color, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void name() {
        RBTree tree = new RBTree();
        for (int i = 0; i < 10; i++) {
            RBNode rbNode = new RBNode(RandomUtils.nextInt(), null, null, null, null);
            tree.insert(rbNode);
        }
        System.out.println(tree);
    }
}
