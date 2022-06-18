import java.util.*;
public class Main {
    static int k, max, min;
    static char[] arr;
    static boolean[] check = new boolean[10];
    static List<String> list = new ArrayList<>();
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        k = sc.nextInt(); // 부등호 갯수
        arr = new char[k];
        for(int i = 0; i < k; i++) {
            arr[i] = sc.next().charAt(0);
        }
        
        dfs("", 0);
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }
    public static void dfs(String num, int depth) {
        if(k+1 == depth) {
            list.add(num);
            return;
        }
        
        for(int i = 0; i <= 9; i++) {
            if(depth == 0 || !check[i] && compare(num.charAt(num.length()-1) - '0', i, arr[depth-1])) {
                check[i] = true;
                dfs(num+i, depth+1);
                check[i] = false;
            }
        }
    }
    public static boolean compare(int a, int b, int c) {
        if(c == '<') {
            return a < b;
        } else {
            return a > b;
        }
    }
}