package io.abhijith.leetcode.dailychallenge.year_2022.september;

import io.abhijith.leetcode.dailychallenge.utils.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC: https://leetcode.com/problems/path-sum-ii/
 */
public class _24_PathSumII_LC_113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        helper(root, new ArrayList<>(), targetSum, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> current, int target, List<List<Integer>> result) {
        if(node == null) {
            return;
        }
        current.add(node.val);
        if(node.left == null && node.right == null) {
            if(target - node.val == 0) {
                result.add(new ArrayList<Integer>(current));
            }
        }
        helper(node.left, current, target - node.val, result);
        helper(node.right, current, target - node.val, result);
        current.remove(current.size() - 1);
    }

    @Test
    public void test() {
        Integer[] treeArr = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = TreeNode.arrayToTree(treeArr);
        List<List<Integer>> actual = pathSum(root, 22);
        List<Integer> item1 = Arrays.asList(5,4,11,2);
        List<Integer> item2 = Arrays.asList(5,8,4,5);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        Assert.assertEquals(expected, actual);
    }
}
