package ru.job4j.algorithms;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberOfIslandsDFSTest {
    @Test
    void when1IslandIsland() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        NumberOfIslandsDFS numberOfIslands = new NumberOfIslandsDFS();
        int numIslands = numberOfIslands.numIslands(grid);
        assertThat(numIslands).isEqualTo(1);
    }

    @Test
    void when3IslandIsland() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumberOfIslandsDFS numberOfIslands = new NumberOfIslandsDFS();
        int numIslands = numberOfIslands.numIslands(grid);
        assertThat(numIslands).isEqualTo(3);
    }
}