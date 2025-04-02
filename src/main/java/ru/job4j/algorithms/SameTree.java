package ru.job4j.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{p, q});
        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();
            TreeNode node1 = nodes[0];
            TreeNode node2 = nodes[1];
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue.offer(new TreeNode[]{node1.left, node2.left});
            queue.offer(new TreeNode[]{node1.right, node2.right});
        }
        return true;
    }

    public static void main(String[] args) {
        SameTree tree = new SameTree();
        TreeNode p = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        TreeNode q = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        System.out.println(tree.isSameTree(p, q));
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

