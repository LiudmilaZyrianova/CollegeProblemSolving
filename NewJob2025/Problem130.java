// 130. Surrounded Regions - M

public class Coord {
        public int x;
        public int y;
        Coord(int x, int y) {this.x = x; this.y = y;}
    }

    public void bfs(char[][] board, Coord root) {
        int m = board.length;
        int n = board[0].length;

        Queue<Coord> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            Coord curr = bfs.poll();

            if ((curr.x < m-1) && (board[curr.x+1][curr.y] == 'O')) {
                bfs.add(new Coord(curr.x+1,curr.y));
            }

            if ((curr.x > 0) && (board[curr.x-1][curr.y] == 'O')) {
                bfs.add(new Coord(curr.x-1,curr.y));
            }

            if ((curr.y < n-1) && (board[curr.x][curr.y+1] == 'O')) {
                bfs.add(new Coord(curr.x,curr.y+1));
            }

            if ((curr.y > 0) && (board[curr.x][curr.y-1] == 'O')) {
                bfs.add(new Coord(curr.x,curr.y-1));

            board[curr.x][curr.y] = 'o';
        }
        return;
    }

    public void solve(char[][] board) {
        // again with bsf
        // instead of polling in queue, keep them and then re-color
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, new Coord(i, 0));
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][n-1] == 'O') {
                bfs(board, new Coord(i, n-1));
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                bfs(board, new Coord(0, j));
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[m-1][j] == 'O') {
                bfs(board, new Coord(m-1, j));
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'o') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }


// much faster:

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int r = 0; r < n; r++){
            if(board[r][0] == 'O'){
                dfs(board, r, 0);
            }
            if(board[r][m - 1] == 'O'){
                dfs(board, r, m - 1);
            }
        }
        for(int c = 0; c < m; c++){
            if(board[0][c] == 'O'){
                dfs(board, 0, c);
            }
            if(board[n - 1][c] == 'O'){
                dfs(board, n - 1, c);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'V'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j){
        if(0 <= i && i < board.length && 0 <= j && j < board[0].length && board[i][j] == 'O' && board[i][j] != 'V'){
            board[i][j] = 'V';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }
