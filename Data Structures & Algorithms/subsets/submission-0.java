class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        subsets(list, nums, new ArrayList(), 0);
        return list;
    }

    private void subsets(List<List<Integer>> list , int nums[] , List<Integer> l , int id) {
        if(id >=nums.length) {
            list.add(new ArrayList(l));
            return;
        }

        l.add(nums[id]);
        subsets(list, nums, l, id+1);
        l.remove(l.size()-1);
        subsets(list, nums, l, id+1);
    }
}
