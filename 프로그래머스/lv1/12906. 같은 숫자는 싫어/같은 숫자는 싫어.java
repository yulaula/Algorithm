import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                list.add(arr[0]);
                continue; 
            }
            if(list.get(list.size()-1) == arr[i]) {
                continue;
            }
            list.add(arr[i]);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        } 
        
        return answer;
    }
}