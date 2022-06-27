import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        String tmp_id = "";
        
        //1 모든 대문자를 대응되는 소문자로 치환합니다.
        tmp_id = new_id.toLowerCase();
        
        //2 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tmp_id.length(); i++) {
            char c = tmp_id.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        String tmp_id2 = sb.toString();

        
        //3 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다
        int count = 0;
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0 ; i < tmp_id2.length(); i++) {
            boolean dot = false;
            char c = tmp_id2.charAt(i);   
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
        String tmp_id3 = sb2.toString();
        
      
        //4 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        sb2.setLength(0);
        for(int i = 0; i < tmp_id3.length(); i++) {
            char c = tmp_id3.charAt(i);
            if((i == 0 || i == tmp_id3.length()-1) && c == '.')  {
                continue;
            }
            sb2.append(c);
        }
        String tmp_id4 = sb2.toString();
        
        
        //5 빈 문자열이라면, new_id에 "a"를 대입합니다.
        String tmp_id5 = new String(tmp_id4);
        if(tmp_id5.length() == 0) {
            tmp_id5 += "a";
        }
        
        
        //6 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        String tmp_id6 = new String();
        int len = tmp_id5.length();
        if(len >= 16) {
            tmp_id6 = tmp_id5.substring(0, 15);
            if(tmp_id6.charAt(tmp_id6.length()-1) == '.') {
                tmp_id6 = tmp_id6.substring(0, 14);
            }
        }
        //7 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        else if(len <= 2) {
            tmp_id6 = tmp_id5;
            for(int i = len; i < 3; i++) {
                tmp_id6 += (tmp_id6.charAt(len-1) + "");
            }
        }
        else {
           tmp_id6 = tmp_id5;
        }        
               
        return tmp_id6;
    }
}