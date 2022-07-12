import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        for(int tmp : arr) {
            if((tmp % divisor) == 0) {
                list.add(tmp);
            }
        }
        
        Collections.sort(list);
        
        if(list.size() == 0) {
            list.add(-1);
        }
        
        int[] answer = list.stream()
                        .mapToInt(i -> i)
                        .toArray();
        
        return answer;
    }
}