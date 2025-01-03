class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m=new HashMap<>();
        int i;
        for(i=0;i<nums.length;i++)
        {
            if(!m.isEmpty() && m.containsKey(target-nums[i]))
                return new int[]{m.get(target-nums[i]),i};
            m.put(nums[i],i);
        }
        return new int[0];
    }
}