import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int N, H, answer;
    private static int[][] ladder;
    private static boolean isFound;
    private static void connectLadder(int count, int target, int row, int col) {
        if(count == target) {
            if(checkLadder()) {
                isFound = true;
                answer = target;
            }

            return;
        }

        for(int i = row; i <= H; i++) {
            for(int j = (i == row) ? col : 1; j < N; j++) {
                if(ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
                    ladder[i][j] = 1;
                    ladder[i][j + 1] = -1;
                    connectLadder(count + 1, target, i, j + 2);

                    if(isFound) {
                        return;
                    }

                    ladder[i][j] = 0;
                    ladder[i][j + 1] = 0;
                }
            }
        }
    }

    private static boolean checkLadder() {
        for(int i = 1; i <= N; i++) {
            int moveTo = i;

            for(int j = 1; j <= H; j++) {
                moveTo += ladder[j][moveTo];
            }

            if(i != moveTo) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new int[H + 1][N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a][b] = 1;
            ladder[a][b + 1] = -1;
        }

        answer = -1;
        isFound = false;

        for(int i = 0; i <= 3; i++) {
            connectLadder(0, i, 1, 1);

            if(isFound) {
                break;
            }
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}