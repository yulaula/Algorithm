import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int max = nums.length/2;
        HashSet<Integer> total = new HashSet<>();
        
        for(int num : nums) {
            total.add(num);
        }
        
        if(total.size() >= max) {
            answer = max;
        } else {
            answer = total.size();
        }
        
        return answer;
    }
}