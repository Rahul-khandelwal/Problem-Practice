/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.crackingcodinginterview.arrays;

/**
 * Write an algorithm such that if an element in MxN matrix is zero,
 * it's entire row and column are set to zero.
 * 
 * @author Rahul
 */
public class MatrixNullifying {
    
    private final int [][] matrix;

    public MatrixNullifying(int[][] matrix) {
        this.matrix = matrix;
    }
    
    /**
     * We'll use first row and first column to store if apart from them any column or row has zero value.
     * If first row and first column already has zero then we'll save it in boolean variables.
     * We'll iterate through rest of the matrix setting matrix [i][0] and matrix [0][j] to zero if 
     * there is a zero in matrix[i][j].
     * Iterate through rest of the matrix , nullifying row i if there is a zero in matrix[i][0].
     * Iterate through rest of the matrix , nullifying column j if there is a zero in matrix[0][j].
     * Nullify first row and first column if necessary.
     */
    public void nullify() {
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        
        // check if first row has zero
        for (int col = 0 ; col < this.matrix[0].length ; col++) {
            if (this.matrix[0][col] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        
        // check if first column has zero
        for (int row = 0 ; row < this.matrix.length ; row++) {
            if (this.matrix[row][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }
        
        // check for the rest of the matrix
        for (int row = 1 ; row < this.matrix.length ; row++) {
            for (int col = 1 ; col < this.matrix[0].length ; col++) {
                if (this.matrix[row][col] == 0) {
                    this.matrix[row][0] = 0;
                    this.matrix[0][col] = 0;
                }
            }
        }
        
        // nullify rows based on the values of first column
        for (int row = 1 ; row < this.matrix.length ; row++) {
            if (this.matrix[row][0] == 0) {
                this.nullifyRow(row);
            }
        }
        
        // nullify columns based on the values of the first row
        for (int col = 1 ; col < this.matrix[0].length ; col++) {
            if (this.matrix[0][col] == 0) {
                this.nullifyColumn(col);
            }
        }
        
        //nullify first row if required
        if (firstRowHasZero) {
            this.nullifyRow(0);
        }
        
        // nullify first column if required
        if (firstColHasZero) {
            this.nullifyColumn(0);
        }
    }
    
    private void nullifyColumn(int _col) {
        for (int row = 0 ; row < this.matrix.length ; row++) {
            this.matrix[row][_col] = 0;
        }
    }
    
    private void nullifyRow(int _row) {
        for (int col = 0 ; col < this.matrix[0].length ; col++) {
            this.matrix[_row][col] = 0;
        }
    }
    
    public void print() {
        for (int i = 0 ; i < this.matrix.length ; i++) {
            for (int j = 0 ; j < this.matrix[0].length ; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        int [][] m = new int [3][3];
        
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                m[i][j] = i + j;
            }
        }
        
        MatrixNullifying rm = new MatrixNullifying(m);
        rm.print();
        rm.nullify();
        rm.print();
    }
}
