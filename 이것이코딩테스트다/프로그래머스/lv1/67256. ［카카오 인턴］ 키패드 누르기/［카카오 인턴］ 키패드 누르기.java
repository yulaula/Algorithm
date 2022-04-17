class Solution {
    public int checkDistance(int number, int cur) {
        int numberX = (number-1)/3;
        int numberY = (number-1)%3;
        int curX = (cur-1)/3;
        int curY = (cur-1)%3;
        System.out.println(number+ " " + cur);
        
        return Math.abs(numberX-curX) + Math.abs(numberY-curY);
    }
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int curLen = 10;
        int curRig = 12;
        for(int number : numbers) {
           if(number == 1 || number == 4 || number == 7) {
               answer += "L";
               curLen = number;
           }
            else if(number == 3 || number == 6 || number == 9) {
                answer += "R";
                curRig = number;
            }
            else {
                if(number == 0) number = 11;
                
                int disL = checkDistance(number, curLen);
                int disR = checkDistance(number, curRig);
                if(disL == disR) {
                    answer += (hand.toUpperCase()).charAt(0) + "";
                    if(hand.equals("left")) {
                        curLen = number;
                    } else {
                        curRig = number;
                    }
                }
                else if(disL > disR) {
                    answer += "R";
                    curRig = number;
                }
                else {
                    answer += "L";
                    curLen = number;
                }
            }
            //System.out.println(number + " " + answer);
        }        
        return answer;
    }
}