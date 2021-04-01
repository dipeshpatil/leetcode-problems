package Tree.Easy;

import Tree.TreeNode;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        /*
                            3
                    9               20
              N           N  15             7
        */

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

        System.out.println(sumOfLeftLeaves(tree));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        if (root.left != null && isLeftLeaf(root.left))
            sum += root.left.val;
        sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        return sum;
    }

    public static boolean isLeftLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

/*
    Find the sum of all left leaves in a given binary tree.
*/
}
