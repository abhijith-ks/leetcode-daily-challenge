package io.abhijith.leetcode.dailychallenge.year_2022.october;

import io.abhijith.leetcode.dailychallenge.utils.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/path-sum/
 */
public class _4_PathSum_LC_112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrayToTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        int targetSum = 22;
        boolean result = true;
        Assert.assertEquals(result, hasPathSum(root, targetSum));

        root = TreeNode.arrayToTree(new Integer[]{1,2,3});
        targetSum = 5;
        result = false;
        Assert.assertEquals(result, hasPathSum(root, targetSum));

        root = TreeNode.arrayToTree(new Integer[]{});
        targetSum = 0;
        result = false;
        Assert.assertEquals(result, hasPathSum(root, targetSum));
    }
}
