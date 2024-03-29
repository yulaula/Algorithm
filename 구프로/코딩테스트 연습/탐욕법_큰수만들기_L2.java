import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int now = 0;
        int tmpNow = 0;
        int len = number.length() - k;
        
        for(int i = 0; i < len; i++) {
            int max = 0;
            for(int j = now; j <= i+k; j++) {
                int tmpNum = number.charAt(j) - '0';
                if(tmpNum == 9) {
                    max = 9;
                    tmpNow = j;
                    break;
                } else if(max < tmpNum){
                    max = tmpNum;
                    tmpNow = j;
                }
            }
            sb.append(max);
            now = tmpNow + 1;     
        }
        
        return sb.toString();
    }
}
