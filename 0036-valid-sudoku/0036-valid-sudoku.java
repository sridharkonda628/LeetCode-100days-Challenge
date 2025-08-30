class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rws = new HashSet[9];
        HashSet<Character>[] colmns = new HashSet[9];
        HashSet<Character>[] block = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rws[i] = new HashSet<>();
            colmns[i] = new HashSet<>();
            block[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if(ch=='.') continue;
                
                int blockIdx=(i/3)*3+(j/3);

                if(rws[i].contains(ch) || colmns[j].contains(ch) || block[blockIdx].contains(ch)) {
                    return false;
                }
                rws[i].add(ch);
                colmns[j].add(ch);
                block[blockIdx].add(ch);
                
            }
        }

        return true;
    }
}