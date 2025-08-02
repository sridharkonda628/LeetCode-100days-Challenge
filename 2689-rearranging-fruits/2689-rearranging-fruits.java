// import java.util.*;
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer,Integer> tp = new TreeMap<>();
        int mini = (int)1e9;

        for(int num : basket1){
            tp.put(num,tp.getOrDefault(num,0)+1);
            mini = Math.min(mini,num);

        }
        for(int num : basket2){
            tp.put(num,tp.getOrDefault(num,0)-1);
            mini = Math.min(mini,num);

        }
        List<Integer> arr = new ArrayList<>();
        for(var num:tp.entrySet()){
            int freq = num.getValue();
            if((freq&1)==1){
                return -1;
            }
            for(int i=0;i<Math.abs(freq)/2;i++){
                arr.add(num.getKey());
            }
        }
        Collections.sort(arr);
        long minCost = 0;
        for(int i=0;i<arr.size()/2;i++){
            minCost+=Math.min(2*mini,arr.get(i));
        }

        return minCost;


    }
}