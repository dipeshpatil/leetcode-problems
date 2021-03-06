package Tree.Easy;

import Tree.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {
        /*
                            1
                    2               2
              3           4   4             3
        */

        SymmetricTree o = new SymmetricTree();
        TreeNode tree = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        new TreeNode(4)
                ),
                new TreeNode(
                        2,
                        new TreeNode(4),
                        new TreeNode(3)
                )
        );

        System.out.println(o.isSymmetric(tree));
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root, root);
    }

    private boolean isSymmetricHelper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val
                && isSymmetricHelper(t1.left, t2.right)
                && isSymmetricHelper(t1.right, t2.left);
    }
}

// https://leetcode.com/problems/symmetric-tree/
