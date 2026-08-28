class Solution {
    public int trap(int[] height) {
        int l =0;int r= height.length-1;
        int lMax= height[l];int rMax= height[r];
        int count =0;
        while(l<r) {
            if (lMax < rMax) {
                l++;
                lMax= Math.max(lMax, height[l]);
                count += lMax - height[l];
            } else {
                r--;
                rMax= Math.max(rMax, height[r]);
                count += rMax- height[r]; 
            }
        }
        return count;
    }
}
