package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LC: https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 */
public class _30_ShortestPathinaGridwithObstaclesElimination_LC_1293 {

    class Node{
        int r;
        int c;
        int k;
        int step;
        public Node(int r, int c, int k, int step){
            this.r = r;
            this.c = c;
            this.k = k;
            this.step = step;
        }
    }
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0)
            return -1;
        int rows = grid.length, cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        for (int[] v : visited){
            Arrays.fill(v, Integer.MAX_VALUE);
        }
        int x = grid[0][0] == 0 ? 0 : 1;
        visited[0][0] = x;
        Node start = new Node(0, 0, x, 0);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.r == rows - 1 && node.c == cols - 1)
                return node.step;
            for (int[] dir : dirs){
                int nr = dir[0] + node.r;
                int nc = dir[1] + node.c;
                if (0 <= nr && nr < rows && 0 <= nc && nc < cols){
                    int ks = grid[nr][nc] + node.k;
                    if (ks >= visited[nr][nc] || ks > k){
                        continue;
                    }
                    Node newNode = new Node(nr, nc, ks, node.step + 1);
                    queue.offer(newNode);
                    visited[nr][nc] = ks;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[][] grid = new int[][]{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        int k = 1;
        int output = 6;
        Assert.assertEquals(output, shortestPath(grid, k));

        grid = new int[][]{{0,1,1},{1,1,1},{1,0,0}};
        k = 1;
        output = -1;
        Assert.assertEquals(output, shortestPath(grid, k));
    }
}
