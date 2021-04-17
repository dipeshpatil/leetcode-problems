package Tree.Medium;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePostOrderTraversal {
    public static void main(String[] args) {
        /*
                            1
                    2               3
              4           5   6             7
        */

        BinaryTreePostOrderTraversal o = new BinaryTreePostOrderTraversal();
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
                        o.postorderTraversal(tree)
                                .toArray()
                )
        );
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderHelper(root, list);
        return list;
    }

    private void postOrderHelper(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        postOrderHelper(node.left, list);
        postOrderHelper(node.right, list);
        list.add(node.val);
    }

/*
    Given the root of a binary tree, return the postorder traversal of its nodes' values.
*/
}
