//74. Search a 2D Matrix - M
//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//  Integers in each row are sorted from left to right.
//  The first integer of each row is greater than the last integer of the previous row.
public class Main {

    public static boolean searchMatrix(int[][] matrix, int target){
        int x = matrix.length;
        if (x == 0) return false;
        int y = matrix[0].length;
        if (y == 0) return false;
        int start = 0;
        int end = x-1;
        int med;
        while (start < end){
            med = (start + end)/2;
            if (matrix[med][y-1] == target) return true;
            if (matrix[med][y-1] < target) start = med+1;
            else end = med;
        }

        int f = start;
        if (matrix[f][y-1] == target) return true;
        start = 0;
        end = y-1;
        while (start < end){
            med = (start + end)/2;
            if (matrix[f][med] == target) return true;
            if (matrix[f][med] < target) start = med+1;
            else end = med;
        }
        return matrix[f][start] == target;

    }

    public static void main(String[] args){

        int[][] m = new int[3][3];
        m[0][0] = 0; m[0][1] = 2; m[0][2] = 3;
        m[1][0] = 4; m[1][1] = 5; m[1][2] = 6;
        m[2][0] = 7; m[2][1] = 8; m[2][2] = 9;
        System.out.println(searchMatrix(m, 0));
        System.out.println(searchMatrix(m, 1));
        System.out.println(searchMatrix(m, 5));
        System.out.println(searchMatrix(m, 9));
        System.out.println(searchMatrix(m, 10));
    }

}

