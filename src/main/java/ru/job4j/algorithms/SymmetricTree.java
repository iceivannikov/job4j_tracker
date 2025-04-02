package ru.job4j.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{root.left, root.right});
        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();
            TreeNode left = nodes[0];
            TreeNode right = nodes[1];
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(new TreeNode[]{left.left, right.right});
            queue.offer(new TreeNode[]{left.right, right.left});
        }
        return true;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
