package Tree.Medium;

import Tree.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal o = new BinaryTreeZigzagLevelOrderTraversal();

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
                        o.zigzagLevelOrder(tree).toArray()
                )
        );
        // [[1], [3, 2], [4, 5, 6, 7]]
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        int levelCount = 0;

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
            if (levelCount++ % 2 != 0)
                Collections.reverse(currentLevel);

            list.add(currentLevel);
        }

        return list;
    }
}

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
