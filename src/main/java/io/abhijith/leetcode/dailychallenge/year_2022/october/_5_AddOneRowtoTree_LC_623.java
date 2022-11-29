package io.abhijith.leetcode.dailychallenge.year_2022.october;

import io.abhijith.leetcode.dailychallenge.utils.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC: https://leetcode.com/problems/add-one-row-to-tree/
 */
public class _5_AddOneRowtoTree_LC_623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        depth--;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if(depth == 1) {
                    TreeNode newNode1 = new TreeNode(val);
                    newNode1.left = node.left;
                    TreeNode newNode2 = new TreeNode(val);
                    newNode2.right = node.right;
                    node.left = newNode1;
                    node.right = newNode2;
                }
                else {
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            if(depth == 1) break;
            depth--;
        }

        return root;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrayToTree(new Integer[]{4,2,6,3,1,5});
        int val = 1;
        int depth = 2;
        TreeNode output = TreeNode.arrayToTree(new Integer[]{4,1,1,2,null,null,6,3,1,5});
        Assert.assertEquals(output.toString(), addOneRow(root, val, depth).toString());
    }
}
