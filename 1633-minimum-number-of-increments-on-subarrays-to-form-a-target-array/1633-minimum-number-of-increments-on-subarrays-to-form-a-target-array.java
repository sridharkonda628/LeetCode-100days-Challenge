class Solution {
    public int minNumberOperations(int[] target) {
        int len = target.length;

        int minNumberOperations =target[0];

        for(int i=1;i<len;i++){
            minNumberOperations+= Math.max(target[i]-target[i-1],0);
        }

        return minNumberOperations;
    }
}