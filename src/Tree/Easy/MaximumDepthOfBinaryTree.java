package Tree.Easy;

import Tree.TreeNode;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        /*
                            3
                    9               20
              N           N  15             7
        */

        MaximumDepthOfBinaryTree o = new MaximumDepthOfBinaryTree();
        TreeNode tree = new TreeNode(
                3,
                new TreeNode(
                        9,
                        null,
                        null
                ),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        System.out.println(o.maxDepth(tree));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + height(root);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 0;
        else return 1 + Math.max(height(root.left), height(root.right));
    }
}

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
