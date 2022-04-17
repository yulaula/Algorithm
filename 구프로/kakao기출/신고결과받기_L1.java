import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Set<String> reportSet = new HashSet<>();
        Map<String, List<String>> reportMap = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();
        
        // 중복신고 삭제
        for(int i = 0; i < report.length; i++) {
            reportSet.add(report[i]);
        }
        
        String[][] arr = new String[reportSet.size()][2];
        Iterator<String> it = reportSet.iterator();
        
        // 신고 현황 arr에 저장
        for(int i = 0; i < reportSet.size() && it.hasNext(); i++) {
            String tmp = it.next();
            arr[i] = tmp.split(" ");
        }
        for(String s : id_list) {
            reportMap.put(s, new ArrayList<>());
            resultMap.put(s, 0);
        }
        
        // key 신고당한 사람 , value 신고한 사람 리스트
        for(int i = 0; i < arr.length; i++) {
            if(reportMap.containsKey(arr[i][1])) {
                reportMap.get(arr[i][1]).add(arr[i][0]);
            }
        }
       
        // 신고한 사람 리스트 사이즈가 k와 같거나 크다면
        // 신고한 사람이 몇번 메일을 받았는지 저장
        for (String key : reportMap.keySet()){
            List<String> value = reportMap.get(key);
            if(value.size() >= k) {
                for(int i = 0; i < value.size(); i ++) {
                    String tmp = value.get(i);
                    //System.out.println("result "+resultMap.get(tmp));
                    resultMap.put(tmp, resultMap.get(tmp) + 1);
                }
            }
        }
        
        for(int i = 0; i < id_list.length; i++) {
            String key = id_list[i];
            if(resultMap.containsKey(key)) {
                answer[i] = resultMap.get(key);
            }
        }
        //System.out.println(reportMap.toString());
        //System.out.println(resultMap.toString());
        return answer;
    }
}
