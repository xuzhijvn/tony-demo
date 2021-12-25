/*
 *       Copyright© (2020).
 */
package com.tony;

/**
 * @author tony
 * @create 2021-10-08
 * @description:
 */
public class Test {


    public static void main(String[] args) {

    }

private TreeNode buildTree(Integer[] array, int index) {
    TreeNode treeNode;
    if (index < array.length) {
        Integer value = array[index];
        if (value == null) {
            return null;
        }
        treeNode = new TreeNode(value);
        treeNode.left = buildTree(array, 2 * index + 1);
        treeNode.right = buildTree(array, 2 * index + 2);
        return treeNode;
    }
    return null;
}

}
