import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answer_index = 0;
        
        for(int i = 0; i < commands.length; i++) {
            int length = commands[i][1] - commands[i][0] + 1;
            //System.out.println("length : " + length);
            int[] tmp = new int[length];
            
            int index = 0;
            for(int j = commands[i][0]-1; j < commands[i][1]; j++) {
                tmp[index++] = array[j];
            }
            Arrays.sort(tmp);
            answer[answer_index] = tmp[commands[i][2] - 1];
            //System.out.println(answer[answer_index]);
            answer_index++;
        }
        
        return answer;
    }
}