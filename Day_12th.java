class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0,ans=0,j=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(map.containsKey(nums[i]))
            {
                int k = map.get(nums[i]);
                while(j<=k){
                    map.remove(nums[j]);
                    sum-=nums[j];
                    j++;
                }
            }
            ans = Math.max(ans,sum);
            map.put(nums[i],i);
        }
        return ans;
    }
}