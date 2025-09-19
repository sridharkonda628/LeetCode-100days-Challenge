class Spreadsheet {
    int[][] mat ;
    public Spreadsheet(int rows) {
        mat = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int col = (int)cell.charAt(0)-65;
        
        int rw = Integer.parseInt(cell.substring(1))-1;
        mat[rw][col] = value;
    }
    
    public void resetCell(String cell) {
        int col = (int)cell.charAt(0)-65;
        int rw = Integer.parseInt(cell.substring(1))-1;
        mat[rw][col] = 0;
    }
    
    public int getValue(String formula) {
        int idx = formula.indexOf("+");
        String word1 =  formula.substring(1,idx);
        String word2 =  formula.substring(idx+1);

        int a=0;
        int b=0;
        a = Character.isUpperCase(word1.charAt(0))?getN(word1):Integer.parseInt(word1);
        b = Character.isUpperCase(word2.charAt(0))?getN(word2):Integer.parseInt(word2);
        return a+b;
    }
    public int getN(String cell){
        int col = (int)cell.charAt(0)-65;
        int rw = Integer.parseInt(cell.substring(1))-1;
        return mat[rw][col];
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */