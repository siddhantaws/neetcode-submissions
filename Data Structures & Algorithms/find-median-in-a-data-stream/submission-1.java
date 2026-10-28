class MedianFinder {

     private final PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
    private final PriorityQueue<Integer> hi = new PriorityQueue<>();  
    public MedianFinder() {

    }
    
    public void addNum(int num) {
       lo.offer(num);              // 1. add to lower half
        hi.offer(lo.poll());        // 2. move lower half's max to upper half (keeps ordering)
        if (hi.size() > lo.size())  // 3. rebalance so lo is never smaller
            lo.offer(hi.poll());
     }
    
    public double findMedian() {
         if (lo.size() > hi.size()) return lo.peek();
        return ((long) lo.peek() + hi.peek()) / 2.0;  
    }
}
