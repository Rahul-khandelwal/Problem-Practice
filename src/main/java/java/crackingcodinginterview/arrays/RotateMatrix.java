/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.crackingcodinginterview.arrays;

/**
 * Given an image represented by an N x N matrix, where each pixel in image is 4 bytes,
 * write a method to rotate the image by 90 degrees. 
 * Do the rotation in place.
 * 
 * @author Rahul
 */
public class RotateMatrix {
    
    private final int [][] matrix;
    private final int length;

    public RotateMatrix(int[][] matrix, int length) {
        this.matrix = matrix;
        this.length = length;
    }
    
    public void rotate_90() {
        for (int layer = 0 ; layer < this.length / 2 ; ++layer) {
            int firstLayer = layer;
            int lastLayer = this.length - 1 - layer;
            
            for (int i = firstLayer ; i < lastLayer ; ++i) {
                int offset = i - firstLayer;
                
                // save the top
                int top = this.matrix[firstLayer][i];
                
                // left -> top
                this.matrix[firstLayer][i] = this.matrix[lastLayer - offset][firstLayer];
                
                // bottom -> left
                this.matrix[lastLayer - offset][firstLayer] = this.matrix[lastLayer][lastLayer - offset];
                
                // right -> bottom
                this.matrix[lastLayer][lastLayer - offset] = this.matrix[i][lastLayer];
                
                // top -> right
                this.matrix[i][lastLayer] = top;
            }
        }
    }
    
    public void print() {
        for (int i = 0 ; i < this.length ; i++) {
            for (int j = 0 ; j < this.length ; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        int [][] m = new int [3][3];
        
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                m[i][j] = i + j + 1;
            }
        }
        
        RotateMatrix rm = new RotateMatrix(m, 3);
        rm.print();
        rm.rotate_90();
        rm.print();
    }
}
