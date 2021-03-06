package Tree.Easy;

import Tree.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        /*
                            3
                    9               20
              N           N  15             7

              [N, 9, N, 3, 15, 20, 7]
        */

        InvertBinaryTree o = new InvertBinaryTree();
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

        o.print(o.invertTree(tree));

        /*
              After Inversion

                            3
                   20               9
              7           15  N             N

              [7, 20, 15, 3, N, 9, N]
        */
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    private void print(TreeNode node) {
        if (node != null) {
            print(node.left);
            System.out.print(node.val + " ");
            print(node.right);
        }
    }
}

// https://leetcode.com/problems/invert-binary-tree/
