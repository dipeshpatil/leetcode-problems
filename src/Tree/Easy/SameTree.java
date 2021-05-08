package Tree.Easy;

import Tree.TreeNode;

import java.util.Arrays;

public class SameTree {
    public static void main(String[] args) {
        /*
                    1               1
                2       3       2       3
        */

        SameTree o = new SameTree();
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
                                o.isSameTree(p, q),
                                o.isSameTree(r, s)
                        }
                )
        );

        // [true, false]
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null)
            return p.val == q.val
                    && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
        return false;
    }
}

/*
    https://leetcode.com/problems/same-tree/
*/
