import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        char[] nums = input.toCharArray();
        int result = 0;
        
        for(int i = 0; i < nums.length; i++) {
            //System.out.print(nums[i]+" ");
            //int num = Character.getNumericValue(nums[i]);
            result += (nums[i] - '0');
        }
        
        System.out.println(result);
    }
}
