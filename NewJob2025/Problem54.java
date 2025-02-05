// 54. Spiral Matrix - M

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int noCycle = 4;

        int finishI = matrix.length;
        int finishJ = matrix[0].length;
        
        int visited = 101;
        int i = 0;
        int j = 0;

        while (noCycle != 0) {
            noCycle = 0;
            while ((j < finishJ) && (matrix[i][j] != visited)) {
                res.add(matrix[i][j]);
                matrix[i][j] = visited;
                j++;
                noCycle = 1;
            }
            j--; i++;

            while ((i < finishI) && (matrix[i][j] != visited)) {
                res.add(matrix[i][j]);
                matrix[i][j] = visited;
                i++;
                noCycle = 2;
            }
            i--; j--;

            while ((j >= 0) && (matrix[i][j] != visited)) {
                res.add(matrix[i][j]);
                matrix[i][j] = visited;
                j--;
                noCycle = 3;
            }
            j++; i--;
            
            while ((i >= 0) && (matrix[i][j] != visited)) {
                res.add(matrix[i][j]);
                matrix[i][j] = visited;
                noCycle = 4;
                i--;
            }
            i++; j++;
        }

        return res;
    }

// instead of marking, keep track of top bottom left right

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
