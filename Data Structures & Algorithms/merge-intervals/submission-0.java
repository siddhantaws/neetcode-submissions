class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int interval[]: intervals)
            pq.add(new int[]{interval[0], interval[1]});
        List<int[]>  l = new ArrayList<>();
        while(pq.size()>1) {
            int a []= pq.poll();
            int b []= pq.poll();
            if(isOverlap(a, b)) {
                int min = Math.min (a[0], b[0]);
                int max = Math.max (a[1], b[1]);
                pq.add(new int[]{min, max});
            } else {
                l.add(a);
                pq.add(b);
            }
        }
        while(!pq.isEmpty())
            l.add(pq.poll());
        return l.toArray(int[][]::new);
    }

    private boolean isOverlap(int a[], int b[]) {
        return a[1] >= b[0];
    }
}
