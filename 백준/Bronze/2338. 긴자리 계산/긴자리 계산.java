import java.util.*;
import java.math.BigInteger;

public class Main
{
    /* 
        긴자리 계산 
        각각의 수는 10진수로 1,000자리를 넘지 않으며 양수와 음수가 모두 주어질 수 있다.
        → 긴 수, int 형은 안되고 BigInteger 사용
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.print(a.multiply(b));
    }
}
