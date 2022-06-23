class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int day = 0;
        
        for(int i[] : courses)
        {
            pq.add(i[0]);
            if((day+=i[0])>i[1])
                day-=pq.poll();
        }
        return pq.size();
    }
}