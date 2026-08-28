class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mapOfNumToCount = new HashMap<>();
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int num :nums)
            mapOfNumToCount.put(num, mapOfNumToCount.getOrDefault(num, 0)+1);
        for(Map.Entry<Integer , Integer> entry :mapOfNumToCount.entrySet()){
            queue.offer(new int[] {entry.getValue(), entry.getKey()});
            if(queue.size()>k)
               queue.poll(); 
        } 
        int arr[] = new int[k];   
        for(int i=0;i<k;i++) 
            arr[i] = queue.poll()[1];
        return arr;    
    }
}
