package Tree.Medium;

import Tree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal o = new BinaryTreeLevelOrderTraversal();

        /*
                            1
                    2               3
              4           5   6             7
        */

        TreeNode tree = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(
                        3,
                        new TreeNode(6),
                        new TreeNode(7)
                )
        );

        System.out.println(
                Arrays.toString(
                        o.levelOrder(tree).toArray()
                )
        );
        // [[1], [2, 3], [4, 5, 6, 7]]
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            while (size-- > 0) {
                TreeNode currentNode = queue.poll();

                if (currentNode != null) {
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) queue.add(currentNode.left);
                    if (currentNode.right != null) queue.add(currentNode.right);
                }
            }
            list.add(currentLevel);
        }

        return list;
    }
}

// https://leetcode.com/problems/binary-tree-level-order-traversal/
