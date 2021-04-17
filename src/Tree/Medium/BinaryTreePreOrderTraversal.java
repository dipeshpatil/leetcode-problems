package Tree.Medium;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePreOrderTraversal {
    public static void main(String[] args) {
        /*
                            1
                    2               3
              4           5   6             7
        */

        BinaryTreePreOrderTraversal o = new BinaryTreePreOrderTraversal();
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
                        o.preorderTraversal(tree)
                                .toArray()
                )
        );
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderHelper(root, list);
        return list;
    }

    private void preOrderHelper(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        preOrderHelper(node.left, list);
        preOrderHelper(node.right, list);
    }

/*
    Given the root of a binary tree, return the preorder traversal of its nodes' values.
*/
}
