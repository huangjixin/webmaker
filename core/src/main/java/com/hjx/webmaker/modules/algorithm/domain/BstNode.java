package com.hjx.webmaker.modules.algorithm.domain;

/**
 * 二叉查找树节点。
 */
public class BstNode {
    private int data;
    private BstNode left_child;
    private BstNode right_child;
    private BstNode parent;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BstNode getLeft_child() {
        return left_child;
    }

    public void setLeft_child(BstNode left_child) {
        this.left_child = left_child;
    }

    public BstNode getRight_child() {
        return right_child;
    }

    public void setRight_child(BstNode right_child) {
        this.right_child = right_child;
    }

    public BstNode(int data, BstNode left_child, BstNode right_child) {
        this.data = data;
        this.left_child = left_child;
        this.right_child = right_child;
    }
}
