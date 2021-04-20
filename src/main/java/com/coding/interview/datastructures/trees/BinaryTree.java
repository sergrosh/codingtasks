package com.coding.interview.datastructures.trees;

class BinaryTree {

    TreeNode root;

    /**
     * Java method to create binary tree with test data * * @return a sample binary tree for testing
     */
    public static BinaryTree create() {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode("40");
        tree.root = root;
        tree.root.left = new TreeNode("20");
        tree.root.left.left = new TreeNode("10");
        tree.root.left.left.left = new TreeNode("5");
        tree.root.left.right = new TreeNode("30");
        tree.root.right = new TreeNode("50");
        tree.root.right.right = new TreeNode("60");
        tree.root.left.right.left = new TreeNode("67");
        tree.root.left.right.right = new TreeNode("78");
        return tree;
    }

    public static void main(String[] args) throws Exception {
        BinaryTree bt = BinaryTree.create();
        System.out.println("printing nodes of binary tree on InOrder using recursion");
        bt.inOrder();
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.printf("%s ", node.data);
        inOrder(node.right);
    }

    static class TreeNode {
        String data;
        TreeNode left, right;

        TreeNode(String value) {
            this.data = value;
            left = right = null;
        }
    }
}

