class MedianFinder {

    //Rule -1  - always add in maxHeap first and pop from maxheap and add it in mean heap
    //Rule - 2 - always make sure miheap never exceed size of maxHeap     
    Queue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
    Queue<Integer> minHeap = new PriorityQueue();

    public MedianFinder() {

    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size()> maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size())
            return (double)maxHeap.peek();
        return (maxHeap.peek() + minHeap.peek())/ 2.0;    
    }
}
