package Tree;

import java.util.Arrays;

public class SameTree {
    public static void main(String[] args) {
        /*
                    1               1
                2       3       2       3
        */

        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        TreeNode r = new TreeNode(1, new TreeNode(2), null);
        TreeNode s = new TreeNode(1, null, new TreeNode(2));

        /*
                    1               1
                2                       2
        */

        System.out.println(
                Arrays.toString(
                        new boolean[]{
                                isSameTree(p, q),
                                isSameTree(r, s)
                        }
                )
        );

        // [true, false]
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null) {
            return p.val == q.val
                    && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
        }
        return false;
    }

/*
    Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
*/
}