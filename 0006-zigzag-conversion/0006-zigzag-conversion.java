class Solution {
    public String convert(String s, int numRows) {
        // return s;
        if(numRows==1 || numRows>=s.length() ){
            return s;
        }
        int idx =0, dir =0;


        List<Character>[] rows = new ArrayList[numRows];
        for(int i=0;i<numRows;i++){
            rows[i] = new ArrayList<>();
        }

        for(char ch: s.toCharArray()){
            rows[idx].add(ch);
            if(idx==0){
                dir=1;
            }else if(idx==numRows-1){
                dir =-1;
            }
            idx+=dir;
        }
        StringBuilder res = new StringBuilder();
        for(List<Character> rw : rows){
            for(char ch : rw){
                res.append(ch);
            }
        }

        return res.toString();



    }
}

// sridhar 
// s r i d h 
//     a r
// s     
// r   
// i   r
// d a
// h