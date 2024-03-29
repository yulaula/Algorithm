class Solution {
    static int answer;
    public void dfs(int[] numbers, int target, int level, int sum) {
        if(level == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        
        sum += numbers[level];
        dfs(numbers, target, level+1, sum);
        sum -= numbers[level];
        
        sum += (-1) * numbers[level];
        dfs(numbers, target, level+1, sum);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        int level = 0;
        int sum = 0;
        
        dfs(numbers, target, level, sum);
        
        return answer;
    }
}
