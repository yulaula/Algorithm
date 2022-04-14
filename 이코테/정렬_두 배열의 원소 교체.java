import java.util.*;
public class Main {
    /*
    public static void sorting(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int max_index = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[max_index] < arr[j]) {
                    max_index = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[max_index];
            arr[max_index] = tmp;
        }
    }
    */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        
        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        for(int i = 0; i < k; i++) {
            if(arr1[i] < arr2[i]) {
                int tmp = arr2[i];
                arr2[i] = arr1[i];
                arr1[i] = tmp;
            }
            else {
                break;
            }
        }
        
        int result = 0;
        for(int i = 0; i < n; i++) {
            result += arr1[i];
        }
        
        System.out.println(result);
    }
}
