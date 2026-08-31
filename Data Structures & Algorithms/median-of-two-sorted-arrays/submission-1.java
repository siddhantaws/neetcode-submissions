class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) 
            return findMedianSortedArrays(nums2, nums1);
        int start = 0; int end = nums1.length;
        while(start <= end) {
            int xPartition = (start+end)/2;
            int yPartition = (nums1.length + nums2.length +1 )/2 - xPartition;

            int leftXMax = xPartition ==0 ? Integer.MIN_VALUE : nums1[xPartition-1];
            int rightXMin = xPartition ==nums1.length ? Integer.MAX_VALUE : nums1[xPartition];
            int leftYMax = yPartition ==0 ? Integer.MIN_VALUE : nums2[yPartition-1];
            int rightYMin = yPartition ==nums2.length ? Integer.MAX_VALUE : nums2[yPartition];

            if (leftXMax <=rightYMin && leftYMax <=rightXMin) {
                if ((nums1.length + nums2.length)%2 ==0) {
                    return (double) (Math.max(leftXMax, leftYMax) + Math.min(rightXMin,rightYMin ))/2.0 ;
                } else {
                    return Math.max(leftXMax, leftYMax);
                } 
            } else if (leftXMax > rightYMin) {
                end = xPartition-1;
            } else {
                start = xPartition+1;
            }

        }
        return 0D;
    }
}
