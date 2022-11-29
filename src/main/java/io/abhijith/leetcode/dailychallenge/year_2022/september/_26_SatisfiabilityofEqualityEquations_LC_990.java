package io.abhijith.leetcode.dailychallenge.year_2022.september;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/satisfiability-of-equality-equations/
 */
public class _26_SatisfiabilityofEqualityEquations_LC_990 {


    static int parent[];
    static int rank[];

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        for(int i=0; i<26; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(String e:equations){
            if(e.charAt(1) == '='){
                union(e.charAt(0)-'a', e.charAt(3)-'a');
            }
        }

        for(String e:equations){
            if(e.charAt(1) == '!'){
                int lx =  find(e.charAt(0)-'a');
                int ly = find(e.charAt(3)-'a');
                if(lx == ly){
                    return false;
                }
            }
        }
        return true;

    }
    public static void union(int x, int y){
        int lx = find(x);
        int ly = find(y);

        if(lx!= ly){
            if(rank[lx]>rank[ly]){
                parent[ly] = lx;
            }else if(rank[ly]>rank[lx]){
                parent[lx] = ly;
            }else {
                parent[ly] = lx;
                rank[lx]++;
            }
        }
    }
    public static int find(int x){
        if(parent[x] == x){
            return x;

        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }

    @Test
    public void test() {
        String[] input1 = {"a==b","b!=a"};
        boolean expected1 = false;
        Assert.assertEquals(expected1, equationsPossible(input1));

        String[] input2 = {"b==a","a==b"};
        boolean expected2 = true;
        Assert.assertEquals(expected2, equationsPossible(input2));
    }

}
