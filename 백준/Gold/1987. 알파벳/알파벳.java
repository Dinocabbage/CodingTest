import java.io.*;
import java.util.*;

public class Main {
    static int R, C, answer;
    static char[][] board;
    static int[] dr, dc;

    public static void solution(int r, int c, String road) {
        boolean isDuplicate = false;

        for(char ch : road.toCharArray()) {
            if(ch == board[r][c]) {
                isDuplicate = true;
            }
        }

        if(isDuplicate) {
            answer = Math.max(answer, road.length());
        }
        else {
            for(int i = 0 ; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                try {
                    solution(nr, nc, road + board[r][c]);
                }
                catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for(int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        dr = new int[] {1, -1, 0, 0};
        dc = new int[] {0, 0, 1, -1};
        answer = 0;

        solution(0, 0,  "");

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
