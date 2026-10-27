class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candi_1 =0;int candi_2 =0; int count_1=0;int count_2=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == candi_1 || nums[i] ==candi_2 ) {
                if(nums[i] == candi_1)
                    count_1++;
                else 
                    count_2++;   
            } else if (count_1 ==0 ) {
                count_1++;
                candi_1 = nums[i];
            } else if (count_2 ==0 ) {
                count_2++;
                candi_2 = nums[i];
            } else {
                count_1--;
                count_2--;
            }

        }
        count_1 = 0;
        count_2 = 0;
        for(int i=0;i<nums.length;i++) {
            if(candi_1 == nums[i])
                count_1++;
            else if(candi_2 == nums[i])
                count_2++;
        }
        List<Integer> l =new ArrayList<>();
        if(count_1 > nums.length/3)
            l.add(candi_1);
        if(count_2 > nums.length/3)
            l.add(candi_2);            
        return l;    
    }
}