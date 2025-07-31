class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        // int ans =0;

        int n = arr.length;
        Set<Integer> subarrayBitwiseORs = new HashSet<>();
       
        Set<Integer> curr = new HashSet<>();
        curr.add(0);

        for(int i=0;i<n;i++){
            Set<Integer> curr2 = new HashSet<>();
           
           for(int y : curr){
            curr2.add(arr[i]|y);
           }
           curr2.add(arr[i]);
           curr = curr2;
           subarrayBitwiseORs.addAll(curr);

        }

        return subarrayBitwiseORs.size();

    }
}