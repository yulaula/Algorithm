class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int endA;
        int move = length - 1;
        
        for(int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i) + 1); // 'Z'-'Y'일 때 A->Z->Y 순 이므로 +1 해야함
            
            endA = i+1;
            
            while(endA < length && name.charAt(endA) == 'A') {
                endA++;
            }
            move = Math.min(move, i*2 + length-endA);
            move = Math.min(move, (length-endA)*2 + i);
            
        }
        
        System.out.println("result : " + (answer + move));
        return answer + move;
    }
}
