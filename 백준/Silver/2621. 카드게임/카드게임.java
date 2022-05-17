import java.util.*;
public class Main {
    static List<Card> list;
    static List<String> COLOR;
    static List<Integer> NUMBER;
    static int[] NUM_EQUAL;
    static int ANSWER, MAX;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        ANSWER = Integer.MIN_VALUE;
        MAX = Integer.MIN_VALUE;
        list = new ArrayList<>();
        COLOR = new ArrayList<>();
        NUMBER = new ArrayList<>();
        NUM_EQUAL = new int[10];
        
        // 카드 정보 입력
        for(int i = 0; i < 5; i++) {
            String s = sc.next();
            int n = sc.nextInt();
            
            list.add(new Card(s, n));
        }
        
        // 정렬
        Collections.sort(list);
        
        for(int i = 0; i < 5; i++) {
            Card check = list.get(i);
            
            //숫자 몇개 동일한지
            NUM_EQUAL[check.num] += 1;
            
            //카드 숫자 MAX 확인
            MAX = Math.max(MAX,check.num);
            
            // 숫자 체크
            if(!NUMBER.contains(check.num)) {
                NUMBER.add(check.num);
            }
            
            // 색 체크
            if(!COLOR.contains(check.color)) {
                COLOR.add(check.color);
            }
        }
        
        // 조건 체크
        // 조건 4 : 모두 같은 색
        if(COLOR.size() == 1) {
            ANSWER = Math.max(ANSWER, (MAX+600));
        }
        
        if(NUMBER.size() == 5) {
            int n = Math.abs(NUMBER.get(0) - NUMBER.get(4));
            
            // 조건 1 : 모두 같은 색이면서 연속적인 숫자
            if(n==4 && COLOR.size() ==1) {
                ANSWER = Math.max(ANSWER, (MAX+900));
            }
            
            // 조건 5 : 숫자 5장 연속적
            if(n==4) {
                ANSWER = Math.max(ANSWER, (MAX+500));
            }
        }
        
        if(NUMBER.size() == 2) {
            // 조건 2 : 숫자 4장 동일
            if(NUM_EQUAL[NUMBER.get(0)]==4) {
                ANSWER = Math.max(ANSWER, (NUMBER.get(0)+800));
            } else if (NUM_EQUAL[NUMBER.get(1)]==4) {
                ANSWER = Math.max(ANSWER, (NUMBER.get(1)+800));
            }
            
            // 조건 3 : 숫자 3장, 2장 동일
            if(NUM_EQUAL[NUMBER.get(0)]==3 && NUM_EQUAL[NUMBER.get(1)]==2) {
                ANSWER = Math.max(ANSWER, ((NUMBER.get(0)*10) + NUMBER.get(1) + 700));
            } else if (NUM_EQUAL[NUMBER.get(0)]==2 && NUM_EQUAL[NUMBER.get(1)]==3) {
                ANSWER = Math.max(ANSWER, ((NUMBER.get(1)*10) + NUMBER.get(0) + 700));
            }
        } else if(NUMBER.size() == 3) {
            // 조건 6 : 숫자 3장 동일
            if(NUM_EQUAL[NUMBER.get(0)]==3) {
                ANSWER = Math.max(ANSWER, (NUMBER.get(0)+400));
            } else if(NUM_EQUAL[NUMBER.get(1)]==3) {
                ANSWER = Math.max(ANSWER, (NUMBER.get(1)+400));
            } else if(NUM_EQUAL[NUMBER.get(2)]==3) {
                ANSWER = Math.max(ANSWER, (NUMBER.get(2)+400));
            }
            
            // 조건 7 : 숫자 2장, 2장 동일
            if(NUM_EQUAL[NUMBER.get(0)]==2 && NUM_EQUAL[NUMBER.get(1)]==2) {
                ANSWER = Math.max(ANSWER, ((NUMBER.get(1)*10) + NUMBER.get(0) + 300));
            } else if(NUM_EQUAL[NUMBER.get(0)]==2 && NUM_EQUAL[NUMBER.get(2)]==2) {
                ANSWER = Math.max(ANSWER, ((NUMBER.get(2)*10) + NUMBER.get(0) + 300));
            } else if(NUM_EQUAL[NUMBER.get(1)]==2 && NUM_EQUAL[NUMBER.get(2)]==2) {
                ANSWER = Math.max(ANSWER, ((NUMBER.get(2)*10) + NUMBER.get(1) + 300));
            }
        } else if(NUMBER.size() == 4) {
            for(int i = 0; i < NUMBER.size(); i++) {
                if(NUM_EQUAL[NUMBER.get(i)] == 2) {
                    ANSWER = Math.max(ANSWER, (NUMBER.get(i)+200));
                    break;
                }
            }
        }
        
        // 조건 9 : 아무 조건도 해당되지 않음
        if(ANSWER == Integer.MIN_VALUE) {
            ANSWER = MAX + 100;
        }
        
        System.out.println(ANSWER);
    }
}

class Card implements Comparable<Card> {
    String color;
    int num;
    
    public Card(String color, int num) {
        this.color = color;
        this.num = num;
    }
    
    @Override
    public int compareTo(Card c) {
        return this.num-c.num;
    }
}