// 64. Minimum Path Sum - M
    public int minPathSum(int[][] grid) {
        // Dijkstra Algo...
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        Queue<Integer> visited = new LinkedList<>();
        visited.add(0);
        dist[0][0] = grid[0][0];

        while (visited.size() != 0) {
            int curr = visited.poll();
            // for each child update and push
            int currI = curr / 1000;
            int currJ = curr % 1000;
            if (currI < m-1) {
                //currI++;
                if (dist[currI+1][currJ] == 0) {
                    visited.add(1000*(currI+1) + currJ);
                    dist[currI+1][currJ] = dist[currI][currJ] + grid[currI+1][currJ];
                } else {
                    dist[currI+1][currJ] = Math.min(
                        dist[currI][currJ] + grid[currI+1][currJ], 
                        dist[currI+1][currJ]) ;
                }

            }
            if (currJ < n-1) {
                //currJ++;
                if (dist[currI][currJ+1] == 0) {
                    visited.add(1000*(currI) + currJ + 1);
                    dist[currI][currJ+1] = dist[currI][currJ] + grid[currI][currJ+1];
                } else {
                    dist[currI][currJ+1] = Math.min(
                        dist[currI][currJ] + grid[currI][currJ+1], 
                        dist[currI][currJ+1]) ;
                }
            }
        }

        return dist[m-1][n-1];
    }
// MUCH QUICKER - DP!!!!!!
public static int minPathSum(int[][] grid) {

            int height = grid.length;
            int width = grid[0].length;
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    if(row == 0 && col == 0) grid[row][col] = grid[row][col];
                    else if(row == 0 && col != 0) grid[row][col] = grid[row][col] + grid[row][col - 1];
                    else if(col == 0 && row != 0) grid[row][col] = grid[row][col] + grid[row - 1][col];
                    else grid[row][col] = grid[row][col] + Math.min(grid[row - 1][col], grid[row][col - 1]);
                }
            }
            return grid[height - 1][width - 1];
        }
