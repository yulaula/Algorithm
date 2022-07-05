import java.util.*;
public class Main {
    /*
        N       리스트에 있는 점수
        taesu   태수의 새로운 점수
        P       랭킹 리스트에 올라갈 수 있는 점수의 개수
        - 몇 등 하는지 출력
        - 랭킹리스트에 올라갈 수 없을 때 -1 출력
    */
    static int N, taesu, P;
    static List<Integer> list;
    static List<Integer> result;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        taesu = sc.nextInt();
        P = sc.nextInt();
        list = new ArrayList<Integer>();
        result = new ArrayList<Integer>();
        int ans = 0;
        
        for(int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            list.add(tmp);
        }
        
        // 랭킹이 꽉 찼을 때
        int last = N-1;
        if(N == P && list.get(last) >= taesu) {
            // 점수가 랭킹에 올라갈 수 없을 정도 -1
            ans = -1;
        }
        // 랭킹에 올라갈 수 있다
        else {
            list.add(taesu);
            Collections.sort(list, Collections.reverseOrder());
            for(int j = 0; j < P; j++) {
                if(list.get(j) == taesu) {
                    ans = j+1;
                    break;
                }
            }
        
        }
        System.out.println(ans);
    }
}