package Tree.Easy;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        /*
                            3
                    9               20
             12           42  15             7
        */

        BinaryTreePaths o = new BinaryTreePaths();
        TreeNode tree = new TreeNode(
                3,
                new TreeNode(
                        9,
                        new TreeNode(12),
                        new TreeNode(42)
                ),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        System.out.println(
                Arrays.toString(
                        o.binaryTreePaths(tree).toArray()
                )
        );

        // [3->9->12, 3->9->42, 3->20->15, 3->20->7]
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        pathHelper(root, new StringBuilder(), paths);
        return paths;
    }

    private void pathHelper(TreeNode node, StringBuilder path, List<String> result) {
        if (node == null) return;

        if (path.length() == 0)
            path.append(node.val);
        else
            path.append("->").append(node.val);

        if (node.left != null)
            pathHelper(node.left, new StringBuilder(path), result);

        if (node.right != null)
            pathHelper(node.right, new StringBuilder(path), result);

        if (node.left == null && node.right == null)
            result.add(path.toString());
    }
}

// https://leetcode.com/problems/binary-tree-paths/
