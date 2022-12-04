package io.abhijith.leetcode.dailychallenge.year_2022.november;

import io.abhijith.leetcode.dailychallenge.utils.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class _15_CountCompleteTreeNodes_LC_222 {

    public int countNodes(TreeNode root) {

        if(root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    @Test
    public void test() {
        Integer[] input = new Integer[]{1,2,3,4,5,6};
        int output = 6;
        Assert.assertEquals(output, countNodes(TreeNode.arrayToTree(input)));

        input = new Integer[]{};
        output = 0;
        Assert.assertEquals(output, countNodes(TreeNode.arrayToTree(input)));

        input = new Integer[]{1};
        output = 1;
        Assert.assertEquals(output, countNodes(TreeNode.arrayToTree(input)));
    }
}
