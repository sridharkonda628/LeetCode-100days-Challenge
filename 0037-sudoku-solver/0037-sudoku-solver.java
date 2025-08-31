class Solution {
    public boolean fun(int i, int j, char[][] sudokuBoard, HashMap<Integer, HashSet<Integer>> rws, HashMap<Integer, HashSet<Integer>> cols, HashMap<Integer, HashSet<Integer>> grid) {
        if (i == 9) {
            return true;
        }
        if (j == 9) {
            return fun(i+1, 0, sudokuBoard, rws, cols, grid);
        }
        if (sudokuBoard[i][j] != '.') {
            return fun(i, j+1, sudokuBoard, rws, cols, grid);
        }
        for (int digi= 1; digi <= 9; digi++) {
            if (!rws.get(i).contains(digi) && !cols.get(j).contains(digi) && !grid.get(((i/3)*3)+(j/3)).contains(digi)) {
                sudokuBoard[i][j] = (char) (digi+'0');
                rws.get(i).add(digi);
                cols.get(j).add(digi);
                grid.get(((i/3)*3)+(j/3)).add(digi);
                if (fun(i, j+1, sudokuBoard, rws, cols, grid)) {
                    return true;
                }
                sudokuBoard[i][j] = '.';
                rws.get(i).remove(digi);
                cols.get(j).remove(digi);
                grid.get(((i/3)*3)+(j/3)).remove(digi);
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        HashMap<Integer, HashSet<Integer>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> columns = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> grid = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rows.put(i,new HashSet());
            columns.put(i,new HashSet());
            grid.put(i,new HashSet());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    rows.get(i).add(digit);
                    columns.get(j).add(digit);
                    grid.get(((i/3)*3)+(j/3)).add(digit);
                }
            }
        }
        fun(0, 0, board, rows, columns, grid);
    }
}