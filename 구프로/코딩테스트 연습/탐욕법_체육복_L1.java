import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
		
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		// 여벌 체육복을 가져온 학생이 도난당한 경우
		for(int i = 0; i < lost.length; i++) {
			for(int j = 0; j < reserve.length; j++) {
				if(lost[i] == reserve[j]) {
					answer++;
					lost[i] = -1; // 도난당한 대상에서 제외
					reserve[j] = -1; // 여벌 목록에서 제외
					break;
				}
			}
		}
			
		// 도난당한 학생에게 체육복을 빌려주는 경우
		for(int i = 0; i < lost.length; i++) {
			for(int j = 0; j < reserve.length; j++) {
				if(lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]) {
					answer++; // 수업들을 수 있는 학생 수 +
					reserve[j] = -1; // 빌려줬으니 더이상 빌려 줄 수 없다
					break;
				}
			}
		}
		
		return answer;
    }
}


// 다른 사람 풀이
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) 
            people[l-1]--;
        for (int r : reserve) 
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else 
                    answer--;
            }
        }
        return answer;
    }
}
