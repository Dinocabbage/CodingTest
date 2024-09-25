import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, minRetouch;
    private static char[][] board;

    private static void findMinRetouch(int startN, int startM) {
        int retouch = 0;
        boolean flag = true;
        for(int i = startM; i < startM + 8; i++) {
            for(int j = startN; j < startN + 8; j++) {
                if(flag) {
                    if(board[j][i] == 'W') {
                        retouch++;
                    }

                    flag = false;
                }
                else {
                    if(board[j][i] == 'B') {
                        retouch++;
                    }

                    flag = true;
                }
            }
            flag = !flag;
        }

        if(retouch > 32) {
            retouch = 64 - retouch;
        }

        minRetouch = Math.min(minRetouch, retouch);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for(int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        minRetouch = Integer.MAX_VALUE;

        for(int m = 0; m <= M - 8; m++) {
            for(int n = 0; n <= N - 8; n++) {
                findMinRetouch(n, m);
            }
        }

        bw.write(String.valueOf(minRetouch));

        bw.flush();
        bw.close();
        br.close();
    }
}