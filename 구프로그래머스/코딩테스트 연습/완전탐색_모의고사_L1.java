import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] answer = {};
        int[] case1 = {1,2,3,4,5};
        int[] case2 = {2,1,2,3,2,4,2,5};
        int[] case3 = {3,3,1,1,2,2,4,4,5,5};
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        for(int i = 0 ; i < answers.length; i++) {
            if(answers[i] == case1[i % case1.length]) {
                count1++;
            }
            
            if(answers[i] == case2[i % case2.length]) {
                count2++;
            }
            
            if(answers[i] == case3[i % case3.length]) {
                count3++;
            }
        }
        
        int max = Math.max(Math.max(count1, count2), count3);
        
        if(max == count1) list.add(1);
        if(max == count2) list.add(2);
        if(max == count3) list.add(3);
        
        answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}
