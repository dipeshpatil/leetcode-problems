package Tree.Hard;

import Tree.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BinaryTreeCameras {
    int cameras = 0;
    Set<TreeNode> coveredNodes;

    public static void main(String[] args) {
        BinaryTreeCameras o = new BinaryTreeCameras();

        TreeNode tree1 = new TreeNode(
                0,
                new TreeNode(
                        0,
                        new TreeNode(0),
                        new TreeNode(0)
                ),
                null
        );

        TreeNode tree2 = new TreeNode(
                0,
                new TreeNode(
                        0,
                        new TreeNode(
                                0,
                                new TreeNode(
                                        0,
                                        null,
                                        new TreeNode(0)
                                ),
                                null
                        ),
                        null
                ),
                null
        );

        System.out.println(
                Arrays.toString(
                        new int[]{
                                o.minCameraCover(tree1),
                                o.minCameraCover(tree2)
                        }
                )
        );
        // [1, 2]
    }

    public int minCameraCover(TreeNode root) {
        cameras = 0;
        if (root == null)
            return cameras;

        coveredNodes = new HashSet<>();
        coveredNodes.add(null);
        dfs(root, null);

        return cameras;
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            dfs(node.left, node);
            dfs(node.right, node);

            if (
                    parent == null
                            && !coveredNodes.contains(node)
                            || !coveredNodes.contains(node.left)
                            || !coveredNodes.contains(node.right)
            ) {
                cameras++;
                coveredNodes.add(node);
                coveredNodes.add(parent);
                coveredNodes.add(node.left);
                coveredNodes.add(node.right);
            }
        }
    }
}

//  https://leetcode.com/problems/binary-tree-cameras/
