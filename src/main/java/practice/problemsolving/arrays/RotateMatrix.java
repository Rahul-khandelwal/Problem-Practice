/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.arrays;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/rotate-matrix/
 * 
 * @author Rahul
 */
public class RotateMatrix {
    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        int length = a.get(0).size();
        
        // Rotate matrix layer by layer and 
        // do index by index swapping for in place solution
        for (int layer = 0 ; layer < length / 2 ; ++layer) {
            int startIdx = layer;
            int endIdx = length - layer - 1;
            
            for (int i = startIdx ; i < endIdx ; ++i) {
                int offset = i - startIdx;
                
                //save the top
                // Get the current element of top row
                int top = a.get(startIdx).get(i);
                
                // left -> top
                // Update the current element of top row with
                // first element of (bottom-offset) row
                a.get(startIdx).set(i, a.get(endIdx - offset).get(startIdx));
                
                // bottom -> left
                // Update the first element of (bottom-offset) row with
                // offset adjusted element of bottom most row
                a.get(endIdx - offset).set(startIdx, a.get(endIdx).get(endIdx - offset));
                
                // right -> bottom
                // Update the offset adjusted element of bottom most row with
                // last element of current row
                a.get(endIdx).set(endIdx - offset, a.get(i).get(endIdx));
                
                // top -> right
                // Update the last element of current row with
                // previous top element
                a.get(i).set(endIdx, top);
                
                // NOTE that one of trick here is to always play with boundary 
                // elements of the layer
                // when we are on start or end layer, to get the element we can adjust 
                // offset with start or end layer
                // BUT when we are in i'th layer, we get element by simply using start
                // or end layer
            }
        }
    }
}