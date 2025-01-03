class Solution {
    public int lenOfLongestSubarr(int[] arr, int k) {
        Map<Long,Integer> m=new HashMap<>();
        int i,n=arr.length,max=0;
        long sum=0;
        for(i=0;i<n;i++)
        {
            sum+=arr[i];
            if(sum==k)
                max=Math.max(max,i+1);
            long x=sum-k;
            if(m.containsKey(x))
                max=Math.max(max,i-m.get(x));
            if(!m.containsKey(sum))
                m.put(sum,i);
        }
        return max;
    }
}
