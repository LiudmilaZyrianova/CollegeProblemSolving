// 36. Valid Sudoku - M
    public void cleanArray(boolean[] found) {
        for (int i = 0; i < 9; i++) {
            found[i] = false;
        }
    }
    public boolean isValidSudoku(char[][] board) {
        boolean[] found = new boolean[9];
        cleanArray(found);

        // validate horizontals
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (found[board[i][j] - '1']){
                        return false;
                    }
                    found[board[i][j] - '1'] = true;
                }

            }
            cleanArray(found);
        }

        // validates verticals
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (found[board[j][i] - '1']){
                        return false;
                    }
                    found[board[j][i] - '1'] = true;
                }

            }
            cleanArray(found);
        }


        // validate boxes
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int a = 3 * i + k;
                        int b = 3 * j + l;
                        if (board[a][b] != '.') {
                            if (found[board[a][b] - '1']){
                                return false;
                            }
                            found[board[a][b] - '1'] = true;
                        }
                    }
                }
                cleanArray(found);
            }
        }

        return true;
    }


// better solution - encode seen elements: '4' in row 7 is encoded as "(4)7".
public boolean isValidSudoku(char[][] board) {
    Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            if (board[i][j] != '.') {
                String b = "(" + board[i][j] + ")";
                if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                    return false;
            }
        }
    }
    return true;
}
