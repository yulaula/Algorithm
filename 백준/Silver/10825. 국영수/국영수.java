import java.util.*;
class Score implements Comparable<Score>{
    private String name;
    private int korean;
    private int english;
    private int math;
    
    public Score(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english =  english;
        this.math = math;
    }
    @Override
    public int compareTo(Score s) {
        if(this.korean < s.korean) {
            return 1;
        } else if(this.korean == s.korean) {
            if(this.english > s.english) {
                return 1;   
            } else if (this.english == s.english) {
                if(this.math < s.math) {
                    return 1;
                } else if(this.math == s.math) {
                    return this.name.compareTo(s.name);
                }
            }
        }
        return -1;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Score> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();
            list.add(new Score(name, korean, english, math));
            sc.nextLine();
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < n; i++) {
            System.out.println(list.get(i).toString());
        }
            
    }
}