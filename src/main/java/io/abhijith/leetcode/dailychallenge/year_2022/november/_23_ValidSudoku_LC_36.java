package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * LC: https://leetcode.com/problems/valid-sudoku/
 */
public class _23_ValidSudoku_LC_36 {

    public boolean isValidSudoku(char[][] board) {
        return boxSolver(board) && rowSolver(board) && colSolver(board);
    }

    private boolean boxSolver(char[][] board) {
        Set<Character>[] set = new HashSet[9];
        for(int i = 0; i < 9; i++) {
            set[i] = new HashSet<>();
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                int idx = (i / 3) * 3 + j / 3;
                if(set[idx].contains(board[i][j]) && board[i][j] != '.') {
                    return false;
                }
                set[idx].add(board[i][j]);
            }
        }
        System.out.println("box");
        return true;
    }

    private boolean rowSolver(char[][] board) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(set.contains(board[i][j]) && board[i][j] != '.') return false;
                set.add(board[i][j]);
            }
            set = new HashSet<>();
        }
        System.out.println("row");
        return true;
    }

    private boolean colSolver(char[][] board) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(set.contains(board[j][i]) && board[j][i] != '.') return false;
                set.add(board[j][i]);
            }
            set = new HashSet<>();
        }
        System.out.println("col");
        return true;
    }

    @Test
    public void test() {
        char[][] input = new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        boolean output = true;
        Assert.assertEquals(output, isValidSudoku(input));

        input = new char[][]{{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        output = false;
        Assert.assertEquals(output, isValidSudoku(input));
    }
}
