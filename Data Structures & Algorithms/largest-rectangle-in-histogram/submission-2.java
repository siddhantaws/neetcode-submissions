class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea= Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<=n;i++) {
            while(!stack.isEmpty() && ((i == n) ||  heights[stack.peek()] >= heights[i])) {
                int height =  heights[stack.pop()];
                int weight= stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height*weight );
            }
            stack.push(i);
        }
        return maxArea;
    }
}
