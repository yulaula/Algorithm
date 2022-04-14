import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int index = 0;
        Queue<Integer> q = new LinkedList<>();
                
        for(int i = 0; i < progresses.length; i++) {
            //System.out.println("i : " + i);
            int count = 0;
            int day;
            int j = i;
            for(day = 1; day <= 100; day++) {
                if(progresses[i]+(speeds[i]*day) >= 100) {
                    count++;
                    break;
                }                
            }
            //System.out.println("day : " + day);
            for(j = i+1; j < progresses.length; j++) {
                if(progresses[j]+(speeds[j]*day) >= 100) {
                    count++;
                } else {
                    break;
                }
            }
            i = j-1;
            //System.out.println("count : " + count);
            q.add(count);
        }
        answer = new int[q.size()];
        //System.out.println("q size : " + q.size());
        for(int i = 0; i < answer.length; i++) {
            answer[i] = q.remove();
            //System.out.println("answer : " + answer[i]);
        }
        return answer;
    }
}
