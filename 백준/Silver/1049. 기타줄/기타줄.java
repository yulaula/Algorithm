import java.util.*;

/* 1049 기타줄 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 끊어진 기타줄
        int M = sc.nextInt(); // 기타줄 브랜드 수
        int minValue = Integer.MIN_VALUE;

        int pack =  1001;// 6개 패키지 가격
        int single =  1001;// 낱개 가격

        for(int i = 0; i < M; i++) {
            pack = Math.min(pack, sc.nextInt());
            single = Math.min(single, sc.nextInt());
        }

        int packValue = 0; // 패키지로만 살때
        if(N % 6 == 0) { // 끊어진 기타줄 개수가 6의 배수일 때
            packValue = pack * (N/6);
        } else { // 끊어진 기타줄 개수가 6의 배수가 아닐 때
            packValue = pack * ((N/6) + 1);
        }

        int singleValue = N * single; // 낱개로만 살 때
        int packAndSingle = (pack * (N/6)) + (single * (N % 6)); // 패키지+낱개 같이 살 때

        minValue = Math.min(packValue, singleValue);
        minValue = Math.min(packAndSingle, minValue);

        System.out.println(minValue);
    }
}
