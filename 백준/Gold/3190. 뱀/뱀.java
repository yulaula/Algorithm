import java.util.*;
import java.io.*;
/*
    게임 시작 시 뱀 몸의 길이 1, 맨 위 맨 왼쪽(1, 1), 처음은 오른쪽을 향함
    매 초 머리를 늘려 이동, 방향 전환(왼쪽 L, 오른쪽 D)도 존재
    사과 유무에 따라 꼬리 유지 or 삭제
    벽이나 몸에 부딪히면 게임 끝
*/
public class Main {
    // 보드 크기, 사과 개수, 방향 변환 횟수
    static int N, K, L;
    // 보드 정보: 0은 빈칸, 1은 사과, 2는 뱀이 차지하는 칸
    static int[][] board;
    // 시간별 방향 전환 정보를 저장 (시간 -> 'L' 또는 'D')
    static Map<Integer, Character> directionInfo = new HashMap<>();
    // 4가지 방향: 우, 하, 좌, 상 (배열 인덱스를 이용하여 현재 방향을 관리)
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 1. 보드 크기, 사과 개수
        N = Integer.parseInt(br.readLine()); // 보드의 크기
        K = Integer.parseInt(br.readLine()); // 사과의 개수
        
        // 2. 사과 위치 (입력 좌표 index-1)
        board = new int[N][N]; 
        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = 1;
        }
        
        // 3. 뱀의 방향 변환 횟수 및 정보 입력
        L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); // 초
            char C = st.nextToken().charAt(0); // 회전 방향(왼쪽L, 오른쪽D)
            directionInfo.put(X, C);
        }
        
        // 4. 초기화: 게임시간, 뱀의 초기 방향(): 우측), 뱀의 위치 관리
        // 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위
        int time = 0;
        int direction = 0; // 초기 방향: 우측 (dx[0], dy[0])
        // 뱀의 몸통 정보를 저장할 자료구조 (앞쪽이 머리)
        Deque<Point> snake = new LinkedList<>();
        snake.add(new Point(0, 0));
        board[0][0] = 2; // 시작 위치에 뱀 표시

        while(true) {
            time++;
            //현재 뱀의 머리 위치 - 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
            Point head = snake.peekFirst();
            int nx = head.x + dx[direction];
            int ny = head.y + dy[direction];
            
            // 5-1. 게임 종료 조건 - 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
            // - 벽을 넘었거나
            // - 뱀이 자기 자신(뱀의 몸통)과 충돌한 경우
            if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 2) {
                break;
            }
            
            // 5-2. 이동한 칸에 사과가 있다면, 사과가 없어지고 꼬리는 움직이지 않는다. (몸길이 늘어남)
            if(board[nx][ny] == 1) {
                board[nx][ny] = 2;
                snake.addFirst(new Point(nx, ny));
            }
            
            // 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. (몸길이 변함 없음)
            else {
                board[nx][ny] = 2;
                snake.addFirst(new Point(nx, ny));
                Point tail = snake.removeLast();
                board[tail.x][tail.y] = 0;
            }
            
            // 5-3. 현재 시간에 맞춰 방향 전환이 있다면 처리
            if(directionInfo.containsKey(time)) {
                char c = directionInfo.get(time);
                if(c == 'L') {
                    // 왼쪽으로 90도 회전 : 인덱스는 (현재방향 + 3) % 4
                    direction = (direction + 3) % 4;
                } else if(c == 'D') {
                    // 오른쪽으로 90도 회전 : 인덱스는 (현재방향 + 1) % 4
                    direction = (direction + 1) % 4;
                }
            }
        }
        // 게임 종료 시간 출력
        bw.write(time + "");
        bw.flush();
        bw.close();
        br.close();
    }
}  

// 좌표 정보를 위한 클래스
class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

