package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/word-search/
 */
public class _24_WordSearch_LC_79 {

    char[][] board;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        boolean found = false;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    found = helper(i, j, 0, word);
                    if(found) {
                        break;
                    }
                }
            }
            if(found) {
                break;
            }
        }

        return found;
    }

    private boolean helper(int i, int j, int index, String word) {
        if(index == word.length()) {
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || this.board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = this.board[i][j];
        this.board[i][j] = ' ';
        boolean left = helper(i, j - 1, index + 1, word);
        boolean right = helper(i, j + 1, index + 1, word);
        boolean top = helper(i - 1, j, index + 1, word);
        boolean down = helper(i + 1, j, index + 1, word);
        this.board[i][j] = temp;

        return left || right || top || down;
    }

    @Test
    public void test() {
        char[][] input = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean output = true;
        Assert.assertEquals(output, exist(input, word));

        input = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        word = "SEE";
        output = true;
        Assert.assertEquals(output, exist(input, word));

        input = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        word = "ABCB";
        output = false;
        Assert.assertEquals(output, exist(input, word));
    }
}
