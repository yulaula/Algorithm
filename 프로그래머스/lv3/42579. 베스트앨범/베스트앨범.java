import java.util.*;
class Solution {
    static class Music {
        String genre;
        int play;
        int idx;
        
        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }
          
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genresOrder = new ArrayList<>();
        while(map.size() != 0) {
            String maxGenre = "";
            int max = -1;
            for(String key : map.keySet()) {
                int tmp = map.get(key);
                if(tmp > max) {
                    maxGenre = key;
                    max = tmp;
                }
            }
            genresOrder.add(maxGenre);
            map.remove(maxGenre);
        } 
        
        for(String g : genresOrder) {
            System.out.print(g+" ");
        }
        
        List<Music> result = new ArrayList<>();
        for(String genre : genresOrder) {
            List<Music> list = new ArrayList<>();
            for(int i = 0;i < genres.length; i++) {
                if(genres[i].equals(genre)) {
                    list.add(new Music(genre, plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play); // 내림차순
            result.add(list.get(0));
            if(list.size() > 1) {
                result.add(list.get(1));
            }
        }
        
        int[] answer = new int[result.size()];
        for(int k = 0; k < result.size(); k++) {
            answer[k] = result.get(k).idx;
        }
        return answer;
    }
}