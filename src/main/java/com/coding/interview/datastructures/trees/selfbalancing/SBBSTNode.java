package com.coding.interview.datastructures.trees.selfbalancing;

class SBBSTNode {
    SBBSTNode left, right;
    int data;
    int height;

    /* Constructor */
    public SBBSTNode() {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }

    /* Constructor */
    public SBBSTNode(int n) {
        left = null;
        right = null;
        data = n;
        height = 0;
    }
}
