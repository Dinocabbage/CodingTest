import java.io.*;
import java.util.*;

public class Main {
    static int R, C, answer;
    static char[][] board;
    static int[] dr, dc;
    static boolean[] visited;

    public static void solution(int r, int c, int move) {
        visited[board[r][c] - 'A'] = true;
        answer = Math.max(answer, move);

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[board[nr][nc] - 'A']) {
                solution(nr, nc, move + 1);
            }
        }

        visited[board[r][c] - 'A'] = false;
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

        visited = new boolean[26];

        solution(0, 0, 1);

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
