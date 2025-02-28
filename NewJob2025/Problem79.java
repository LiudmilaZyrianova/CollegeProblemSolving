// 79. Word Search - M 
class Solution {
    public boolean existsWithVisited(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {return false;}
        
        if (word.length() == index) {return true;}
        
        if (!visited[i][j] && board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            if (word.length() == index + 1) {return true;}
            if (existsWithVisited(board, visited, word, i+1, j, index + 1)) {return true;}
            if (existsWithVisited(board, visited, word, i-1, j, index + 1)) {return true;}
            if (existsWithVisited(board, visited, word, i, j+1, index + 1)) {return true;}
            if (existsWithVisited(board, visited, word, i, j-1, index + 1)) {return true;}
            visited[i][j] = false;
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existsWithVisited(board, visited, word, i, j, 0)) return true;
            }
        }
        
        return false;
    }
}
