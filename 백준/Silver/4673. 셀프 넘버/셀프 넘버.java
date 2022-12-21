public class Main {
    
    /* 4673 셀프 넘버 */
    public static void main(String[] args) {
        boolean[] isNotSelfNum = new boolean[10001]; 

        for(int i = 1; i < 10001; i++) {
            int N = d(i);
            
            if(N < 10001) {
                isNotSelfNum[N] = true; // 셀프넘버 아닐경우 true
            }
        }

        for(int i = 1; i < 10001; i++) {
            if(isNotSelfNum[i] == false) { // 셀프넘버 출력
                System.out.println(i);
            }
        }
    }

    private static int d(int num) {
        int sum = num;

        while(num != 0) {
            sum += (num % 10); // 맨 앞에 있는 자리수의 숫자
            num = num/10;
        }

        return sum;
    }
}
