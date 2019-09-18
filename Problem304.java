//304. Range Sum Query 2D - Immutable - M
//Given a 2D matrix matrix, find the sum of the elements inside the rectangle
// defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Main {

    static class NumMatrix {
        int[][] sumMatrix;

        public NumMatrix(int[][] matrix) {
            int x = matrix.length;
            if (x==0) return;
            int y = matrix[0].length;
            sumMatrix = new int[x][y];
            if (y == 0) return;
            else {
                sumMatrix[0][0] = matrix[0][0];
                for (int j = 1; j< y; j++){
                    sumMatrix[0][j] = sumMatrix[0][j-1] + matrix[0][j];
                }
                for (int j = 1; j< x; j++){
                    sumMatrix[j][0] = sumMatrix[j-1][0] + matrix[j][0];
                }
                for (int i = 1; i < x; i++){
                    for (int j = 1; j < y; j++){
                        sumMatrix[i][j] = sumMatrix[i][j-1] + sumMatrix[i-1][j] - sumMatrix[i-1][j-1] + matrix[i][j];
                    }
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int upper = (row1 == 0) ? 0 : sumMatrix[row1-1][col2];
            int left = (col1 == 0) ? 0 : sumMatrix[row2][col1-1];
            int corner = 0;
            if (col1 == 0 || row1 == 0) corner = 0;
            else corner =sumMatrix[row1-1][col1-1];
            return sumMatrix[row2][col2] - upper - left + corner;

        }
    }


    public static void main(String[] args){
        int[][] m = new int[5][5];
        int[][] m1 = new int[0][0];
        m[0][0] = 3; m[0][1] = 0; m[0][2] = 1; m[0][3] = 4; m[0][4] = 2;
        m[1][0] = 5; m[1][1] = 6; m[1][2] = 3; m[1][3] = 2; m[1][4] = 1;
        m[2][0] = 1; m[2][1] = 2; m[2][2] = 0; m[2][3] = 1; m[2][4] = 5;
        m[3][0] = 4; m[3][1] = 1; m[3][2] = 0; m[3][3] = 1; m[3][4] = 7;
        m[4][0] = 1; m[4][1] = 0; m[4][2] = 3; m[4][3] = 0; m[4][4] = 5;

         NumMatrix obj = new NumMatrix(m);
        int param_1 = obj.sumRegion(2,1,4,3);
        System.out.println(param_1);    //8
        int param_2 = obj.sumRegion(0,1,0,1);
        System.out.println(param_2);    //3

        //NumMatrix o = new NumMatrix(m1);

        System.out.println("Hi");

    }

}

