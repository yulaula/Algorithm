import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        //System.out.println("price length : " + prices.length);
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int time = 0;
            // System.out.println("i : " + i);
            if(i == prices.length-1) {
                q.add(0);
                System.out.println(q.size());
                break;
            }
            for(int j = i+1; j < prices.length; j++) {
                if(prices[i] > prices[j] || j == prices.length-1) {
                    //System.out.println("j : "+ j);
                    time++;
                    //System.out.println("time : " + time);
                    q.add(time);
                    break;
                } else {
                    time++;
                }
            }
        }
        //System.out.println("size : " + q.size());
        int size = q.size();
        for(int i = 0; i < size; i++) {
            answer[i] = q.remove();
            //System.out.println("answer : " + answer[i]);
        }
        
        return answer;
    }
}