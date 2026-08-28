class Solution {
    public int[] productExceptSelf(int[] nums) {
        int productArr[] = new int[nums.length];
        productArr[0] = 1;
        for(int i=1;i<nums.length;i++)
            productArr[i] = productArr[i-1] * nums[i-1];
        int productPostFix = 1;
        for(int i=nums.length-1;i>=0;i--) {
            productArr[i] = productArr[i]* productPostFix;
            productPostFix = nums[i]*productPostFix;
        }
        return productArr;
    }
}  
