class KthLargest {

    private Queue<Integer> queue ;
    int k ;
    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<Integer>((a, b) -> a.compareTo(b));
        this.k= k;
        for(int num : nums) {
            queue.add(num);
            if (queue.size()>k) {
                queue.poll();
            }
        }
    }
    
    public int add(int val) {
        queue.add(val);
        if (queue.size()>k) {
           queue.poll();
        }
        return queue.peek();
    }
}
