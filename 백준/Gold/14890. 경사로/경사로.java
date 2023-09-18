import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L;

    static boolean isPossible(int[] arr) {
        boolean[] visited = new boolean[N];
        for (int i = 1; i < N; i++) {
            // 높이 차이가 1 이상인 경우
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                return false;
            }

            // 오르막길
            if (arr[i] > arr[i - 1]) {
                for (int j = i - 1; j >= i - L; j--) {
                    if (j < 0 || visited[j] || arr[j] != arr[i - 1]) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
            // 내리막길
            else if (arr[i] < arr[i - 1]) {
                for (int j = i; j < i + L; j++) {
                    if (j >= N || visited[j] || arr[j] != arr[i]) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        // 가로방향으로 확인
        for (int i = 0; i < N; i++) {
            if (isPossible(map[i])) {
                result++;
            }
        }

        // 세로방향으로 확인
        for (int i = 0; i < N; i++) {
            int[] col = new int[N];
            for (int j = 0; j < N; j++) {
                col[j] = map[j][i];
            }
            if (isPossible(col)) {
                result++;
            }
        }

        System.out.println(result);
    }
}
