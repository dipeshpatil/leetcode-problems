package Tree.Medium;

import Tree.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        new TreeNode(4)
                ),
                new TreeNode(
                        5,
                        null,
                        new TreeNode(6)
                )
        );

        FlattenBinaryTreeToLinkedList o = new FlattenBinaryTreeToLinkedList();
        o.flatten(tree);
        o.printLinkedList(tree);
        // 1 2 3 4 5
    }

    public void flatten(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                TreeNode p = current.left;
                while (p.right != null)
                    p = p.right;
                p.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    private void printLinkedList(TreeNode root) {
        while (root != null && root.right != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}

/*
    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
*/