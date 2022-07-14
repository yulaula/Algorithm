import java.util.*;
class Solution {
    public String solution(String s) {
        
        String[] arr = new String[s.length()];
        for(int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) + "";
        }
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        String answer = sb.toString();
        return answer;
    }
}