class Solution {
    public int maxArea(int[] height) {
        int l=0;int r=height.length-1;
        int area = Math.min(height[l], height[r])* (r-l);
        while(l<r) {
            if(height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
            area = Math.max(area, Math.min(height[l], height[r])* (r-l));
        }
        return area;
    }
}
