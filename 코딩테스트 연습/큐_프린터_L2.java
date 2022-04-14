import java.util.*;
class Solution {
    class Task {
        int location;
        int priorities;
        public Task (int location, int priorities) {
            this.location = location;
            this.priorities = priorities;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int now = 0;
        
        Queue<Task> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            q.add(new Task(i, priorities[i])); // queue에 인덱스, 우선순위 넣음
        }
        
        while(!q.isEmpty()) {
            Task cur = q.poll();
            boolean flag = false;
            for(Task t : q) {
                if(cur.priorities < t.priorities) {
                    flag = true;
                    q.add(cur); 
                    break; // 우선순위가 큰게 있으면 break;
                }                
            }
            if(!flag) {
                now++;
                if(cur.location == location) {
                    answer = now;
                    break;
                }
            }
        }
        return answer;
    }
}
