import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] nums;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 1. 초기화
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
		    nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int addition = Integer.parseInt(st.nextToken());
		int subtraction = Integer.parseInt(st.nextToken());
	    int multiply = Integer.parseInt(st.nextToken());
		int divide = Integer.parseInt(st.nextToken());
		
		// dfs
		dfs(1, nums[0], addition, subtraction, multiply, divide);
		
		bw.write(max + "\n");
		bw.write(min + "");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static void dfs(int idx, int currentValue, int addition, int substraction, int mutiply, int divide) {
	    // 1. nums 배열 탐색 완료
	    if(idx == N) {
	        max = Math.max(max, currentValue);
	        min = Math.min(min, currentValue);
	        return;
	    }
	    
	    if(addition > 0) {
	        dfs(idx + 1, currentValue + nums[idx], addition - 1, substraction, mutiply, divide);
	    }
	    
	    if(substraction > 0) {
	        dfs(idx + 1, currentValue - nums[idx], addition, substraction - 1, mutiply, divide);
	    }
	    
	    if(mutiply > 0) {
	        dfs(idx + 1, currentValue * nums[idx], addition, substraction, mutiply - 1, divide);
	    }
	    
	    // 음수를 양수로 나눌 땐 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 변경
	    if(divide > 0) {
	        int nextValue;
	        if(currentValue < 0) {
	            nextValue = -(-currentValue / nums[idx]);
	        } else {
	            nextValue = currentValue / nums[idx];
	        }
	        
	        dfs(idx + 1, nextValue, addition, substraction, mutiply, divide - 1);
	    }
	}
}