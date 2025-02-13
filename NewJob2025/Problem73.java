// 73. Set Matrix Zeroes - M
    public void fillWithZero(int[][] matrix, int x, int y) {
        if (x >= 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[x][j] = 0;
            }
        } else {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        boolean zeroIShouldBeZero = false;
        boolean zeroJShouldBeZero = false;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                zeroIShouldBeZero = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                zeroJShouldBeZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) { 
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                fillWithZero(matrix, -1, j); 
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                fillWithZero(matrix, i, -1); 
            }
        }

        if (zeroIShouldBeZero) {
            fillWithZero(matrix, 0, -1); 
        }

        if (zeroJShouldBeZero) {
            fillWithZero(matrix, -1, 0); 
        }
    }

//  cleaner to not use fillWithZero, instead
    for (int i = rows - 1; i >= 0; i--) {
        for (int j = cols - 1; j >= 1; j--)
            if (matrix[i][0] == 0 || matrix[0][j] == 0)
                matrix[i][j] = 0;
        if (col0 == 0) matrix[i][0] = 0;
    }
