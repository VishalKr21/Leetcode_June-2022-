class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    public int minOperations(int[] nums, int x) {
       int sum =0 ;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            map.put(sum,i);
        }
        if(sum<x)return -1;
        map.put(0,0);
        int longest = 0;
        sum-=x;
        int val = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            val+=nums[i];
            if(map.containsKey(val-sum))
            {
                if(val-sum==0)
                    longest = Math.max(longest,i-map.get(val-sum)+1);
                else
                    longest = Math.max(longest,i-map.get(val-sum));
            }
                  
        }
        return longest==0?(sum==0?nums.length:-1):nums.length-longest;
    }
}