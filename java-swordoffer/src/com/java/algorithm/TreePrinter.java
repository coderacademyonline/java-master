package com.java.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreePrinter {
    public int[][] printTree(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node=null;
        TreeNode last = root;
        TreeNode nlast = last;
        if(root == null)
            return null;
        while(!queue.isEmpty()){
            node = queue.poll();
            temp.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);
                nlast = node.left;
            }
            if(node.right!=null){
                queue.offer(node.right);
                nlast = node.right;
            }
            if(node == last){
                res.add(temp);
                temp = new ArrayList<Integer>();
                last = nlast;
            }
        }
        int[][] result = new int[res.size()][];
        for(int i=0;i<res.size();i++){
            result[i] = new int[res.get(i).size()];
            for(int j=0;j<result[i].length;j++){
                result[i][j] = res.get(i).get(j);
            }
        }
        return result;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}