// 200. Number of Islands - M

    public class Coord {
        public int x;
        public int y;
        Coord(int x, int y) {this.x = x; this.y = y;}
    }
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Coord> bfs = new LinkedList<>();
        int res = 0;

        for (int a = 0; a<grid.length; a++) {
            for (int b = 0; b < grid[0].length; b++) {
                if (grid[a][b] == '1') {
                           
                    Coord root = new Coord(a, b);
                    bfs.add(root);
                    grid[root.x][root.y] = '0'; //mark as visited
                    while (!bfs.isEmpty()) {
                        Coord curr = bfs.poll();
                        int i = curr.x; int j = curr.y;
                        if (i < n-1 && grid[i+1][j] =='1') {
                            bfs.add(new Coord(i+1, j));
                            grid[i+1][j] = '0'; //mark as visited
                        }
                        if (i > 0 && grid[i-1][j] =='1') {
                            bfs.add(new Coord(i-1, j));
                            grid[i-1][j] = '0'; //mark as visited
                        }
                        if (j < m-1 && grid[i][j+1] =='1') {
                            bfs.add(new Coord(i, j+1));
                            grid[i][j+1] = '0'; //mark as visited
                        }
                        if (j > 0 && grid[i][j-1] =='1') {
                            bfs.add(new Coord(i, j-1));
                            grid[i][j-1] = '0'; //mark as visited
                        }
                    }
                    res++;
                }
            }
        }
        return res;
 
        
    }
