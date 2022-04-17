import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int equal = 0;
        int zero = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i : lottos) {
            list.add(i);
        }
        //System.out.println(list.toString());
        
        
        for(int i = 0; i < win_nums.length; i++) {
            if(list.contains(win_nums[i])) {
                equal++;
                list.remove(Integer.valueOf(win_nums[i]));
            }
        }
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == 0) {
                zero++;
            }
        }
        
        int sum = equal + zero;
        for(int i = 0; i < 2; i++) {
            int score = 0;
            //System.out.println("sum " + sum);
            
            if(sum == 6)  score = 1;
            else if(sum == 5) score = 2;
            else if(sum == 4) score = 3;
            else if(sum == 3) score = 4;
            else if(sum == 2) score = 5;
            else score = 6;
            
            answer[i] = score;
            sum -= zero;
        }
                
        return answer;
    }
}