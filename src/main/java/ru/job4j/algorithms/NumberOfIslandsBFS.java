package ru.job4j.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if (x >= 0
                        && x < grid.length
                        && y >= 0
                        && y < grid[0].length
                        && grid[x][y] == '1') {
                    grid[x][y] = '0';
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}
