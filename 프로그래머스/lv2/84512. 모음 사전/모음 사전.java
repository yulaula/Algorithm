class Solution {
    public int solution(String word) {
        int answer = 0;
        String[] aeiou = {"A", "E", "I", "O", "U"};
        int[] total = {781, 156, 31, 6, 1};
        String[] tmp = word.split("");
        int len = word.length();
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < aeiou.length; j++) {
                if(tmp[i].equals(aeiou[j])) {
                    answer += total[i] * j + 1;
                    break;
                }
            }
        }
        
        return answer;
    }
}