import java.util.*;
class Solution {
    public String solution(String s) {
        
        String[] arr = new String[s.length()];
        for(int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) + "";
        }
        Arrays.sort(arr, Collections.reverseOrder());
        
        String answer = String.join("", arr);
                
        return answer;
    }
}