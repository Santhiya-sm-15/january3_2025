class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum=0;
        for(int x:nums)
            sum+=x;
        int cnt=0,i;
        long s=0;
        for(i=0;i<nums.length-1;i++)
        {
            s+=nums[i];
            if(s>=sum-s)
                cnt++;
        }
        return cnt;
    }
}