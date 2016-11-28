/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rahul.problem.practice.trees;

/**
 * Question : Given 2 arrays of integers,find whether they will form the same binary search tree.
 * Example :- 2,1,3 and 2,3,1 will form the same binary search tree.
 * 
 * @author Rahul
 */
public class SameBinarySearchTreeFromArrays {
    
    private final int length;
    private final int [] arr_first;
    private final int [] arr_second;

    public SameBinarySearchTreeFromArrays(int[] _arr_first, int[] _arr_second) {
        this.arr_first = _arr_first;
        this.arr_second = _arr_second;
        this.length = this.arr_first.length;
    }
    
    public boolean formSameBst(int _arr_first_index, int _arr_second_index, int min_for_parent, int max_for_parent) {
        int parent_1;
        int parent_2;
        
        // get the parent element in both arrays
        for (parent_1 = _arr_first_index ; parent_1 < this.length ; parent_1++) {
            if (this.arr_first[parent_1] > min_for_parent && this.arr_first[parent_1] < max_for_parent) {
                // This is the next parent
                break;
            }
        }
        
        for (parent_2 = _arr_second_index ; parent_2 < this.length ; parent_2++) {
            if (this.arr_second[parent_2] > min_for_parent && this.arr_second[parent_2] < max_for_parent) {
                // This is the next parent
                break;
            }
        }
        
        // If both parents are leaf nodes, then return true
        if (parent_1 == this.length && parent_2 == this.length) {
            return true;
        }
        
        /* 
            Return false if any of the following is true
            a) If the parent element is leaf in one array, but non-leaf in other.
            b) The elements satisfying constraints are not same. We either search
             for left child or right child of the parent element (decinded by min
             and max values). The child found must be same in both arrays 
        */
        
        if (((parent_1 == this.length) ^ (parent_2 == this.length)) || this.arr_first[parent_1] != this.arr_second[parent_2]) {
            return false;
        }
        
        /* 
        Make the current child as parent and recursively check for left and right
        subtrees of it. 
        */
        
        return this.formSameBst(parent_1 + 1, parent_2 + 1, this.arr_first[parent_1], max_for_parent) && 
                this.formSameBst(parent_1 + 1, parent_2 + 1, min_for_parent, this.arr_second[parent_2]);
    }
    
    public static void main(String[] args) {
        int arr_1[] = {8, 3, 6, 1, 4, 7, 10, 14, 13};
        int arr_2[] = {8, 10, 14, 3, 6, 4, 1, 7, 13};
        
        System.out.println(new SameBinarySearchTreeFromArrays(arr_1, arr_2).
                formSameBst(0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE)); // start with first value and for first values parent boundaries are min and max of int.
    }
}
