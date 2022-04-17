import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String result = "";
        String n = sc.nextLine();
        
        int sum = 0;
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if(c >= '0' && c <= '9') {
                sum += (c - '0');
            }
            else {
                list.add(c);
            }
        }
        
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        if(sum != 0) {
            result += (sum + "");
        }
        System.out.println(result);
    }
}
