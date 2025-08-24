class Solution {
    public int longestSubarray(int[] nums) {
        int cnt =0;
        int len = nums.length;
        int arr[] = new int[len];
        int maxi =0;
        boolean flg =false;

        for(int i=0;i<len;i++){
            if(nums[i]==1){
                cnt++;
                maxi = Math.max(cnt,maxi);
                arr[i] = cnt;

            }else{
                cnt=0;
                flg = true;
                
            }
        }

        if(arr[len-1]==len){
            return len-1;
        }
        
        int temp = arr[len-1];
        for(int i=len-1;i>0;i--){
            if(arr[i]!=0){
                arr[i] = temp;
            }else{
                temp = arr[i-1];
            }
        }
        //after deletion  we can get the maximum when pattern looks like [....1.0.1]
        int ans = 0 ;
        for(int i=1;i<len-1;i++){
            if(nums[i]==0){
                if(nums[i-1]==1 && nums[i+1]==1){
                    ans = Math.max(ans,arr[i-1]+arr[i+1]);
                }
            }
        }
       
        return Math.max(ans,maxi);
       
    }
}