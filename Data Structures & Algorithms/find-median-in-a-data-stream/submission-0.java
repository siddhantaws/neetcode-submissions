class MedianFinder {

    private Queue<Integer> smallHeap;
    private Queue<Integer> largeHeap;

    public MedianFinder() {
        this.smallHeap = new PriorityQueue<>((a,b) -> b-a);
        this.largeHeap = new PriorityQueue<>((a,b) -> a-b);
    }
    
    public void addNum(int num) {
       smallHeap.add(num);
       if (smallHeap.size() - largeHeap.size() > 1 || (!largeHeap.isEmpty() && smallHeap.peek()> largeHeap.peek())) {
            largeHeap.add(smallHeap.poll());
       }
       if(largeHeap.size() > smallHeap.size() ) {
            smallHeap.add(largeHeap.poll());
       }
     }
    
    public double findMedian() {
         if (smallHeap.size() == largeHeap.size()) {
            return (double) (largeHeap.peek() + smallHeap.peek())/2.0;
         } if (smallHeap.size() < largeHeap.size()) {
            return (double) largeHeap.peek();
         } else {
            return (double) smallHeap.peek();
         }
    }
}
