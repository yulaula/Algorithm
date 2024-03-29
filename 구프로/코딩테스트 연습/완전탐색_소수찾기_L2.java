import java.util.*;

class Solution {
    boolean[] visit;
    char[] arr;
    Set<Integer> set = new HashSet<>();
    
    public boolean isPrime(int n) {
        if(n == 1 || n == 0) {
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }        
        return true;
    }
    
    //char형 배열의 앞에서부터 length 만큼 잘라서 int형으로 변환
    public int charToInt(char[] arr, int length) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < length; i++) {
            sb.append(arr[i]);
        }
        return Integer.parseInt(sb.toString());
    }
    
    public void dfs(int level, int length, String numbers) {
        if(level == length) {
            int num = charToInt(arr, length);
            if(isPrime(num)) {
                set.add(num);
            }
        } else {
            for(int i = 0; i < numbers.length(); i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    arr[level] = numbers.charAt(i);
                    dfs(level+1, length, numbers);
                    visit[i] = false;
                }
            }
        }
    }
    
    public int solution(String numbers) {
        visit = new boolean[numbers.length()];
        arr = new char[numbers.length()];
        
        for(int i = 1; i <= numbers.length(); i++) {
            dfs(0, i, numbers);
        }
        
        return set.size();
    }
}
