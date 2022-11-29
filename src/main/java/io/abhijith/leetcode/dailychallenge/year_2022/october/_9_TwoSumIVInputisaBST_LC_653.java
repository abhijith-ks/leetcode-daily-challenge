package io.abhijith.leetcode.dailychallenge.year_2022.october;

import io.abhijith.leetcode.dailychallenge.utils.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * LC: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class _9_TwoSumIVInputisaBST_LC_653 {

    Set<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return helper(root, k);
    }

    private boolean helper(TreeNode node, int k) {
        if(node == null) {
            return false;
        }
        if(set.contains(k - node.val)) {
            return true;
        }

        set.add(node.val);
        return helper(node.left, k) || helper(node.right, k);
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrayToTree(new Integer[]{5,3,6,2,4,null,7});
        int k = 9;
        boolean output = true;
        Assert.assertEquals(output, findTarget(root, k));

        root = TreeNode.arrayToTree(new Integer[]{5,3,6,2,4,null,7});
        k = 28;
        output = false;
        Assert.assertEquals(output, findTarget(root, k));
    }
}
