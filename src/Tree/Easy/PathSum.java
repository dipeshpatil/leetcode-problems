package Tree.Easy;

import Tree.TreeNode;

import java.util.HashSet;

public class PathSum {
    public static void main(String[] args) {
        /*
                                      5
                             4                   8
                      11          N        13         4
                 7           2        N          N          1
        */

        PathSum o = new PathSum();
        TreeNode tree = new TreeNode(
                5,
                new TreeNode(
                        4,
                        new TreeNode(
                                11,
                                new TreeNode(7),
                                new TreeNode(2)
                        ),
                        null
                ),
                new TreeNode(
                        8,
                        new TreeNode(13),
                        new TreeNode(
                                4,
                                null,
                                new TreeNode(1)
                        )
                )
        );

        System.out.println(o.hasPathSum(tree, 22));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        HashSet<Integer> set = new HashSet<>();
        buildPathSums(set, 0, root);
        return set.contains(targetSum);
    }

    private void buildPathSums(HashSet<Integer> set, int currentSum, TreeNode node) {
        if (node == null) return;

        currentSum += node.val;

        if (node.left != null)
            buildPathSums(set, currentSum, node.left);

        if (node.right != null)
            buildPathSums(set, currentSum, node.right);

        if (node.left == null && node.right == null)
            set.add(currentSum);
    }
}

/*
    https://leetcode.com/problems/path-sum/
*/
