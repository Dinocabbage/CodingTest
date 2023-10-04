import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int R, C, upperAirPurifier, lowerAirPurifier;
    static int[][] room;

    private static void dustDiffusion() {
        int[][] diffusedDust = new int[R + 1][C + 1];

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                if(room[i][j] > 0) {
                    int diffuseAmount = room[i][j] / 5;
                    int diffusedCount = 0;

                    for(int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if(nr > 0 && nr <= R && nc > 0 && nc <= C && room[nr][nc] != -1) {
                            diffusedDust[nr][nc] += diffuseAmount;
                            diffusedCount++;
                        }
                    }

                    room[i][j] -= diffuseAmount * diffusedCount;
                }
            }
        }

        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                room[i][j] += diffusedDust[i][j];
            }
        }
    }

    private static void operateAirPurifier() {
        for(int i = upperAirPurifier - 1; i > 1; i--) {
            room[i][1] = room[i - 1][1];
        }

        for(int i = 1; i < C; i++) {
            room[1][i] = room[1][i + 1];
        }

        for(int i = 1; i < upperAirPurifier; i++) {
            room[i][C] = room[i + 1][C];
        }

        for(int i = C; i > 2; i--) {
            room[upperAirPurifier][i] = room[upperAirPurifier][i - 1];
        }

        room[upperAirPurifier][2] = 0;

        for(int i = lowerAirPurifier + 1; i < R; i++) {
            room[i][1] = room[i + 1][1];
        }

        for(int i = 1; i < C; i++) {
            room[R][i] = room[R][i + 1];
        }

        for(int i = R; i > lowerAirPurifier; i--) {
            room[i][C] = room[i - 1][C];
        }

        for(int i = C; i > 2; i--) {
            room[lowerAirPurifier][i] = room[lowerAirPurifier][i - 1];
        }

        room[lowerAirPurifier][2] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        room = new int[R + 1][C + 1];

        for(int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());

                if(room[i][j] == -1) {
                    if(upperAirPurifier == 0) {
                        upperAirPurifier = i;
                    }
                    else {
                        lowerAirPurifier = i;
                    }
                }
            }
        }

        for(int i = 0; i < T; i++) {
            dustDiffusion();
            operateAirPurifier();
        }

        bw.write(String.valueOf(Arrays.stream(room).flatMapToInt(Arrays::stream).sum() + 2));

        bw.flush();
        bw.close();
        br.close();
    }
}