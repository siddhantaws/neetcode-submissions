class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l =new ArrayList();
        permute(l, nums, 0);
        return l;
    }

    private void permute(List<List<Integer>> l, int nums[], int id) {
        if(id>=nums.length) {
            l.add(Arrays.stream(nums).mapToObj(i->i).collect(Collectors.toList()));
            return;
        }
        for(int i = id;i<nums.length;i++) {
            swap(nums, i , id);
            permute(l, nums, id+1);
            swap(nums, i, id);
        }
    }

    private void swap(int nums[] , int i , int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
