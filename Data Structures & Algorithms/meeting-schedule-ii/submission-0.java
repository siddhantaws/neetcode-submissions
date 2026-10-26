/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Interval i :intervals) {
            map.put(i.start, map.getOrDefault(i.start, 0)+1);
            map.put(i.end, map.getOrDefault(i.end, 0)-1);
        }
        int count =0;
        int maxCount=0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            count+=e.getValue();
            maxCount = Math.max(maxCount , count);
        }
        return maxCount;
    }
}
