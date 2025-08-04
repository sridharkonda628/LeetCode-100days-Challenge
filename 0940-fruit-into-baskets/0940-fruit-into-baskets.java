class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        int totalFruit =0;

        int leftPtr =0;
        Map<Integer,Integer> hp = new HashMap<>();

        for(int rightPtr =0;rightPtr<n;rightPtr++){

            hp.put(fruits[rightPtr],hp.getOrDefault(fruits[rightPtr],0)+1);
            while(hp.size()>2){
                hp.put(fruits[leftPtr],hp.get(fruits[leftPtr])-1);
                if(hp.get(fruits[leftPtr])==0){
                    hp.remove(fruits[leftPtr]);
                }
                leftPtr++;
            }
            totalFruit = Math.max(totalFruit,rightPtr-leftPtr+1);
        }

        return totalFruit;
    }
}