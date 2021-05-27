package Tree.Medium;

import Tree.TreeNode;

public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        InsertIntoABinarySearchTree o = new InsertIntoABinarySearchTree();

        TreeNode tree = new TreeNode(
                3,
                new TreeNode(
                        9,
                        new TreeNode(12),
                        new TreeNode(42)
                ),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        tree = o.insertIntoBST(tree, 99);
        o.print(tree);

        // 12 9 42 3 15 20 7 99
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        return insertIntoBSTHelper(root, val);
    }

    private TreeNode insertIntoBSTHelper(TreeNode node, int data) {
        if (node == null)
            return new TreeNode(data);
        if (data < node.val)
            node.left = insertIntoBSTHelper(node.left, data);
        else if (data > node.val)
            node.right = insertIntoBSTHelper(node.right, data);
        return node;
    }

    private void print(TreeNode node) {
        if (node != null) {
            print(node.left);
            System.out.print(node.val + " ");
            print(node.right);
        }
    }
}

// https://leetcode.com/problems/insert-into-a-binary-search-tree/
