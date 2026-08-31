class Solution {

    private Queue<int []> queue = new PriorityQueue<>((a , b) -> Integer.compare( b[0] * b[0] + b[1] * b[1] , a[0] * a[0] + a[1] * a[1]));
    public int[][] kClosest(int[][] points, int k) {
        for (int point[] : points) {
            queue.add(point);
            if(queue.size() >k )
                queue.poll();
        }
        int res[][] = new int [k][2];
        int i=0;
        while(!queue.isEmpty()) {
            res[i++] = queue.poll();
        }
        return res;
    }
}
