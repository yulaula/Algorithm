import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        String tmp_id = "";
        
        //1 모든 대문자를 대응되는 소문자로 치환합니다.
        tmp_id = new_id.toLowerCase();
        
        //2 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        tmp_id = tmp_id.replaceAll("[^-_.a-z0-9]","");

        
        //3 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다
        int count = 0;
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0 ; i < tmp_id.length(); i++) {
            boolean dot = false;
            char c = tmp_id.charAt(i);   
            if(c == '.') {
                count++;
            } else {
                count = 0;
            }           
            if(count > 1) {
                dot = true;
                --count;
            }            
            if(!dot) {
                sb2.append(c);
            }
        }
        tmp_id = sb2.toString();
        
      
        //4 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        sb2.setLength(0);
        for(int i = 0; i < tmp_id.length(); i++) {
            char c = tmp_id.charAt(i);
            if((i == 0 || i == tmp_id.length()-1) && c == '.')  {
                continue;
            }
            sb2.append(c);
        }
        tmp_id = sb2.toString();
        
        
        //5 빈 문자열이라면, new_id에 "a"를 대입합니다.
       if(tmp_id.equals("")) {
            tmp_id += "a";
        }
        
        
        //6 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        int len = tmp_id.length();
        if(len >= 16) {
            tmp_id = tmp_id.substring(0, 15);
            if(tmp_id.charAt(tmp_id.length()-1) == '.') {
                tmp_id = tmp_id.substring(0, 14);
            }
        }
        //7 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        else if(len <= 2) {
            for(int i = len; i < 3; i++) {
                tmp_id += (tmp_id.charAt(len-1) + "");
            }
        }     
               
        return tmp_id;
    }
}