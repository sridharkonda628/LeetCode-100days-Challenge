class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> rowsOfPacalTriangle = new ArrayList<>();
            rowsOfPacalTriangle.add(1);
            if(i>0){
                List<Integer> prevRow = pascalTriangle.get(i-1);
                for(int j=1;j<i;j++){
                
                    rowsOfPacalTriangle.add(prevRow.get(j-1)+prevRow.get(j));
                }
                rowsOfPacalTriangle.add(1);
            }
            pascalTriangle.add(rowsOfPacalTriangle);
        }

        return pascalTriangle;
    }
}