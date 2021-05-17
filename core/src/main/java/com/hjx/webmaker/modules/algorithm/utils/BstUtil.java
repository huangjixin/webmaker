package com.hjx.webmaker.modules.algorithm.utils;

import com.hjx.webmaker.modules.algorithm.domain.BstNode;

public class BstUtil {
    public static void main(String[] args) {
        BstNode node1 = new BstNode(1,null,null);
        BstNode node2 = new BstNode(2,null,null);
        BstNode node3 = new BstNode(3,node1,node2);
        BstNode node4 = new BstNode(4,null,null);
        BstNode node5 = new BstNode(5,null,null);
        BstNode node6 = new BstNode(6,node4,node5);
        BstNode node7 = new BstNode(7,node3,node6);

        preOrd(node7);
    }

    private static void postOrd(BstNode node){
        if(node == null) {
            return;
        }
        postOrd(node.getLeft_child());
        postOrd(node.getRight_child());
        System.out.println(node.getData());
    }

    private static void preOrd(BstNode node){
        if(node == null) {
            return;
        }
        System.out.println(node.getData());
        postOrd(node.getLeft_child());
        postOrd(node.getRight_child());
    }
}
