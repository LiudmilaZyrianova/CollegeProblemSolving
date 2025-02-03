// 74. Search a 2D Matrix - M
    public boolean searchMatrix(int[][] matrix, int target) {
        // remove small
        if (target < matrix[0][0]) return false;

        // first search vertical 
        int low = 0; int high = matrix.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target > matrix[mid][0]) {
                low = mid + 1;
            } else if (target < matrix[mid][0]) {
                high = mid - 1;
            } else return true;
        }

        
        // if we haven't found a match, it means that low == high
        int hor = mid; // place where ours is larger
        int min = Math.min(low, mid);
        int max = Math.max(low, mid);
      
        if ((min > 0) && (target < matrix[min][0])) {
            hor = min - 1;
        } else if ((max < matrix.length - 1) && (target > matrix[max][0])) {
            hor = max + 1;
        }

        low = 0; high = matrix[0].length - 1;

        // then horizontal
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target > matrix[hor][mid]) {
                low = mid + 1;
            } else if (target < matrix[hor][mid]) {
                high = mid - 1;
            } else return true;
        }
        return false;
    }

// BETTER _ BIN SEARCH IN BST!! Cause it's a bst with root = top right corner lol
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rows = matrix.size(),
			cols = matrix[0].size(),
            row = 0, col = cols - 1;
			
        while (row < rows && col > -1) {
            int cur = matrix[row][col];
            if (cur == target) return true;
            if (target > cur) row++;
            else col--;
        }
        
        return false;
    }

// OR DO BIN SEACH Across the whole thing:
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int guess = matrix[row][col];

            if (guess == target) {
                return true;
            } else if (guess < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;        
    }
