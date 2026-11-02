class Solution {
    public int maxCoins(int[] nums) {
        int num1[] = new int[nums.length+2];
        num1[0] = 1;num1[num1.length-1] = 1;
        for(int i=0;i<nums.length;i++)
            num1[i+1] =nums[i];
        return dfs(num1, 1, num1.length-2, new HashMap<>());
    }

    private int dfs(int nums[] , int start, int end, Map<String,Integer> dpMap) {
        if(start > end)
            return 0;
        String key = start + "$" + end;
        if(dpMap.containsKey(key))
            return dpMap.get(key);
        int maxCount = 0;
        for(int i=start; i<=end;i++) {
            int count =0;
            count += nums[i] * nums[start-1] * nums[end+1];
            count += dfs(nums, start , i-1, dpMap) + dfs(nums, i+1, end, dpMap);
            maxCount = Math.max(maxCount, count);
        }

        dpMap.put(key, maxCount);
        return  dpMap.get(key);       
    }

}
