import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) { 
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        int tmp = 0;
        int len = board.length-1;
        
        for(int i = 0; i < moves.length; i++) {
            int y = moves[i]-1;
            if(board[len][y] == 0) continue; // 인형이 모두 없는 칸
            for(int x = 0; x < board.length; x++) { // 인형 있는 칸이 나올 때까지
                if(board[x][y] == 0) continue;
                else {
                    tmp = board[x][y];
                    board[x][y] = 0; // 인형 뽑음
                    break;
                }
            }
            
            // stack으로
            if(s.isEmpty()) {
                s.push(tmp);
            } else {
                if(s.peek() == tmp) {
                    s.pop();
                    tmp = 0;
                    answer += 2;
                } else {
                    s.push(tmp);
                }
            }
        }
        
        return answer;
    }
}