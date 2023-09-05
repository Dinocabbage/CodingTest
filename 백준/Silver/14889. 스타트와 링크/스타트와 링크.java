import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static int[][] ability;
    static boolean[] isUsed;

    public static void teamBuilding(int index, int selected) {
        if(selected == N / 2) {
            int teamA = 0;
            int teamB = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i != j && isUsed[i] && isUsed[j]) {
                        teamA += ability[i][j];
                    } else if (i != j && !isUsed[i] && !isUsed[j]) {
                        teamB += ability[i][j];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(teamA - teamB));

            return;
        }

        if (index == N) {
            return;
        }

        isUsed[index] = true;
        teamBuilding(index + 1, selected + 1);

        isUsed[index] = false;
        teamBuilding(index + 1, selected);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        ability = new int[N][N];

        for(int i = 0; i < N; i++) {
            ability[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        answer = Integer.MAX_VALUE;
        isUsed = new boolean[N];

        teamBuilding(0, 0);

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
