class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> arr = new ArrayList<>();
        for(int num : cards){
            arr.add((double)num);
        }
        return dfs(arr);
    }

    private boolean dfs(List<Double> arr){
        if(arr.size()==1){
            return Math.abs(arr.get(0)-24)<1e-6;
        }

        for(int i=0;i<arr.size();i++){
            for(int j=0;j<arr.size();j++){
                if(i==j) continue;
                List<Double> nxt = new ArrayList<>();
                for(int k=0;k<arr.size();k++){
                    if(k!=i && k!=j){
                        nxt.add(arr.get(k));
                    }
                }
                for (int op = 0; op < 4; op++) {
                    if (op < 2 && j > i) continue;
                    double a = arr.get(i);
                    double b = arr.get(j);
                    double res = 0;
                    switch (op) {
                        case 0: res = a + b; break;
                        case 1: res = a * b; break;
                        case 2: res = a - b; break;
                        case 3: 
                            if (b == 0) continue;
                            res = a / b; 
                            break;
                    }
                    nxt.add(res);
                    if (dfs(nxt)) {
                        return true;
                    }
                    nxt.remove(nxt.size() - 1);
                }
            }
        }
        return false;
    }
    
}