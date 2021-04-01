package Tree.Medium;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeInOrderTraversal {
    public static void main(String[] args) {
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
        System.out.println(
                Arrays.toString(
                        inorderTraversal(tree)
                                .toArray()
                )
        );
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderHelper(root, list);
        return list;
    }

    private static void inOrderHelper(TreeNode node, List<Integer> list) {
        if (node == null) return;

        inOrderHelper(node.left, list);
        list.add(node.val);
        inOrderHelper(node.right, list);
    }
}